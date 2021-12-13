/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sales.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.sales.exception.NoSuchSaleTypeException;
import com.liferay.sales.model.SaleType;
import com.liferay.sales.model.impl.SaleTypeImpl;
import com.liferay.sales.model.impl.SaleTypeModelImpl;
import com.liferay.sales.service.persistence.SaleTypePersistence;
import com.liferay.sales.service.persistence.impl.constants.SalesTaxePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the sale type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SaleTypePersistence.class)
public class SaleTypePersistenceImpl
	extends BasePersistenceImpl<SaleType> implements SaleTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SaleTypeUtil</code> to access the sale type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SaleTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns the sale type where name = &#63; or throws a <code>NoSuchSaleTypeException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching sale type
	 * @throws NoSuchSaleTypeException if a matching sale type could not be found
	 */
	@Override
	public SaleType findByName(String name) throws NoSuchSaleTypeException {
		SaleType saleType = fetchByName(name);

		if (saleType == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSaleTypeException(sb.toString());
		}

		return saleType;
	}

	/**
	 * Returns the sale type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching sale type, or <code>null</code> if a matching sale type could not be found
	 */
	@Override
	public SaleType fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the sale type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sale type, or <code>null</code> if a matching sale type could not be found
	 */
	@Override
	public SaleType fetchByName(String name, boolean useFinderCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByName, finderArgs, this);
		}

		if (result instanceof SaleType) {
			SaleType saleType = (SaleType)result;

			if (!Objects.equals(name, saleType.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SALETYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				List<SaleType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"SaleTypePersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SaleType saleType = list.get(0);

					result = saleType;

					cacheResult(saleType);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SaleType)result;
		}
	}

	/**
	 * Removes the sale type where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the sale type that was removed
	 */
	@Override
	public SaleType removeByName(String name) throws NoSuchSaleTypeException {
		SaleType saleType = findByName(name);

		return remove(saleType);
	}

	/**
	 * Returns the number of sale types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching sale types
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SALETYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"saleType.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(saleType.name IS NULL OR saleType.name = '')";

	public SaleTypePersistenceImpl() {
		setModelClass(SaleType.class);

		setModelImplClass(SaleTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sale type in the entity cache if it is enabled.
	 *
	 * @param saleType the sale type
	 */
	@Override
	public void cacheResult(SaleType saleType) {
		entityCache.putResult(
			SaleTypeImpl.class, saleType.getPrimaryKey(), saleType);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {saleType.getName()},
			saleType);
	}

	/**
	 * Caches the sale types in the entity cache if it is enabled.
	 *
	 * @param saleTypes the sale types
	 */
	@Override
	public void cacheResult(List<SaleType> saleTypes) {
		for (SaleType saleType : saleTypes) {
			if (entityCache.getResult(
					SaleTypeImpl.class, saleType.getPrimaryKey()) == null) {

				cacheResult(saleType);
			}
		}
	}

	/**
	 * Clears the cache for all sale types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SaleTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sale type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SaleType saleType) {
		entityCache.removeResult(SaleTypeImpl.class, saleType);
	}

	@Override
	public void clearCache(List<SaleType> saleTypes) {
		for (SaleType saleType : saleTypes) {
			entityCache.removeResult(SaleTypeImpl.class, saleType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SaleTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SaleTypeModelImpl saleTypeModelImpl) {

		Object[] args = new Object[] {saleTypeModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByName, args, saleTypeModelImpl, false);
	}

	/**
	 * Creates a new sale type with the primary key. Does not add the sale type to the database.
	 *
	 * @param typeId the primary key for the new sale type
	 * @return the new sale type
	 */
	@Override
	public SaleType create(long typeId) {
		SaleType saleType = new SaleTypeImpl();

		saleType.setNew(true);
		saleType.setPrimaryKey(typeId);

		return saleType;
	}

	/**
	 * Removes the sale type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeId the primary key of the sale type
	 * @return the sale type that was removed
	 * @throws NoSuchSaleTypeException if a sale type with the primary key could not be found
	 */
	@Override
	public SaleType remove(long typeId) throws NoSuchSaleTypeException {
		return remove((Serializable)typeId);
	}

	/**
	 * Removes the sale type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sale type
	 * @return the sale type that was removed
	 * @throws NoSuchSaleTypeException if a sale type with the primary key could not be found
	 */
	@Override
	public SaleType remove(Serializable primaryKey)
		throws NoSuchSaleTypeException {

		Session session = null;

		try {
			session = openSession();

			SaleType saleType = (SaleType)session.get(
				SaleTypeImpl.class, primaryKey);

			if (saleType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSaleTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(saleType);
		}
		catch (NoSuchSaleTypeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SaleType removeImpl(SaleType saleType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(saleType)) {
				saleType = (SaleType)session.get(
					SaleTypeImpl.class, saleType.getPrimaryKeyObj());
			}

			if (saleType != null) {
				session.delete(saleType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (saleType != null) {
			clearCache(saleType);
		}

		return saleType;
	}

	@Override
	public SaleType updateImpl(SaleType saleType) {
		boolean isNew = saleType.isNew();

		if (!(saleType instanceof SaleTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(saleType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(saleType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in saleType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SaleType implementation " +
					saleType.getClass());
		}

		SaleTypeModelImpl saleTypeModelImpl = (SaleTypeModelImpl)saleType;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(saleType);
			}
			else {
				saleType = (SaleType)session.merge(saleType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SaleTypeImpl.class, saleTypeModelImpl, false, true);

		cacheUniqueFindersCache(saleTypeModelImpl);

		if (isNew) {
			saleType.setNew(false);
		}

		saleType.resetOriginalValues();

		return saleType;
	}

	/**
	 * Returns the sale type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sale type
	 * @return the sale type
	 * @throws NoSuchSaleTypeException if a sale type with the primary key could not be found
	 */
	@Override
	public SaleType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSaleTypeException {

		SaleType saleType = fetchByPrimaryKey(primaryKey);

		if (saleType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSaleTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return saleType;
	}

	/**
	 * Returns the sale type with the primary key or throws a <code>NoSuchSaleTypeException</code> if it could not be found.
	 *
	 * @param typeId the primary key of the sale type
	 * @return the sale type
	 * @throws NoSuchSaleTypeException if a sale type with the primary key could not be found
	 */
	@Override
	public SaleType findByPrimaryKey(long typeId)
		throws NoSuchSaleTypeException {

		return findByPrimaryKey((Serializable)typeId);
	}

	/**
	 * Returns the sale type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeId the primary key of the sale type
	 * @return the sale type, or <code>null</code> if a sale type with the primary key could not be found
	 */
	@Override
	public SaleType fetchByPrimaryKey(long typeId) {
		return fetchByPrimaryKey((Serializable)typeId);
	}

	/**
	 * Returns all the sale types.
	 *
	 * @return the sale types
	 */
	@Override
	public List<SaleType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sale types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale types
	 * @param end the upper bound of the range of sale types (not inclusive)
	 * @return the range of sale types
	 */
	@Override
	public List<SaleType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sale types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale types
	 * @param end the upper bound of the range of sale types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sale types
	 */
	@Override
	public List<SaleType> findAll(
		int start, int end, OrderByComparator<SaleType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sale types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale types
	 * @param end the upper bound of the range of sale types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sale types
	 */
	@Override
	public List<SaleType> findAll(
		int start, int end, OrderByComparator<SaleType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<SaleType> list = null;

		if (useFinderCache) {
			list = (List<SaleType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SALETYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SALETYPE;

				sql = sql.concat(SaleTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SaleType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sale types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SaleType saleType : findAll()) {
			remove(saleType);
		}
	}

	/**
	 * Returns the number of sale types.
	 *
	 * @return the number of sale types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SALETYPE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "typeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SALETYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SaleTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sale type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new SaleTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SaleType.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SaleTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = SalesTaxePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SalesTaxePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SalesTaxePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SALETYPE =
		"SELECT saleType FROM SaleType saleType";

	private static final String _SQL_SELECT_SALETYPE_WHERE =
		"SELECT saleType FROM SaleType saleType WHERE ";

	private static final String _SQL_COUNT_SALETYPE =
		"SELECT COUNT(saleType) FROM SaleType saleType";

	private static final String _SQL_COUNT_SALETYPE_WHERE =
		"SELECT COUNT(saleType) FROM SaleType saleType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "saleType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SaleType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SaleType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SaleTypePersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class SaleTypeModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			SaleTypeModelImpl saleTypeModelImpl = (SaleTypeModelImpl)baseModel;

			long columnBitmask = saleTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(saleTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						saleTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(saleTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SaleTypeModelImpl saleTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = saleTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = saleTypeModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}