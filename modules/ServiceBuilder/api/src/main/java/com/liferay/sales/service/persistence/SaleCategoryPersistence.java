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
import com.liferay.sales.exception.NoSuchSaleCategoryException;
import com.liferay.sales.model.SaleCategory;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sale category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCategoryUtil
 * @generated
 */
@ProviderType
public interface SaleCategoryPersistence extends BasePersistence<SaleCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SaleCategoryUtil} to access the sale category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the sale category where name = &#63; or throws a <code>NoSuchSaleCategoryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching sale category
	 * @throws NoSuchSaleCategoryException if a matching sale category could not be found
	 */
	public SaleCategory findByName(String name)
		throws NoSuchSaleCategoryException;

	/**
	 * Returns the sale category where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching sale category, or <code>null</code> if a matching sale category could not be found
	 */
	public SaleCategory fetchByName(String name);

	/**
	 * Returns the sale category where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sale category, or <code>null</code> if a matching sale category could not be found
	 */
	public SaleCategory fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the sale category where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the sale category that was removed
	 */
	public SaleCategory removeByName(String name)
		throws NoSuchSaleCategoryException;

	/**
	 * Returns the number of sale categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching sale categories
	 */
	public int countByName(String name);

	/**
	 * Caches the sale category in the entity cache if it is enabled.
	 *
	 * @param saleCategory the sale category
	 */
	public void cacheResult(SaleCategory saleCategory);

	/**
	 * Caches the sale categories in the entity cache if it is enabled.
	 *
	 * @param saleCategories the sale categories
	 */
	public void cacheResult(java.util.List<SaleCategory> saleCategories);

	/**
	 * Creates a new sale category with the primary key. Does not add the sale category to the database.
	 *
	 * @param categoryId the primary key for the new sale category
	 * @return the new sale category
	 */
	public SaleCategory create(long categoryId);

	/**
	 * Removes the sale category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the sale category
	 * @return the sale category that was removed
	 * @throws NoSuchSaleCategoryException if a sale category with the primary key could not be found
	 */
	public SaleCategory remove(long categoryId)
		throws NoSuchSaleCategoryException;

	public SaleCategory updateImpl(SaleCategory saleCategory);

	/**
	 * Returns the sale category with the primary key or throws a <code>NoSuchSaleCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the sale category
	 * @return the sale category
	 * @throws NoSuchSaleCategoryException if a sale category with the primary key could not be found
	 */
	public SaleCategory findByPrimaryKey(long categoryId)
		throws NoSuchSaleCategoryException;

	/**
	 * Returns the sale category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the sale category
	 * @return the sale category, or <code>null</code> if a sale category with the primary key could not be found
	 */
	public SaleCategory fetchByPrimaryKey(long categoryId);

	/**
	 * Returns all the sale categories.
	 *
	 * @return the sale categories
	 */
	public java.util.List<SaleCategory> findAll();

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
	public java.util.List<SaleCategory> findAll(int start, int end);

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
	public java.util.List<SaleCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleCategory>
			orderByComparator);

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
	public java.util.List<SaleCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sale categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sale categories.
	 *
	 * @return the number of sale categories
	 */
	public int countAll();

}