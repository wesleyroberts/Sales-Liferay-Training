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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.sales.exception.NoSuchSaleCartException;
import com.liferay.sales.model.SaleCart;
import com.liferay.sales.model.impl.SaleCartImpl;
import com.liferay.sales.model.impl.SaleCartModelImpl;
import com.liferay.sales.service.persistence.SaleCartPersistence;
import com.liferay.sales.service.persistence.impl.constants.SalesTaxePersistenceConstants;

import java.io.Serializable;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the sale cart service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SaleCartPersistence.class)
public class SaleCartPersistenceImpl
	extends BasePersistenceImpl<SaleCart> implements SaleCartPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SaleCartUtil</code> to access the sale cart persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SaleCartImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SaleCartPersistenceImpl() {
		setModelClass(SaleCart.class);

		setModelImplClass(SaleCartImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sale cart in the entity cache if it is enabled.
	 *
	 * @param saleCart the sale cart
	 */
	@Override
	public void cacheResult(SaleCart saleCart) {
		entityCache.putResult(
			SaleCartImpl.class, saleCart.getPrimaryKey(), saleCart);
	}

	/**
	 * Caches the sale carts in the entity cache if it is enabled.
	 *
	 * @param saleCarts the sale carts
	 */
	@Override
	public void cacheResult(List<SaleCart> saleCarts) {
		for (SaleCart saleCart : saleCarts) {
			if (entityCache.getResult(
					SaleCartImpl.class, saleCart.getPrimaryKey()) == null) {

				cacheResult(saleCart);
			}
		}
	}

	/**
	 * Clears the cache for all sale carts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SaleCartImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sale cart.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SaleCart saleCart) {
		entityCache.removeResult(SaleCartImpl.class, saleCart);
	}

	@Override
	public void clearCache(List<SaleCart> saleCarts) {
		for (SaleCart saleCart : saleCarts) {
			entityCache.removeResult(SaleCartImpl.class, saleCart);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SaleCartImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sale cart with the primary key. Does not add the sale cart to the database.
	 *
	 * @param cartId the primary key for the new sale cart
	 * @return the new sale cart
	 */
	@Override
	public SaleCart create(long cartId) {
		SaleCart saleCart = new SaleCartImpl();

		saleCart.setNew(true);
		saleCart.setPrimaryKey(cartId);

		return saleCart;
	}

	/**
	 * Removes the sale cart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cartId the primary key of the sale cart
	 * @return the sale cart that was removed
	 * @throws NoSuchSaleCartException if a sale cart with the primary key could not be found
	 */
	@Override
	public SaleCart remove(long cartId) throws NoSuchSaleCartException {
		return remove((Serializable)cartId);
	}

	/**
	 * Removes the sale cart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sale cart
	 * @return the sale cart that was removed
	 * @throws NoSuchSaleCartException if a sale cart with the primary key could not be found
	 */
	@Override
	public SaleCart remove(Serializable primaryKey)
		throws NoSuchSaleCartException {

		Session session = null;

		try {
			session = openSession();

			SaleCart saleCart = (SaleCart)session.get(
				SaleCartImpl.class, primaryKey);

			if (saleCart == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSaleCartException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(saleCart);
		}
		catch (NoSuchSaleCartException noSuchEntityException) {
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
	protected SaleCart removeImpl(SaleCart saleCart) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(saleCart)) {
				saleCart = (SaleCart)session.get(
					SaleCartImpl.class, saleCart.getPrimaryKeyObj());
			}

			if (saleCart != null) {
				session.delete(saleCart);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (saleCart != null) {
			clearCache(saleCart);
		}

		return saleCart;
	}

	@Override
	public SaleCart updateImpl(SaleCart saleCart) {
		boolean isNew = saleCart.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(saleCart);
			}
			else {
				saleCart = (SaleCart)session.merge(saleCart);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SaleCartImpl.class, saleCart, false, true);

		if (isNew) {
			saleCart.setNew(false);
		}

		saleCart.resetOriginalValues();

		return saleCart;
	}

	/**
	 * Returns the sale cart with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sale cart
	 * @return the sale cart
	 * @throws NoSuchSaleCartException if a sale cart with the primary key could not be found
	 */
	@Override
	public SaleCart findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSaleCartException {

		SaleCart saleCart = fetchByPrimaryKey(primaryKey);

		if (saleCart == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSaleCartException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return saleCart;
	}

	/**
	 * Returns the sale cart with the primary key or throws a <code>NoSuchSaleCartException</code> if it could not be found.
	 *
	 * @param cartId the primary key of the sale cart
	 * @return the sale cart
	 * @throws NoSuchSaleCartException if a sale cart with the primary key could not be found
	 */
	@Override
	public SaleCart findByPrimaryKey(long cartId)
		throws NoSuchSaleCartException {

		return findByPrimaryKey((Serializable)cartId);
	}

	/**
	 * Returns the sale cart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cartId the primary key of the sale cart
	 * @return the sale cart, or <code>null</code> if a sale cart with the primary key could not be found
	 */
	@Override
	public SaleCart fetchByPrimaryKey(long cartId) {
		return fetchByPrimaryKey((Serializable)cartId);
	}

	/**
	 * Returns all the sale carts.
	 *
	 * @return the sale carts
	 */
	@Override
	public List<SaleCart> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sale carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleCartModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale carts
	 * @param end the upper bound of the range of sale carts (not inclusive)
	 * @return the range of sale carts
	 */
	@Override
	public List<SaleCart> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sale carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleCartModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale carts
	 * @param end the upper bound of the range of sale carts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sale carts
	 */
	@Override
	public List<SaleCart> findAll(
		int start, int end, OrderByComparator<SaleCart> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sale carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleCartModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale carts
	 * @param end the upper bound of the range of sale carts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sale carts
	 */
	@Override
	public List<SaleCart> findAll(
		int start, int end, OrderByComparator<SaleCart> orderByComparator,
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

		List<SaleCart> list = null;

		if (useFinderCache) {
			list = (List<SaleCart>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SALECART);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SALECART;

				sql = sql.concat(SaleCartModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SaleCart>)QueryUtil.list(
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
	 * Removes all the sale carts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SaleCart saleCart : findAll()) {
			remove(saleCart);
		}
	}

	/**
	 * Returns the number of sale carts.
	 *
	 * @return the number of sale carts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SALECART);

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
		return "cartId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SALECART;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SaleCartModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sale cart persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new SaleCartModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SaleCart.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SaleCartImpl.class.getName());

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

	private static final String _SQL_SELECT_SALECART =
		"SELECT saleCart FROM SaleCart saleCart";

	private static final String _SQL_COUNT_SALECART =
		"SELECT COUNT(saleCart) FROM SaleCart saleCart";

	private static final String _ORDER_BY_ENTITY_ALIAS = "saleCart.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SaleCart exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SaleCartPersistenceImpl.class);

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

	private static class SaleCartModelArgumentsResolver
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

			SaleCartModelImpl saleCartModelImpl = (SaleCartModelImpl)baseModel;

			long columnBitmask = saleCartModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(saleCartModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						saleCartModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(saleCartModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SaleCartModelImpl saleCartModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = saleCartModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = saleCartModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}