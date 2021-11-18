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
import com.liferay.sales.model.SaleCategory;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the sale category service. This utility wraps <code>com.liferay.sales.service.persistence.impl.SaleCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCategoryPersistence
 * @generated
 */
public class SaleCategoryUtil {

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
	public static void clearCache(SaleCategory saleCategory) {
		getPersistence().clearCache(saleCategory);
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
	public static Map<Serializable, SaleCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SaleCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SaleCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SaleCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SaleCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SaleCategory update(SaleCategory saleCategory) {
		return getPersistence().update(saleCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SaleCategory update(
		SaleCategory saleCategory, ServiceContext serviceContext) {

		return getPersistence().update(saleCategory, serviceContext);
	}

	/**
	 * Returns the sale category where name = &#63; or throws a <code>NoSuchSaleCategoryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching sale category
	 * @throws NoSuchSaleCategoryException if a matching sale category could not be found
	 */
	public static SaleCategory findByName(String name)
		throws com.liferay.sales.exception.NoSuchSaleCategoryException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the sale category where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching sale category, or <code>null</code> if a matching sale category could not be found
	 */
	public static SaleCategory fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the sale category where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sale category, or <code>null</code> if a matching sale category could not be found
	 */
	public static SaleCategory fetchByName(
		String name, boolean useFinderCache) {

		return getPersistence().fetchByName(name, useFinderCache);
	}

	/**
	 * Removes the sale category where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the sale category that was removed
	 */
	public static SaleCategory removeByName(String name)
		throws com.liferay.sales.exception.NoSuchSaleCategoryException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of sale categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching sale categories
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the sale category in the entity cache if it is enabled.
	 *
	 * @param saleCategory the sale category
	 */
	public static void cacheResult(SaleCategory saleCategory) {
		getPersistence().cacheResult(saleCategory);
	}

	/**
	 * Caches the sale categories in the entity cache if it is enabled.
	 *
	 * @param saleCategories the sale categories
	 */
	public static void cacheResult(List<SaleCategory> saleCategories) {
		getPersistence().cacheResult(saleCategories);
	}

	/**
	 * Creates a new sale category with the primary key. Does not add the sale category to the database.
	 *
	 * @param categoryId the primary key for the new sale category
	 * @return the new sale category
	 */
	public static SaleCategory create(long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	 * Removes the sale category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the sale category
	 * @return the sale category that was removed
	 * @throws NoSuchSaleCategoryException if a sale category with the primary key could not be found
	 */
	public static SaleCategory remove(long categoryId)
		throws com.liferay.sales.exception.NoSuchSaleCategoryException {

		return getPersistence().remove(categoryId);
	}

	public static SaleCategory updateImpl(SaleCategory saleCategory) {
		return getPersistence().updateImpl(saleCategory);
	}

	/**
	 * Returns the sale category with the primary key or throws a <code>NoSuchSaleCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the sale category
	 * @return the sale category
	 * @throws NoSuchSaleCategoryException if a sale category with the primary key could not be found
	 */
	public static SaleCategory findByPrimaryKey(long categoryId)
		throws com.liferay.sales.exception.NoSuchSaleCategoryException {

		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	 * Returns the sale category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the sale category
	 * @return the sale category, or <code>null</code> if a sale category with the primary key could not be found
	 */
	public static SaleCategory fetchByPrimaryKey(long categoryId) {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	 * Returns all the sale categories.
	 *
	 * @return the sale categories
	 */
	public static List<SaleCategory> findAll() {
		return getPersistence().findAll();
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
	public static List<SaleCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<SaleCategory> findAll(
		int start, int end, OrderByComparator<SaleCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<SaleCategory> findAll(
		int start, int end, OrderByComparator<SaleCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sale categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sale categories.
	 *
	 * @return the number of sale categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SaleCategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SaleCategoryPersistence, SaleCategoryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SaleCategoryPersistence.class);

		ServiceTracker<SaleCategoryPersistence, SaleCategoryPersistence>
			serviceTracker =
				new ServiceTracker
					<SaleCategoryPersistence, SaleCategoryPersistence>(
						bundle.getBundleContext(),
						SaleCategoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}