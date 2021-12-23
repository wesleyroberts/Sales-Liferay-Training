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
import com.liferay.sales.exception.NoSuchSaleStockException;
import com.liferay.sales.model.SaleStock;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sale stock service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleStockUtil
 * @generated
 */
@ProviderType
public interface SaleStockPersistence extends BasePersistence<SaleStock> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SaleStockUtil} to access the sale stock persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the sale stock where name = &#63; and typeId = &#63; and categoryId = &#63; or throws a <code>NoSuchSaleStockException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param typeId the type ID
	 * @param categoryId the category ID
	 * @return the matching sale stock
	 * @throws NoSuchSaleStockException if a matching sale stock could not be found
	 */
	public SaleStock findByName_Type_Category(
			String name, long typeId, long categoryId)
		throws NoSuchSaleStockException;

	/**
	 * Returns the sale stock where name = &#63; and typeId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param typeId the type ID
	 * @param categoryId the category ID
	 * @return the matching sale stock, or <code>null</code> if a matching sale stock could not be found
	 */
	public SaleStock fetchByName_Type_Category(
		String name, long typeId, long categoryId);

	/**
	 * Returns the sale stock where name = &#63; and typeId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param typeId the type ID
	 * @param categoryId the category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sale stock, or <code>null</code> if a matching sale stock could not be found
	 */
	public SaleStock fetchByName_Type_Category(
		String name, long typeId, long categoryId, boolean useFinderCache);

	/**
	 * Removes the sale stock where name = &#63; and typeId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param name the name
	 * @param typeId the type ID
	 * @param categoryId the category ID
	 * @return the sale stock that was removed
	 */
	public SaleStock removeByName_Type_Category(
			String name, long typeId, long categoryId)
		throws NoSuchSaleStockException;

	/**
	 * Returns the number of sale stocks where name = &#63; and typeId = &#63; and categoryId = &#63;.
	 *
	 * @param name the name
	 * @param typeId the type ID
	 * @param categoryId the category ID
	 * @return the number of matching sale stocks
	 */
	public int countByName_Type_Category(
		String name, long typeId, long categoryId);

	/**
	 * Caches the sale stock in the entity cache if it is enabled.
	 *
	 * @param saleStock the sale stock
	 */
	public void cacheResult(SaleStock saleStock);

	/**
	 * Caches the sale stocks in the entity cache if it is enabled.
	 *
	 * @param saleStocks the sale stocks
	 */
	public void cacheResult(java.util.List<SaleStock> saleStocks);

	/**
	 * Creates a new sale stock with the primary key. Does not add the sale stock to the database.
	 *
	 * @param StockId the primary key for the new sale stock
	 * @return the new sale stock
	 */
	public SaleStock create(long StockId);

	/**
	 * Removes the sale stock with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param StockId the primary key of the sale stock
	 * @return the sale stock that was removed
	 * @throws NoSuchSaleStockException if a sale stock with the primary key could not be found
	 */
	public SaleStock remove(long StockId) throws NoSuchSaleStockException;

	public SaleStock updateImpl(SaleStock saleStock);

	/**
	 * Returns the sale stock with the primary key or throws a <code>NoSuchSaleStockException</code> if it could not be found.
	 *
	 * @param StockId the primary key of the sale stock
	 * @return the sale stock
	 * @throws NoSuchSaleStockException if a sale stock with the primary key could not be found
	 */
	public SaleStock findByPrimaryKey(long StockId)
		throws NoSuchSaleStockException;

	/**
	 * Returns the sale stock with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param StockId the primary key of the sale stock
	 * @return the sale stock, or <code>null</code> if a sale stock with the primary key could not be found
	 */
	public SaleStock fetchByPrimaryKey(long StockId);

	/**
	 * Returns all the sale stocks.
	 *
	 * @return the sale stocks
	 */
	public java.util.List<SaleStock> findAll();

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
	public java.util.List<SaleStock> findAll(int start, int end);

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
	public java.util.List<SaleStock> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleStock>
			orderByComparator);

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
	public java.util.List<SaleStock> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleStock>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sale stocks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sale stocks.
	 *
	 * @return the number of sale stocks
	 */
	public int countAll();

}