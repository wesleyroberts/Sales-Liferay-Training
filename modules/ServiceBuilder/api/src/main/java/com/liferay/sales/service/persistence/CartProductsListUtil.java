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

package com.liferay.sales.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.sales.model.CartProductsList;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cart products list service. This utility wraps <code>com.liferay.sales.service.persistence.impl.CartProductsListPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CartProductsListPersistence
 * @generated
 */
public class CartProductsListUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CartProductsList cartProductsList) {
		getPersistence().clearCache(cartProductsList);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CartProductsList> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CartProductsList> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CartProductsList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CartProductsList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CartProductsList> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CartProductsList update(CartProductsList cartProductsList) {
		return getPersistence().update(cartProductsList);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CartProductsList update(
		CartProductsList cartProductsList, ServiceContext serviceContext) {

		return getPersistence().update(cartProductsList, serviceContext);
	}

	/**
	 * Caches the cart products list in the entity cache if it is enabled.
	 *
	 * @param cartProductsList the cart products list
	 */
	public static void cacheResult(CartProductsList cartProductsList) {
		getPersistence().cacheResult(cartProductsList);
	}

	/**
	 * Caches the cart products lists in the entity cache if it is enabled.
	 *
	 * @param cartProductsLists the cart products lists
	 */
	public static void cacheResult(List<CartProductsList> cartProductsLists) {
		getPersistence().cacheResult(cartProductsLists);
	}

	/**
	 * Creates a new cart products list with the primary key. Does not add the cart products list to the database.
	 *
	 * @param productId the primary key for the new cart products list
	 * @return the new cart products list
	 */
	public static CartProductsList create(long productId) {
		return getPersistence().create(productId);
	}

	/**
	 * Removes the cart products list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the cart products list
	 * @return the cart products list that was removed
	 * @throws NoSuchCartProductsListException if a cart products list with the primary key could not be found
	 */
	public static CartProductsList remove(long productId)
		throws com.liferay.sales.exception.NoSuchCartProductsListException {

		return getPersistence().remove(productId);
	}

	public static CartProductsList updateImpl(
		CartProductsList cartProductsList) {

		return getPersistence().updateImpl(cartProductsList);
	}

	/**
	 * Returns the cart products list with the primary key or throws a <code>NoSuchCartProductsListException</code> if it could not be found.
	 *
	 * @param productId the primary key of the cart products list
	 * @return the cart products list
	 * @throws NoSuchCartProductsListException if a cart products list with the primary key could not be found
	 */
	public static CartProductsList findByPrimaryKey(long productId)
		throws com.liferay.sales.exception.NoSuchCartProductsListException {

		return getPersistence().findByPrimaryKey(productId);
	}

	/**
	 * Returns the cart products list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the cart products list
	 * @return the cart products list, or <code>null</code> if a cart products list with the primary key could not be found
	 */
	public static CartProductsList fetchByPrimaryKey(long productId) {
		return getPersistence().fetchByPrimaryKey(productId);
	}

	/**
	 * Returns all the cart products lists.
	 *
	 * @return the cart products lists
	 */
	public static List<CartProductsList> findAll() {
		return getPersistence().findAll();
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
	public static List<CartProductsList> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<CartProductsList> findAll(
		int start, int end,
		OrderByComparator<CartProductsList> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<CartProductsList> findAll(
		int start, int end,
		OrderByComparator<CartProductsList> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cart products lists from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cart products lists.
	 *
	 * @return the number of cart products lists
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CartProductsListPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CartProductsListPersistence, CartProductsListPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CartProductsListPersistence.class);

		ServiceTracker<CartProductsListPersistence, CartProductsListPersistence>
			serviceTracker =
				new ServiceTracker
					<CartProductsListPersistence, CartProductsListPersistence>(
						bundle.getBundleContext(),
						CartProductsListPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}