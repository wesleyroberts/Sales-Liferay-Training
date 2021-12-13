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
import com.liferay.sales.model.SaleType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the sale type service. This utility wraps <code>com.liferay.sales.service.persistence.impl.SaleTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleTypePersistence
 * @generated
 */
public class SaleTypeUtil {

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
	public static void clearCache(SaleType saleType) {
		getPersistence().clearCache(saleType);
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
	public static Map<Serializable, SaleType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SaleType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SaleType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SaleType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SaleType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SaleType update(SaleType saleType) {
		return getPersistence().update(saleType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SaleType update(
		SaleType saleType, ServiceContext serviceContext) {

		return getPersistence().update(saleType, serviceContext);
	}

	/**
	 * Returns the sale type where name = &#63; or throws a <code>NoSuchSaleTypeException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching sale type
	 * @throws NoSuchSaleTypeException if a matching sale type could not be found
	 */
	public static SaleType findByName(String name)
		throws com.liferay.sales.exception.NoSuchSaleTypeException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the sale type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching sale type, or <code>null</code> if a matching sale type could not be found
	 */
	public static SaleType fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the sale type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sale type, or <code>null</code> if a matching sale type could not be found
	 */
	public static SaleType fetchByName(String name, boolean useFinderCache) {
		return getPersistence().fetchByName(name, useFinderCache);
	}

	/**
	 * Removes the sale type where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the sale type that was removed
	 */
	public static SaleType removeByName(String name)
		throws com.liferay.sales.exception.NoSuchSaleTypeException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of sale types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching sale types
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the sale type in the entity cache if it is enabled.
	 *
	 * @param saleType the sale type
	 */
	public static void cacheResult(SaleType saleType) {
		getPersistence().cacheResult(saleType);
	}

	/**
	 * Caches the sale types in the entity cache if it is enabled.
	 *
	 * @param saleTypes the sale types
	 */
	public static void cacheResult(List<SaleType> saleTypes) {
		getPersistence().cacheResult(saleTypes);
	}

	/**
	 * Creates a new sale type with the primary key. Does not add the sale type to the database.
	 *
	 * @param typeId the primary key for the new sale type
	 * @return the new sale type
	 */
	public static SaleType create(long typeId) {
		return getPersistence().create(typeId);
	}

	/**
	 * Removes the sale type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeId the primary key of the sale type
	 * @return the sale type that was removed
	 * @throws NoSuchSaleTypeException if a sale type with the primary key could not be found
	 */
	public static SaleType remove(long typeId)
		throws com.liferay.sales.exception.NoSuchSaleTypeException {

		return getPersistence().remove(typeId);
	}

	public static SaleType updateImpl(SaleType saleType) {
		return getPersistence().updateImpl(saleType);
	}

	/**
	 * Returns the sale type with the primary key or throws a <code>NoSuchSaleTypeException</code> if it could not be found.
	 *
	 * @param typeId the primary key of the sale type
	 * @return the sale type
	 * @throws NoSuchSaleTypeException if a sale type with the primary key could not be found
	 */
	public static SaleType findByPrimaryKey(long typeId)
		throws com.liferay.sales.exception.NoSuchSaleTypeException {

		return getPersistence().findByPrimaryKey(typeId);
	}

	/**
	 * Returns the sale type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeId the primary key of the sale type
	 * @return the sale type, or <code>null</code> if a sale type with the primary key could not be found
	 */
	public static SaleType fetchByPrimaryKey(long typeId) {
		return getPersistence().fetchByPrimaryKey(typeId);
	}

	/**
	 * Returns all the sale types.
	 *
	 * @return the sale types
	 */
	public static List<SaleType> findAll() {
		return getPersistence().findAll();
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
	public static List<SaleType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<SaleType> findAll(
		int start, int end, OrderByComparator<SaleType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<SaleType> findAll(
		int start, int end, OrderByComparator<SaleType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sale types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sale types.
	 *
	 * @return the number of sale types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SaleTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SaleTypePersistence, SaleTypePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SaleTypePersistence.class);

		ServiceTracker<SaleTypePersistence, SaleTypePersistence>
			serviceTracker =
				new ServiceTracker<SaleTypePersistence, SaleTypePersistence>(
					bundle.getBundleContext(), SaleTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}