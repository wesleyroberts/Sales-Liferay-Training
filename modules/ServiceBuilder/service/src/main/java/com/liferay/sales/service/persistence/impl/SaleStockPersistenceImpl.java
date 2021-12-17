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
import com.liferay.sales.exception.NoSuchSaleStockException;
import com.liferay.sales.model.SaleStock;
import com.liferay.sales.model.impl.SaleStockImpl;
import com.liferay.sales.model.impl.SaleStockModelImpl;
import com.liferay.sales.service.persistence.SaleStockPersistence;
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
 * The persistence implementation for the sale stock service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SaleStockPersistence.class)
public class SaleStockPersistenceImpl
	extends BasePersistenceImpl<SaleStock> implements SaleStockPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SaleStockUtil</code> to access the sale stock persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SaleStockImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SaleStockPersistenceImpl() {
		setModelClass(SaleStock.class);

		setModelImplClass(SaleStockImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sale stock in the entity cache if it is enabled.
	 *
	 * @param saleStock the sale stock
	 */
	@Override
	public void cacheResult(SaleStock saleStock) {
		entityCache.putResult(
			SaleStockImpl.class, saleStock.getPrimaryKey(), saleStock);
	}

	/**
	 * Caches the sale stocks in the entity cache if it is enabled.
	 *
	 * @param saleStocks the sale stocks
	 */
	@Override
	public void cacheResult(List<SaleStock> saleStocks) {
		for (SaleStock saleStock : saleStocks) {
			if (entityCache.getResult(
					SaleStockImpl.class, saleStock.getPrimaryKey()) == null) {

				cacheResult(saleStock);
			}
		}
	}

	/**
	 * Clears the cache for all sale stocks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SaleStockImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sale stock.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SaleStock saleStock) {
		entityCache.removeResult(SaleStockImpl.class, saleStock);
	}

	@Override
	public void clearCache(List<SaleStock> saleStocks) {
		for (SaleStock saleStock : saleStocks) {
			entityCache.removeResult(SaleStockImpl.class, saleStock);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SaleStockImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sale stock with the primary key. Does not add the sale stock to the database.
	 *
	 * @param StockId the primary key for the new sale stock
	 * @return the new sale stock
	 */
	@Override
	public SaleStock create(long StockId) {
		SaleStock saleStock = new SaleStockImpl();

		saleStock.setNew(true);
		saleStock.setPrimaryKey(StockId);

		return saleStock;
	}

	/**
	 * Removes the sale stock with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param StockId the primary key of the sale stock
	 * @return the sale stock that was removed
	 * @throws NoSuchSaleStockException if a sale stock with the primary key could not be found
	 */
	@Override
	public SaleStock remove(long StockId) throws NoSuchSaleStockException {
		return remove((Serializable)StockId);
	}

	/**
	 * Removes the sale stock with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sale stock
	 * @return the sale stock that was removed
	 * @throws NoSuchSaleStockException if a sale stock with the primary key could not be found
	 */
	@Override
	public SaleStock remove(Serializable primaryKey)
		throws NoSuchSaleStockException {

		Session session = null;

		try {
			session = openSession();

			SaleStock saleStock = (SaleStock)session.get(
				SaleStockImpl.class, primaryKey);

			if (saleStock == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSaleStockException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(saleStock);
		}
		catch (NoSuchSaleStockException noSuchEntityException) {
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
	protected SaleStock removeImpl(SaleStock saleStock) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(saleStock)) {
				saleStock = (SaleStock)session.get(
					SaleStockImpl.class, saleStock.getPrimaryKeyObj());
			}

			if (saleStock != null) {
				session.delete(saleStock);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (saleStock != null) {
			clearCache(saleStock);
		}

		return saleStock;
	}

	@Override
	public SaleStock updateImpl(SaleStock saleStock) {
		boolean isNew = saleStock.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(saleStock);
			}
			else {
				saleStock = (SaleStock)session.merge(saleStock);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SaleStockImpl.class, saleStock, false, true);

		if (isNew) {
			saleStock.setNew(false);
		}

		saleStock.resetOriginalValues();

		return saleStock;
	}

	/**
	 * Returns the sale stock with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sale stock
	 * @return the sale stock
	 * @throws NoSuchSaleStockException if a sale stock with the primary key could not be found
	 */
	@Override
	public SaleStock findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSaleStockException {

		SaleStock saleStock = fetchByPrimaryKey(primaryKey);

		if (saleStock == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSaleStockException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return saleStock;
	}

	/**
	 * Returns the sale stock with the primary key or throws a <code>NoSuchSaleStockException</code> if it could not be found.
	 *
	 * @param StockId the primary key of the sale stock
	 * @return the sale stock
	 * @throws NoSuchSaleStockException if a sale stock with the primary key could not be found
	 */
	@Override
	public SaleStock findByPrimaryKey(long StockId)
		throws NoSuchSaleStockException {

		return findByPrimaryKey((Serializable)StockId);
	}

	/**
	 * Returns the sale stock with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param StockId the primary key of the sale stock
	 * @return the sale stock, or <code>null</code> if a sale stock with the primary key could not be found
	 */
	@Override
	public SaleStock fetchByPrimaryKey(long StockId) {
		return fetchByPrimaryKey((Serializable)StockId);
	}

	/**
	 * Returns all the sale stocks.
	 *
	 * @return the sale stocks
	 */
	@Override
	public List<SaleStock> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sale stocks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleStockModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale stocks
	 * @param end the upper bound of the range of sale stocks (not inclusive)
	 * @return the range of sale stocks
	 */
	@Override
	public List<SaleStock> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sale stocks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleStockModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale stocks
	 * @param end the upper bound of the range of sale stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sale stocks
	 */
	@Override
	public List<SaleStock> findAll(
		int start, int end, OrderByComparator<SaleStock> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sale stocks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleStockModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale stocks
	 * @param end the upper bound of the range of sale stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sale stocks
	 */
	@Override
	public List<SaleStock> findAll(
		int start, int end, OrderByComparator<SaleStock> orderByComparator,
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

		List<SaleStock> list = null;

		if (useFinderCache) {
			list = (List<SaleStock>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SALESTOCK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SALESTOCK;

				sql = sql.concat(SaleStockModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SaleStock>)QueryUtil.list(
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
	 * Removes all the sale stocks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SaleStock saleStock : findAll()) {
			remove(saleStock);
		}
	}

	/**
	 * Returns the number of sale stocks.
	 *
	 * @return the number of sale stocks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SALESTOCK);

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
		return "StockId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SALESTOCK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SaleStockModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sale stock persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new SaleStockModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SaleStock.class.getName()));

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
		entityCache.removeCache(SaleStockImpl.class.getName());

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

	private static final String _SQL_SELECT_SALESTOCK =
		"SELECT saleStock FROM SaleStock saleStock";

	private static final String _SQL_COUNT_SALESTOCK =
		"SELECT COUNT(saleStock) FROM SaleStock saleStock";

	private static final String _ORDER_BY_ENTITY_ALIAS = "saleStock.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SaleStock exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SaleStockPersistenceImpl.class);

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

	private static class SaleStockModelArgumentsResolver
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

			SaleStockModelImpl saleStockModelImpl =
				(SaleStockModelImpl)baseModel;

			long columnBitmask = saleStockModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(saleStockModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						saleStockModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(saleStockModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SaleStockModelImpl saleStockModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = saleStockModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = saleStockModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}