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
import com.liferay.sales.model.SaleProduct;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the sale product service. This utility wraps <code>com.liferay.sales.service.persistence.impl.SaleProductPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleProductPersistence
 * @generated
 */
public class SaleProductUtil {

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
	public static void clearCache(SaleProduct saleProduct) {
		getPersistence().clearCache(saleProduct);
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
	public static Map<Serializable, SaleProduct> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SaleProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SaleProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SaleProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SaleProduct> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SaleProduct update(SaleProduct saleProduct) {
		return getPersistence().update(saleProduct);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SaleProduct update(
		SaleProduct saleProduct, ServiceContext serviceContext) {

		return getPersistence().update(saleProduct, serviceContext);
	}

	/**
	 * Returns the sale product where name = &#63; or throws a <code>NoSuchSaleProductException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching sale product
	 * @throws NoSuchSaleProductException if a matching sale product could not be found
	 */
	public static SaleProduct findByName(String name)
		throws com.liferay.sales.exception.NoSuchSaleProductException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the sale product where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	public static SaleProduct fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the sale product where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	public static SaleProduct fetchByName(String name, boolean useFinderCache) {
		return getPersistence().fetchByName(name, useFinderCache);
	}

	/**
	 * Removes the sale product where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the sale product that was removed
	 */
	public static SaleProduct removeByName(String name)
		throws com.liferay.sales.exception.NoSuchSaleProductException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of sale products where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching sale products
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the sale products where price = &#63;.
	 *
	 * @param price the price
	 * @return the matching sale products
	 */
	public static List<SaleProduct> findByPrice(double price) {
		return getPersistence().findByPrice(price);
	}

	/**
	 * Returns a range of all the sale products where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @return the range of matching sale products
	 */
	public static List<SaleProduct> findByPrice(
		double price, int start, int end) {

		return getPersistence().findByPrice(price, start, end);
	}

	/**
	 * Returns an ordered range of all the sale products where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sale products
	 */
	public static List<SaleProduct> findByPrice(
		double price, int start, int end,
		OrderByComparator<SaleProduct> orderByComparator) {

		return getPersistence().findByPrice(
			price, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sale products where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sale products
	 */
	public static List<SaleProduct> findByPrice(
		double price, int start, int end,
		OrderByComparator<SaleProduct> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPrice(
			price, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sale product
	 * @throws NoSuchSaleProductException if a matching sale product could not be found
	 */
	public static SaleProduct findByPrice_First(
			double price, OrderByComparator<SaleProduct> orderByComparator)
		throws com.liferay.sales.exception.NoSuchSaleProductException {

		return getPersistence().findByPrice_First(price, orderByComparator);
	}

	/**
	 * Returns the first sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	public static SaleProduct fetchByPrice_First(
		double price, OrderByComparator<SaleProduct> orderByComparator) {

		return getPersistence().fetchByPrice_First(price, orderByComparator);
	}

	/**
	 * Returns the last sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sale product
	 * @throws NoSuchSaleProductException if a matching sale product could not be found
	 */
	public static SaleProduct findByPrice_Last(
			double price, OrderByComparator<SaleProduct> orderByComparator)
		throws com.liferay.sales.exception.NoSuchSaleProductException {

		return getPersistence().findByPrice_Last(price, orderByComparator);
	}

	/**
	 * Returns the last sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	public static SaleProduct fetchByPrice_Last(
		double price, OrderByComparator<SaleProduct> orderByComparator) {

		return getPersistence().fetchByPrice_Last(price, orderByComparator);
	}

	/**
	 * Returns the sale products before and after the current sale product in the ordered set where price = &#63;.
	 *
	 * @param productId the primary key of the current sale product
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sale product
	 * @throws NoSuchSaleProductException if a sale product with the primary key could not be found
	 */
	public static SaleProduct[] findByPrice_PrevAndNext(
			long productId, double price,
			OrderByComparator<SaleProduct> orderByComparator)
		throws com.liferay.sales.exception.NoSuchSaleProductException {

		return getPersistence().findByPrice_PrevAndNext(
			productId, price, orderByComparator);
	}

	/**
	 * Removes all the sale products where price = &#63; from the database.
	 *
	 * @param price the price
	 */
	public static void removeByPrice(double price) {
		getPersistence().removeByPrice(price);
	}

	/**
	 * Returns the number of sale products where price = &#63;.
	 *
	 * @param price the price
	 * @return the number of matching sale products
	 */
	public static int countByPrice(double price) {
		return getPersistence().countByPrice(price);
	}

	/**
	 * Caches the sale product in the entity cache if it is enabled.
	 *
	 * @param saleProduct the sale product
	 */
	public static void cacheResult(SaleProduct saleProduct) {
		getPersistence().cacheResult(saleProduct);
	}

	/**
	 * Caches the sale products in the entity cache if it is enabled.
	 *
	 * @param saleProducts the sale products
	 */
	public static void cacheResult(List<SaleProduct> saleProducts) {
		getPersistence().cacheResult(saleProducts);
	}

	/**
	 * Creates a new sale product with the primary key. Does not add the sale product to the database.
	 *
	 * @param productId the primary key for the new sale product
	 * @return the new sale product
	 */
	public static SaleProduct create(long productId) {
		return getPersistence().create(productId);
	}

	/**
	 * Removes the sale product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the sale product
	 * @return the sale product that was removed
	 * @throws NoSuchSaleProductException if a sale product with the primary key could not be found
	 */
	public static SaleProduct remove(long productId)
		throws com.liferay.sales.exception.NoSuchSaleProductException {

		return getPersistence().remove(productId);
	}

	public static SaleProduct updateImpl(SaleProduct saleProduct) {
		return getPersistence().updateImpl(saleProduct);
	}

	/**
	 * Returns the sale product with the primary key or throws a <code>NoSuchSaleProductException</code> if it could not be found.
	 *
	 * @param productId the primary key of the sale product
	 * @return the sale product
	 * @throws NoSuchSaleProductException if a sale product with the primary key could not be found
	 */
	public static SaleProduct findByPrimaryKey(long productId)
		throws com.liferay.sales.exception.NoSuchSaleProductException {

		return getPersistence().findByPrimaryKey(productId);
	}

	/**
	 * Returns the sale product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the sale product
	 * @return the sale product, or <code>null</code> if a sale product with the primary key could not be found
	 */
	public static SaleProduct fetchByPrimaryKey(long productId) {
		return getPersistence().fetchByPrimaryKey(productId);
	}

	/**
	 * Returns all the sale products.
	 *
	 * @return the sale products
	 */
	public static List<SaleProduct> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sale products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @return the range of sale products
	 */
	public static List<SaleProduct> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sale products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sale products
	 */
	public static List<SaleProduct> findAll(
		int start, int end, OrderByComparator<SaleProduct> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sale products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale products
	 * @param end the upper bound of the range of sale products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sale products
	 */
	public static List<SaleProduct> findAll(
		int start, int end, OrderByComparator<SaleProduct> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sale products from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sale products.
	 *
	 * @return the number of sale products
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SaleProductPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SaleProductPersistence, SaleProductPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SaleProductPersistence.class);

		ServiceTracker<SaleProductPersistence, SaleProductPersistence>
			serviceTracker =
				new ServiceTracker
					<SaleProductPersistence, SaleProductPersistence>(
						bundle.getBundleContext(), SaleProductPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}