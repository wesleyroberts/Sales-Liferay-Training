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
import com.liferay.sales.model.SaleStock;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the sale stock service. This utility wraps <code>com.liferay.sales.service.persistence.impl.SaleStockPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleStockPersistence
 * @generated
 */
public class SaleStockUtil {

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
	public static void clearCache(SaleStock saleStock) {
		getPersistence().clearCache(saleStock);
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
	public static Map<Serializable, SaleStock> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SaleStock> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SaleStock> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SaleStock> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SaleStock> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SaleStock update(SaleStock saleStock) {
		return getPersistence().update(saleStock);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SaleStock update(
		SaleStock saleStock, ServiceContext serviceContext) {

		return getPersistence().update(saleStock, serviceContext);
	}

	/**
	 * Returns the sale stock where name = &#63; and typeId = &#63; or throws a <code>NoSuchSaleStockException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param typeId the type ID
	 * @return the matching sale stock
	 * @throws NoSuchSaleStockException if a matching sale stock could not be found
	 */
	public static SaleStock findByName_And_Type(String name, long typeId)
		throws com.liferay.sales.exception.NoSuchSaleStockException {

		return getPersistence().findByName_And_Type(name, typeId);
	}

	/**
	 * Returns the sale stock where name = &#63; and typeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param typeId the type ID
	 * @return the matching sale stock, or <code>null</code> if a matching sale stock could not be found
	 */
	public static SaleStock fetchByName_And_Type(String name, long typeId) {
		return getPersistence().fetchByName_And_Type(name, typeId);
	}

	/**
	 * Returns the sale stock where name = &#63; and typeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param typeId the type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sale stock, or <code>null</code> if a matching sale stock could not be found
	 */
	public static SaleStock fetchByName_And_Type(
		String name, long typeId, boolean useFinderCache) {

		return getPersistence().fetchByName_And_Type(
			name, typeId, useFinderCache);
	}

	/**
	 * Removes the sale stock where name = &#63; and typeId = &#63; from the database.
	 *
	 * @param name the name
	 * @param typeId the type ID
	 * @return the sale stock that was removed
	 */
	public static SaleStock removeByName_And_Type(String name, long typeId)
		throws com.liferay.sales.exception.NoSuchSaleStockException {

		return getPersistence().removeByName_And_Type(name, typeId);
	}

	/**
	 * Returns the number of sale stocks where name = &#63; and typeId = &#63;.
	 *
	 * @param name the name
	 * @param typeId the type ID
	 * @return the number of matching sale stocks
	 */
	public static int countByName_And_Type(String name, long typeId) {
		return getPersistence().countByName_And_Type(name, typeId);
	}

	/**
	 * Caches the sale stock in the entity cache if it is enabled.
	 *
	 * @param saleStock the sale stock
	 */
	public static void cacheResult(SaleStock saleStock) {
		getPersistence().cacheResult(saleStock);
	}

	/**
	 * Caches the sale stocks in the entity cache if it is enabled.
	 *
	 * @param saleStocks the sale stocks
	 */
	public static void cacheResult(List<SaleStock> saleStocks) {
		getPersistence().cacheResult(saleStocks);
	}

	/**
	 * Creates a new sale stock with the primary key. Does not add the sale stock to the database.
	 *
	 * @param StockId the primary key for the new sale stock
	 * @return the new sale stock
	 */
	public static SaleStock create(long StockId) {
		return getPersistence().create(StockId);
	}

	/**
	 * Removes the sale stock with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param StockId the primary key of the sale stock
	 * @return the sale stock that was removed
	 * @throws NoSuchSaleStockException if a sale stock with the primary key could not be found
	 */
	public static SaleStock remove(long StockId)
		throws com.liferay.sales.exception.NoSuchSaleStockException {

		return getPersistence().remove(StockId);
	}

	public static SaleStock updateImpl(SaleStock saleStock) {
		return getPersistence().updateImpl(saleStock);
	}

	/**
	 * Returns the sale stock with the primary key or throws a <code>NoSuchSaleStockException</code> if it could not be found.
	 *
	 * @param StockId the primary key of the sale stock
	 * @return the sale stock
	 * @throws NoSuchSaleStockException if a sale stock with the primary key could not be found
	 */
	public static SaleStock findByPrimaryKey(long StockId)
		throws com.liferay.sales.exception.NoSuchSaleStockException {

		return getPersistence().findByPrimaryKey(StockId);
	}

	/**
	 * Returns the sale stock with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param StockId the primary key of the sale stock
	 * @return the sale stock, or <code>null</code> if a sale stock with the primary key could not be found
	 */
	public static SaleStock fetchByPrimaryKey(long StockId) {
		return getPersistence().fetchByPrimaryKey(StockId);
	}

	/**
	 * Returns all the sale stocks.
	 *
	 * @return the sale stocks
	 */
	public static List<SaleStock> findAll() {
		return getPersistence().findAll();
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
	public static List<SaleStock> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<SaleStock> findAll(
		int start, int end, OrderByComparator<SaleStock> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<SaleStock> findAll(
		int start, int end, OrderByComparator<SaleStock> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sale stocks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sale stocks.
	 *
	 * @return the number of sale stocks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SaleStockPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SaleStockPersistence, SaleStockPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SaleStockPersistence.class);

		ServiceTracker<SaleStockPersistence, SaleStockPersistence>
			serviceTracker =
				new ServiceTracker<SaleStockPersistence, SaleStockPersistence>(
					bundle.getBundleContext(), SaleStockPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}