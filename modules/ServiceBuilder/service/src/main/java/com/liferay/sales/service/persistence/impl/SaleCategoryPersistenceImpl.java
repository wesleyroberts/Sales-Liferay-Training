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
import com.liferay.sales.exception.NoSuchSaleCategoryException;
import com.liferay.sales.model.SaleCategory;
import com.liferay.sales.model.impl.SaleCategoryImpl;
import com.liferay.sales.model.impl.SaleCategoryModelImpl;
import com.liferay.sales.service.persistence.SaleCategoryPersistence;
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
 * The persistence implementation for the sale category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SaleCategoryPersistence.class)
public class SaleCategoryPersistenceImpl
	extends BasePersistenceImpl<SaleCategory>
	implements SaleCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SaleCategoryUtil</code> to access the sale category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SaleCategoryImpl.class.getName();

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
	 * Returns the sale category where name = &#63; or throws a <code>NoSuchSaleCategoryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching sale category
	 * @throws NoSuchSaleCategoryException if a matching sale category could not be found
	 */
	@Override
	public SaleCategory findByName(String name)
		throws NoSuchSaleCategoryException {

		SaleCategory saleCategory = fetchByName(name);

		if (saleCategory == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSaleCategoryException(sb.toString());
		}

		return saleCategory;
	}

	/**
	 * Returns the sale category where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching sale category, or <code>null</code> if a matching sale category could not be found
	 */
	@Override
	public SaleCategory fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the sale category where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sale category, or <code>null</code> if a matching sale category could not be found
	 */
	@Override
	public SaleCategory fetchByName(String name, boolean useFinderCache) {
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

		if (result instanceof SaleCategory) {
			SaleCategory saleCategory = (SaleCategory)result;

			if (!Objects.equals(name, saleCategory.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SALECATEGORY_WHERE);

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

				List<SaleCategory> list = query.list();

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
								"SaleCategoryPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SaleCategory saleCategory = list.get(0);

					result = saleCategory;

					cacheResult(saleCategory);
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
			return (SaleCategory)result;
		}
	}

	/**
	 * Removes the sale category where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the sale category that was removed
	 */
	@Override
	public SaleCategory removeByName(String name)
		throws NoSuchSaleCategoryException {

		SaleCategory saleCategory = findByName(name);

		return remove(saleCategory);
	}

	/**
	 * Returns the number of sale categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching sale categories
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SALECATEGORY_WHERE);

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
		"saleCategory.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(saleCategory.name IS NULL OR saleCategory.name = '')";

	public SaleCategoryPersistenceImpl() {
		setModelClass(SaleCategory.class);

		setModelImplClass(SaleCategoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sale category in the entity cache if it is enabled.
	 *
	 * @param saleCategory the sale category
	 */
	@Override
	public void cacheResult(SaleCategory saleCategory) {
		entityCache.putResult(
			SaleCategoryImpl.class, saleCategory.getPrimaryKey(), saleCategory);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {saleCategory.getName()},
			saleCategory);
	}

	/**
	 * Caches the sale categories in the entity cache if it is enabled.
	 *
	 * @param saleCategories the sale categories
	 */
	@Override
	public void cacheResult(List<SaleCategory> saleCategories) {
		for (SaleCategory saleCategory : saleCategories) {
			if (entityCache.getResult(
					SaleCategoryImpl.class, saleCategory.getPrimaryKey()) ==
						null) {

				cacheResult(saleCategory);
			}
		}
	}

	/**
	 * Clears the cache for all sale categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SaleCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sale category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SaleCategory saleCategory) {
		entityCache.removeResult(SaleCategoryImpl.class, saleCategory);
	}

	@Override
	public void clearCache(List<SaleCategory> saleCategories) {
		for (SaleCategory saleCategory : saleCategories) {
			entityCache.removeResult(SaleCategoryImpl.class, saleCategory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SaleCategoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SaleCategoryModelImpl saleCategoryModelImpl) {

		Object[] args = new Object[] {saleCategoryModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByName, args, saleCategoryModelImpl, false);
	}

	/**
	 * Creates a new sale category with the primary key. Does not add the sale category to the database.
	 *
	 * @param categoryId the primary key for the new sale category
	 * @return the new sale category
	 */
	@Override
	public SaleCategory create(long categoryId) {
		SaleCategory saleCategory = new SaleCategoryImpl();

		saleCategory.setNew(true);
		saleCategory.setPrimaryKey(categoryId);

		return saleCategory;
	}

	/**
	 * Removes the sale category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the sale category
	 * @return the sale category that was removed
	 * @throws NoSuchSaleCategoryException if a sale category with the primary key could not be found
	 */
	@Override
	public SaleCategory remove(long categoryId)
		throws NoSuchSaleCategoryException {

		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the sale category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sale category
	 * @return the sale category that was removed
	 * @throws NoSuchSaleCategoryException if a sale category with the primary key could not be found
	 */
	@Override
	public SaleCategory remove(Serializable primaryKey)
		throws NoSuchSaleCategoryException {

		Session session = null;

		try {
			session = openSession();

			SaleCategory saleCategory = (SaleCategory)session.get(
				SaleCategoryImpl.class, primaryKey);

			if (saleCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSaleCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(saleCategory);
		}
		catch (NoSuchSaleCategoryException noSuchEntityException) {
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
	protected SaleCategory removeImpl(SaleCategory saleCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(saleCategory)) {
				saleCategory = (SaleCategory)session.get(
					SaleCategoryImpl.class, saleCategory.getPrimaryKeyObj());
			}

			if (saleCategory != null) {
				session.delete(saleCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (saleCategory != null) {
			clearCache(saleCategory);
		}

		return saleCategory;
	}

	@Override
	public SaleCategory updateImpl(SaleCategory saleCategory) {
		boolean isNew = saleCategory.isNew();

		if (!(saleCategory instanceof SaleCategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(saleCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					saleCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in saleCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SaleCategory implementation " +
					saleCategory.getClass());
		}

		SaleCategoryModelImpl saleCategoryModelImpl =
			(SaleCategoryModelImpl)saleCategory;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(saleCategory);
			}
			else {
				saleCategory = (SaleCategory)session.merge(saleCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SaleCategoryImpl.class, saleCategoryModelImpl, false, true);

		cacheUniqueFindersCache(saleCategoryModelImpl);

		if (isNew) {
			saleCategory.setNew(false);
		}

		saleCategory.resetOriginalValues();

		return saleCategory;
	}

	/**
	 * Returns the sale category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sale category
	 * @return the sale category
	 * @throws NoSuchSaleCategoryException if a sale category with the primary key could not be found
	 */
	@Override
	public SaleCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSaleCategoryException {

		SaleCategory saleCategory = fetchByPrimaryKey(primaryKey);

		if (saleCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSaleCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return saleCategory;
	}

	/**
	 * Returns the sale category with the primary key or throws a <code>NoSuchSaleCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the sale category
	 * @return the sale category
	 * @throws NoSuchSaleCategoryException if a sale category with the primary key could not be found
	 */
	@Override
	public SaleCategory findByPrimaryKey(long categoryId)
		throws NoSuchSaleCategoryException {

		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the sale category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the sale category
	 * @return the sale category, or <code>null</code> if a sale category with the primary key could not be found
	 */
	@Override
	public SaleCategory fetchByPrimaryKey(long categoryId) {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns all the sale categories.
	 *
	 * @return the sale categories
	 */
	@Override
	public List<SaleCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sale categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale categories
	 * @param end the upper bound of the range of sale categories (not inclusive)
	 * @return the range of sale categories
	 */
	@Override
	public List<SaleCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sale categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale categories
	 * @param end the upper bound of the range of sale categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sale categories
	 */
	@Override
	public List<SaleCategory> findAll(
		int start, int end, OrderByComparator<SaleCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sale categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale categories
	 * @param end the upper bound of the range of sale categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sale categories
	 */
	@Override
	public List<SaleCategory> findAll(
		int start, int end, OrderByComparator<SaleCategory> orderByComparator,
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

		List<SaleCategory> list = null;

		if (useFinderCache) {
			list = (List<SaleCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SALECATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SALECATEGORY;

				sql = sql.concat(SaleCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SaleCategory>)QueryUtil.list(
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
	 * Removes all the sale categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SaleCategory saleCategory : findAll()) {
			remove(saleCategory);
		}
	}

	/**
	 * Returns the number of sale categories.
	 *
	 * @return the number of sale categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SALECATEGORY);

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
		return "categoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SALECATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SaleCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sale category persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new SaleCategoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SaleCategory.class.getName()));

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
		entityCache.removeCache(SaleCategoryImpl.class.getName());

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

	private static final String _SQL_SELECT_SALECATEGORY =
		"SELECT saleCategory FROM SaleCategory saleCategory";

	private static final String _SQL_SELECT_SALECATEGORY_WHERE =
		"SELECT saleCategory FROM SaleCategory saleCategory WHERE ";

	private static final String _SQL_COUNT_SALECATEGORY =
		"SELECT COUNT(saleCategory) FROM SaleCategory saleCategory";

	private static final String _SQL_COUNT_SALECATEGORY_WHERE =
		"SELECT COUNT(saleCategory) FROM SaleCategory saleCategory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "saleCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SaleCategory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SaleCategory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SaleCategoryPersistenceImpl.class);

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

	private static class SaleCategoryModelArgumentsResolver
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

			SaleCategoryModelImpl saleCategoryModelImpl =
				(SaleCategoryModelImpl)baseModel;

			long columnBitmask = saleCategoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(saleCategoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						saleCategoryModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(saleCategoryModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SaleCategoryModelImpl saleCategoryModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = saleCategoryModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = saleCategoryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}