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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.sales.exception.NoSuchSaleTypeException;
import com.liferay.sales.model.SaleType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sale type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleTypeUtil
 * @generated
 */
@ProviderType
public interface SaleTypePersistence extends BasePersistence<SaleType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SaleTypeUtil} to access the sale type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the sale type where name = &#63; or throws a <code>NoSuchSaleTypeException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching sale type
	 * @throws NoSuchSaleTypeException if a matching sale type could not be found
	 */
	public SaleType findByName(String name) throws NoSuchSaleTypeException;

	/**
	 * Returns the sale type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching sale type, or <code>null</code> if a matching sale type could not be found
	 */
	public SaleType fetchByName(String name);

	/**
	 * Returns the sale type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sale type, or <code>null</code> if a matching sale type could not be found
	 */
	public SaleType fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the sale type where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the sale type that was removed
	 */
	public SaleType removeByName(String name) throws NoSuchSaleTypeException;

	/**
	 * Returns the number of sale types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching sale types
	 */
	public int countByName(String name);

	/**
	 * Caches the sale type in the entity cache if it is enabled.
	 *
	 * @param saleType the sale type
	 */
	public void cacheResult(SaleType saleType);

	/**
	 * Caches the sale types in the entity cache if it is enabled.
	 *
	 * @param saleTypes the sale types
	 */
	public void cacheResult(java.util.List<SaleType> saleTypes);

	/**
	 * Creates a new sale type with the primary key. Does not add the sale type to the database.
	 *
	 * @param typeId the primary key for the new sale type
	 * @return the new sale type
	 */
	public SaleType create(long typeId);

	/**
	 * Removes the sale type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeId the primary key of the sale type
	 * @return the sale type that was removed
	 * @throws NoSuchSaleTypeException if a sale type with the primary key could not be found
	 */
	public SaleType remove(long typeId) throws NoSuchSaleTypeException;

	public SaleType updateImpl(SaleType saleType);

	/**
	 * Returns the sale type with the primary key or throws a <code>NoSuchSaleTypeException</code> if it could not be found.
	 *
	 * @param typeId the primary key of the sale type
	 * @return the sale type
	 * @throws NoSuchSaleTypeException if a sale type with the primary key could not be found
	 */
	public SaleType findByPrimaryKey(long typeId)
		throws NoSuchSaleTypeException;

	/**
	 * Returns the sale type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeId the primary key of the sale type
	 * @return the sale type, or <code>null</code> if a sale type with the primary key could not be found
	 */
	public SaleType fetchByPrimaryKey(long typeId);

	/**
	 * Returns all the sale types.
	 *
	 * @return the sale types
	 */
	public java.util.List<SaleType> findAll();

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
	public java.util.List<SaleType> findAll(int start, int end);

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
	public java.util.List<SaleType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleType>
			orderByComparator);

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
	public java.util.List<SaleType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sale types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sale types.
	 *
	 * @return the number of sale types
	 */
	public int countAll();

}