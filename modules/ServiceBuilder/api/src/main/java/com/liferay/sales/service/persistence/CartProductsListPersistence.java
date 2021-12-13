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
import com.liferay.sales.exception.NoSuchCartProductsListException;
import com.liferay.sales.model.CartProductsList;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cart products list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CartProductsListUtil
 * @generated
 */
@ProviderType
public interface CartProductsListPersistence
	extends BasePersistence<CartProductsList> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CartProductsListUtil} to access the cart products list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the cart products list in the entity cache if it is enabled.
	 *
	 * @param cartProductsList the cart products list
	 */
	public void cacheResult(CartProductsList cartProductsList);

	/**
	 * Caches the cart products lists in the entity cache if it is enabled.
	 *
	 * @param cartProductsLists the cart products lists
	 */
	public void cacheResult(java.util.List<CartProductsList> cartProductsLists);

	/**
	 * Creates a new cart products list with the primary key. Does not add the cart products list to the database.
	 *
	 * @param productId the primary key for the new cart products list
	 * @return the new cart products list
	 */
	public CartProductsList create(long productId);

	/**
	 * Removes the cart products list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the cart products list
	 * @return the cart products list that was removed
	 * @throws NoSuchCartProductsListException if a cart products list with the primary key could not be found
	 */
	public CartProductsList remove(long productId)
		throws NoSuchCartProductsListException;

	public CartProductsList updateImpl(CartProductsList cartProductsList);

	/**
	 * Returns the cart products list with the primary key or throws a <code>NoSuchCartProductsListException</code> if it could not be found.
	 *
	 * @param productId the primary key of the cart products list
	 * @return the cart products list
	 * @throws NoSuchCartProductsListException if a cart products list with the primary key could not be found
	 */
	public CartProductsList findByPrimaryKey(long productId)
		throws NoSuchCartProductsListException;

	/**
	 * Returns the cart products list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the cart products list
	 * @return the cart products list, or <code>null</code> if a cart products list with the primary key could not be found
	 */
	public CartProductsList fetchByPrimaryKey(long productId);

	/**
	 * Returns all the cart products lists.
	 *
	 * @return the cart products lists
	 */
	public java.util.List<CartProductsList> findAll();

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
	public java.util.List<CartProductsList> findAll(int start, int end);

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
	public java.util.List<CartProductsList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CartProductsList>
			orderByComparator);

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
	public java.util.List<CartProductsList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CartProductsList>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cart products lists from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cart products lists.
	 *
	 * @return the number of cart products lists
	 */
	public int countAll();

}