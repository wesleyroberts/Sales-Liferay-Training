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
import com.liferay.sales.exception.NoSuchSaleProductException;
import com.liferay.sales.model.SaleProduct;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sale product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleProductUtil
 * @generated
 */
@ProviderType
public interface SaleProductPersistence extends BasePersistence<SaleProduct> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SaleProductUtil} to access the sale product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the sale product where name = &#63; or throws a <code>NoSuchSaleProductException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching sale product
	 * @throws NoSuchSaleProductException if a matching sale product could not be found
	 */
	public SaleProduct findByName(String name)
		throws NoSuchSaleProductException;

	/**
	 * Returns the sale product where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	public SaleProduct fetchByName(String name);

	/**
	 * Returns the sale product where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	public SaleProduct fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the sale product where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the sale product that was removed
	 */
	public SaleProduct removeByName(String name)
		throws NoSuchSaleProductException;

	/**
	 * Returns the number of sale products where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching sale products
	 */
	public int countByName(String name);

	/**
	 * Returns all the sale products where price = &#63;.
	 *
	 * @param price the price
	 * @return the matching sale products
	 */
	public java.util.List<SaleProduct> findByPrice(double price);

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
	public java.util.List<SaleProduct> findByPrice(
		double price, int start, int end);

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
	public java.util.List<SaleProduct> findByPrice(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleProduct>
			orderByComparator);

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
	public java.util.List<SaleProduct> findByPrice(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleProduct>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sale product
	 * @throws NoSuchSaleProductException if a matching sale product could not be found
	 */
	public SaleProduct findByPrice_First(
			double price,
			com.liferay.portal.kernel.util.OrderByComparator<SaleProduct>
				orderByComparator)
		throws NoSuchSaleProductException;

	/**
	 * Returns the first sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	public SaleProduct fetchByPrice_First(
		double price,
		com.liferay.portal.kernel.util.OrderByComparator<SaleProduct>
			orderByComparator);

	/**
	 * Returns the last sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sale product
	 * @throws NoSuchSaleProductException if a matching sale product could not be found
	 */
	public SaleProduct findByPrice_Last(
			double price,
			com.liferay.portal.kernel.util.OrderByComparator<SaleProduct>
				orderByComparator)
		throws NoSuchSaleProductException;

	/**
	 * Returns the last sale product in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sale product, or <code>null</code> if a matching sale product could not be found
	 */
	public SaleProduct fetchByPrice_Last(
		double price,
		com.liferay.portal.kernel.util.OrderByComparator<SaleProduct>
			orderByComparator);

	/**
	 * Returns the sale products before and after the current sale product in the ordered set where price = &#63;.
	 *
	 * @param productId the primary key of the current sale product
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sale product
	 * @throws NoSuchSaleProductException if a sale product with the primary key could not be found
	 */
	public SaleProduct[] findByPrice_PrevAndNext(
			long productId, double price,
			com.liferay.portal.kernel.util.OrderByComparator<SaleProduct>
				orderByComparator)
		throws NoSuchSaleProductException;

	/**
	 * Removes all the sale products where price = &#63; from the database.
	 *
	 * @param price the price
	 */
	public void removeByPrice(double price);

	/**
	 * Returns the number of sale products where price = &#63;.
	 *
	 * @param price the price
	 * @return the number of matching sale products
	 */
	public int countByPrice(double price);

	/**
	 * Caches the sale product in the entity cache if it is enabled.
	 *
	 * @param saleProduct the sale product
	 */
	public void cacheResult(SaleProduct saleProduct);

	/**
	 * Caches the sale products in the entity cache if it is enabled.
	 *
	 * @param saleProducts the sale products
	 */
	public void cacheResult(java.util.List<SaleProduct> saleProducts);

	/**
	 * Creates a new sale product with the primary key. Does not add the sale product to the database.
	 *
	 * @param productId the primary key for the new sale product
	 * @return the new sale product
	 */
	public SaleProduct create(long productId);

	/**
	 * Removes the sale product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the sale product
	 * @return the sale product that was removed
	 * @throws NoSuchSaleProductException if a sale product with the primary key could not be found
	 */
	public SaleProduct remove(long productId) throws NoSuchSaleProductException;

	public SaleProduct updateImpl(SaleProduct saleProduct);

	/**
	 * Returns the sale product with the primary key or throws a <code>NoSuchSaleProductException</code> if it could not be found.
	 *
	 * @param productId the primary key of the sale product
	 * @return the sale product
	 * @throws NoSuchSaleProductException if a sale product with the primary key could not be found
	 */
	public SaleProduct findByPrimaryKey(long productId)
		throws NoSuchSaleProductException;

	/**
	 * Returns the sale product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the sale product
	 * @return the sale product, or <code>null</code> if a sale product with the primary key could not be found
	 */
	public SaleProduct fetchByPrimaryKey(long productId);

	/**
	 * Returns all the sale products.
	 *
	 * @return the sale products
	 */
	public java.util.List<SaleProduct> findAll();

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
	public java.util.List<SaleProduct> findAll(int start, int end);

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
	public java.util.List<SaleProduct> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleProduct>
			orderByComparator);

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
	public java.util.List<SaleProduct> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleProduct>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sale products from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sale products.
	 *
	 * @return the number of sale products
	 */
	public int countAll();

}