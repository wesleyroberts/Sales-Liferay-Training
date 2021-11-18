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
import com.liferay.sales.exception.NoSuchSaleCartException;
import com.liferay.sales.model.SaleCart;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sale cart service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCartUtil
 * @generated
 */
@ProviderType
public interface SaleCartPersistence extends BasePersistence<SaleCart> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SaleCartUtil} to access the sale cart persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the sale cart in the entity cache if it is enabled.
	 *
	 * @param saleCart the sale cart
	 */
	public void cacheResult(SaleCart saleCart);

	/**
	 * Caches the sale carts in the entity cache if it is enabled.
	 *
	 * @param saleCarts the sale carts
	 */
	public void cacheResult(java.util.List<SaleCart> saleCarts);

	/**
	 * Creates a new sale cart with the primary key. Does not add the sale cart to the database.
	 *
	 * @param cartId the primary key for the new sale cart
	 * @return the new sale cart
	 */
	public SaleCart create(long cartId);

	/**
	 * Removes the sale cart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cartId the primary key of the sale cart
	 * @return the sale cart that was removed
	 * @throws NoSuchSaleCartException if a sale cart with the primary key could not be found
	 */
	public SaleCart remove(long cartId) throws NoSuchSaleCartException;

	public SaleCart updateImpl(SaleCart saleCart);

	/**
	 * Returns the sale cart with the primary key or throws a <code>NoSuchSaleCartException</code> if it could not be found.
	 *
	 * @param cartId the primary key of the sale cart
	 * @return the sale cart
	 * @throws NoSuchSaleCartException if a sale cart with the primary key could not be found
	 */
	public SaleCart findByPrimaryKey(long cartId)
		throws NoSuchSaleCartException;

	/**
	 * Returns the sale cart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cartId the primary key of the sale cart
	 * @return the sale cart, or <code>null</code> if a sale cart with the primary key could not be found
	 */
	public SaleCart fetchByPrimaryKey(long cartId);

	/**
	 * Returns all the sale carts.
	 *
	 * @return the sale carts
	 */
	public java.util.List<SaleCart> findAll();

	/**
	 * Returns a range of all the sale carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleCartModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale carts
	 * @param end the upper bound of the range of sale carts (not inclusive)
	 * @return the range of sale carts
	 */
	public java.util.List<SaleCart> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sale carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleCartModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale carts
	 * @param end the upper bound of the range of sale carts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sale carts
	 */
	public java.util.List<SaleCart> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleCart>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sale carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaleCartModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sale carts
	 * @param end the upper bound of the range of sale carts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sale carts
	 */
	public java.util.List<SaleCart> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SaleCart>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sale carts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sale carts.
	 *
	 * @return the number of sale carts
	 */
	public int countAll();

}