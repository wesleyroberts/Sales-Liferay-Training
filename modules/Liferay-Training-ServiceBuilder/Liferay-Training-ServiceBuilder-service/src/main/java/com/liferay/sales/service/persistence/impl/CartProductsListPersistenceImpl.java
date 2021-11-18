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
import com.liferay.sales.exception.NoSuchCartProductsListException;
import com.liferay.sales.model.CartProductsList;
import com.liferay.sales.model.impl.CartProductsListImpl;
import com.liferay.sales.model.impl.CartProductsListModelImpl;
import com.liferay.sales.service.persistence.CartProductsListPersistence;
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
 * The persistence implementation for the cart products list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CartProductsListPersistence.class)
public class CartProductsListPersistenceImpl
	extends BasePersistenceImpl<CartProductsList>
	implements CartProductsListPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CartProductsListUtil</code> to access the cart products list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CartProductsListImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CartProductsListPersistenceImpl() {
		setModelClass(CartProductsList.class);

		setModelImplClass(CartProductsListImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cart products list in the entity cache if it is enabled.
	 *
	 * @param cartProductsList the cart products list
	 */
	@Override
	public void cacheResult(CartProductsList cartProductsList) {
		entityCache.putResult(
			CartProductsListImpl.class, cartProductsList.getPrimaryKey(),
			cartProductsList);
	}

	/**
	 * Caches the cart products lists in the entity cache if it is enabled.
	 *
	 * @param cartProductsLists the cart products lists
	 */
	@Override
	public void cacheResult(List<CartProductsList> cartProductsLists) {
		for (CartProductsList cartProductsList : cartProductsLists) {
			if (entityCache.getResult(
					CartProductsListImpl.class,
					cartProductsList.getPrimaryKey()) == null) {

				cacheResult(cartProductsList);
			}
		}
	}

	/**
	 * Clears the cache for all cart products lists.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CartProductsListImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cart products list.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CartProductsList cartProductsList) {
		entityCache.removeResult(CartProductsListImpl.class, cartProductsList);
	}

	@Override
	public void clearCache(List<CartProductsList> cartProductsLists) {
		for (CartProductsList cartProductsList : cartProductsLists) {
			entityCache.removeResult(
				CartProductsListImpl.class, cartProductsList);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CartProductsListImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new cart products list with the primary key. Does not add the cart products list to the database.
	 *
	 * @param productId the primary key for the new cart products list
	 * @return the new cart products list
	 */
	@Override
	public CartProductsList create(long productId) {
		CartProductsList cartProductsList = new CartProductsListImpl();

		cartProductsList.setNew(true);
		cartProductsList.setPrimaryKey(productId);

		return cartProductsList;
	}

	/**
	 * Removes the cart products list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the cart products list
	 * @return the cart products list that was removed
	 * @throws NoSuchCartProductsListException if a cart products list with the primary key could not be found
	 */
	@Override
	public CartProductsList remove(long productId)
		throws NoSuchCartProductsListException {

		return remove((Serializable)productId);
	}

	/**
	 * Removes the cart products list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cart products list
	 * @return the cart products list that was removed
	 * @throws NoSuchCartProductsListException if a cart products list with the primary key could not be found
	 */
	@Override
	public CartProductsList remove(Serializable primaryKey)
		throws NoSuchCartProductsListException {

		Session session = null;

		try {
			session = openSession();

			CartProductsList cartProductsList = (CartProductsList)session.get(
				CartProductsListImpl.class, primaryKey);

			if (cartProductsList == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCartProductsListException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cartProductsList);
		}
		catch (NoSuchCartProductsListException noSuchEntityException) {
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
	protected CartProductsList removeImpl(CartProductsList cartProductsList) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cartProductsList)) {
				cartProductsList = (CartProductsList)session.get(
					CartProductsListImpl.class,
					cartProductsList.getPrimaryKeyObj());
			}

			if (cartProductsList != null) {
				session.delete(cartProductsList);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cartProductsList != null) {
			clearCache(cartProductsList);
		}

		return cartProductsList;
	}

	@Override
	public CartProductsList updateImpl(CartProductsList cartProductsList) {
		boolean isNew = cartProductsList.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cartProductsList);
			}
			else {
				cartProductsList = (CartProductsList)session.merge(
					cartProductsList);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CartProductsListImpl.class, cartProductsList, false, true);

		if (isNew) {
			cartProductsList.setNew(false);
		}

		cartProductsList.resetOriginalValues();

		return cartProductsList;
	}

	/**
	 * Returns the cart products list with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cart products list
	 * @return the cart products list
	 * @throws NoSuchCartProductsListException if a cart products list with the primary key could not be found
	 */
	@Override
	public CartProductsList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCartProductsListException {

		CartProductsList cartProductsList = fetchByPrimaryKey(primaryKey);

		if (cartProductsList == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCartProductsListException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cartProductsList;
	}

	/**
	 * Returns the cart products list with the primary key or throws a <code>NoSuchCartProductsListException</code> if it could not be found.
	 *
	 * @param productId the primary key of the cart products list
	 * @return the cart products list
	 * @throws NoSuchCartProductsListException if a cart products list with the primary key could not be found
	 */
	@Override
	public CartProductsList findByPrimaryKey(long productId)
		throws NoSuchCartProductsListException {

		return findByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns the cart products list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the cart products list
	 * @return the cart products list, or <code>null</code> if a cart products list with the primary key could not be found
	 */
	@Override
	public CartProductsList fetchByPrimaryKey(long productId) {
		return fetchByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns all the cart products lists.
	 *
	 * @return the cart products lists
	 */
	@Override
	public List<CartProductsList> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cart products lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartProductsListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart products lists
	 * @param end the upper bound of the range of cart products lists (not inclusive)
	 * @return the range of cart products lists
	 */
	@Override
	public List<CartProductsList> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cart products lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartProductsListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart products lists
	 * @param end the upper bound of the range of cart products lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cart products lists
	 */
	@Override
	public List<CartProductsList> findAll(
		int start, int end,
		OrderByComparator<CartProductsList> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cart products lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartProductsListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart products lists
	 * @param end the upper bound of the range of cart products lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cart products lists
	 */
	@Override
	public List<CartProductsList> findAll(
		int start, int end,
		OrderByComparator<CartProductsList> orderByComparator,
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

		List<CartProductsList> list = null;

		if (useFinderCache) {
			list = (List<CartProductsList>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CARTPRODUCTSLIST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CARTPRODUCTSLIST;

				sql = sql.concat(CartProductsListModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CartProductsList>)QueryUtil.list(
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
	 * Removes all the cart products lists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CartProductsList cartProductsList : findAll()) {
			remove(cartProductsList);
		}
	}

	/**
	 * Returns the number of cart products lists.
	 *
	 * @return the number of cart products lists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CARTPRODUCTSLIST);

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
		return _SQL_SELECT_CARTPRODUCTSLIST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CartProductsListModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cart products list persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new CartProductsListModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CartProductsList.class.getName()));

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
		entityCache.removeCache(CartProductsListImpl.class.getName());

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

	private static final String _SQL_SELECT_CARTPRODUCTSLIST =
		"SELECT cartProductsList FROM CartProductsList cartProductsList";

	private static final String _SQL_COUNT_CARTPRODUCTSLIST =
		"SELECT COUNT(cartProductsList) FROM CartProductsList cartProductsList";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cartProductsList.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CartProductsList exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CartProductsListPersistenceImpl.class);

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

	private static class CartProductsListModelArgumentsResolver
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

			CartProductsListModelImpl cartProductsListModelImpl =
				(CartProductsListModelImpl)baseModel;

			long columnBitmask = cartProductsListModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					cartProductsListModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						cartProductsListModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					cartProductsListModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CartProductsListModelImpl cartProductsListModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						cartProductsListModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = cartProductsListModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}