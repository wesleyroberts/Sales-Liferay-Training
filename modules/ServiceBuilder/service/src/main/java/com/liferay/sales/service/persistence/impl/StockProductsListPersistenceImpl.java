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
import com.liferay.sales.exception.NoSuchStockProductsListException;
import com.liferay.sales.model.StockProductsList;
import com.liferay.sales.model.impl.StockProductsListImpl;
import com.liferay.sales.model.impl.StockProductsListModelImpl;
import com.liferay.sales.service.persistence.StockProductsListPersistence;
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
 * The persistence implementation for the stock products list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StockProductsListPersistence.class)
public class StockProductsListPersistenceImpl
	extends BasePersistenceImpl<StockProductsList>
	implements StockProductsListPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StockProductsListUtil</code> to access the stock products list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StockProductsListImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StockProductsListPersistenceImpl() {
		setModelClass(StockProductsList.class);

		setModelImplClass(StockProductsListImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the stock products list in the entity cache if it is enabled.
	 *
	 * @param stockProductsList the stock products list
	 */
	@Override
	public void cacheResult(StockProductsList stockProductsList) {
		entityCache.putResult(
			StockProductsListImpl.class, stockProductsList.getPrimaryKey(),
			stockProductsList);
	}

	/**
	 * Caches the stock products lists in the entity cache if it is enabled.
	 *
	 * @param stockProductsLists the stock products lists
	 */
	@Override
	public void cacheResult(List<StockProductsList> stockProductsLists) {
		for (StockProductsList stockProductsList : stockProductsLists) {
			if (entityCache.getResult(
					StockProductsListImpl.class,
					stockProductsList.getPrimaryKey()) == null) {

				cacheResult(stockProductsList);
			}
		}
	}

	/**
	 * Clears the cache for all stock products lists.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StockProductsListImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stock products list.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StockProductsList stockProductsList) {
		entityCache.removeResult(
			StockProductsListImpl.class, stockProductsList);
	}

	@Override
	public void clearCache(List<StockProductsList> stockProductsLists) {
		for (StockProductsList stockProductsList : stockProductsLists) {
			entityCache.removeResult(
				StockProductsListImpl.class, stockProductsList);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StockProductsListImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new stock products list with the primary key. Does not add the stock products list to the database.
	 *
	 * @param productId the primary key for the new stock products list
	 * @return the new stock products list
	 */
	@Override
	public StockProductsList create(long productId) {
		StockProductsList stockProductsList = new StockProductsListImpl();

		stockProductsList.setNew(true);
		stockProductsList.setPrimaryKey(productId);

		return stockProductsList;
	}

	/**
	 * Removes the stock products list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the stock products list
	 * @return the stock products list that was removed
	 * @throws NoSuchStockProductsListException if a stock products list with the primary key could not be found
	 */
	@Override
	public StockProductsList remove(long productId)
		throws NoSuchStockProductsListException {

		return remove((Serializable)productId);
	}

	/**
	 * Removes the stock products list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stock products list
	 * @return the stock products list that was removed
	 * @throws NoSuchStockProductsListException if a stock products list with the primary key could not be found
	 */
	@Override
	public StockProductsList remove(Serializable primaryKey)
		throws NoSuchStockProductsListException {

		Session session = null;

		try {
			session = openSession();

			StockProductsList stockProductsList =
				(StockProductsList)session.get(
					StockProductsListImpl.class, primaryKey);

			if (stockProductsList == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStockProductsListException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stockProductsList);
		}
		catch (NoSuchStockProductsListException noSuchEntityException) {
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
	protected StockProductsList removeImpl(
		StockProductsList stockProductsList) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stockProductsList)) {
				stockProductsList = (StockProductsList)session.get(
					StockProductsListImpl.class,
					stockProductsList.getPrimaryKeyObj());
			}

			if (stockProductsList != null) {
				session.delete(stockProductsList);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stockProductsList != null) {
			clearCache(stockProductsList);
		}

		return stockProductsList;
	}

	@Override
	public StockProductsList updateImpl(StockProductsList stockProductsList) {
		boolean isNew = stockProductsList.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stockProductsList);
			}
			else {
				stockProductsList = (StockProductsList)session.merge(
					stockProductsList);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			StockProductsListImpl.class, stockProductsList, false, true);

		if (isNew) {
			stockProductsList.setNew(false);
		}

		stockProductsList.resetOriginalValues();

		return stockProductsList;
	}

	/**
	 * Returns the stock products list with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stock products list
	 * @return the stock products list
	 * @throws NoSuchStockProductsListException if a stock products list with the primary key could not be found
	 */
	@Override
	public StockProductsList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStockProductsListException {

		StockProductsList stockProductsList = fetchByPrimaryKey(primaryKey);

		if (stockProductsList == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStockProductsListException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stockProductsList;
	}

	/**
	 * Returns the stock products list with the primary key or throws a <code>NoSuchStockProductsListException</code> if it could not be found.
	 *
	 * @param productId the primary key of the stock products list
	 * @return the stock products list
	 * @throws NoSuchStockProductsListException if a stock products list with the primary key could not be found
	 */
	@Override
	public StockProductsList findByPrimaryKey(long productId)
		throws NoSuchStockProductsListException {

		return findByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns the stock products list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the stock products list
	 * @return the stock products list, or <code>null</code> if a stock products list with the primary key could not be found
	 */
	@Override
	public StockProductsList fetchByPrimaryKey(long productId) {
		return fetchByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns all the stock products lists.
	 *
	 * @return the stock products lists
	 */
	@Override
	public List<StockProductsList> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stock products lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockProductsListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stock products lists
	 * @param end the upper bound of the range of stock products lists (not inclusive)
	 * @return the range of stock products lists
	 */
	@Override
	public List<StockProductsList> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stock products lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockProductsListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stock products lists
	 * @param end the upper bound of the range of stock products lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stock products lists
	 */
	@Override
	public List<StockProductsList> findAll(
		int start, int end,
		OrderByComparator<StockProductsList> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stock products lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockProductsListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stock products lists
	 * @param end the upper bound of the range of stock products lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of stock products lists
	 */
	@Override
	public List<StockProductsList> findAll(
		int start, int end,
		OrderByComparator<StockProductsList> orderByComparator,
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

		List<StockProductsList> list = null;

		if (useFinderCache) {
			list = (List<StockProductsList>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STOCKPRODUCTSLIST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STOCKPRODUCTSLIST;

				sql = sql.concat(StockProductsListModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StockProductsList>)QueryUtil.list(
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
	 * Removes all the stock products lists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StockProductsList stockProductsList : findAll()) {
			remove(stockProductsList);
		}
	}

	/**
	 * Returns the number of stock products lists.
	 *
	 * @return the number of stock products lists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STOCKPRODUCTSLIST);

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
		return "productId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STOCKPRODUCTSLIST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StockProductsListModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stock products list persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new StockProductsListModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", StockProductsList.class.getName()));

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
		entityCache.removeCache(StockProductsListImpl.class.getName());

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

	private static final String _SQL_SELECT_STOCKPRODUCTSLIST =
		"SELECT stockProductsList FROM StockProductsList stockProductsList";

	private static final String _SQL_COUNT_STOCKPRODUCTSLIST =
		"SELECT COUNT(stockProductsList) FROM StockProductsList stockProductsList";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stockProductsList.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StockProductsList exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StockProductsListPersistenceImpl.class);

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

	private static class StockProductsListModelArgumentsResolver
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

			StockProductsListModelImpl stockProductsListModelImpl =
				(StockProductsListModelImpl)baseModel;

			long columnBitmask = stockProductsListModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					stockProductsListModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						stockProductsListModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					stockProductsListModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			StockProductsListModelImpl stockProductsListModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						stockProductsListModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = stockProductsListModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}