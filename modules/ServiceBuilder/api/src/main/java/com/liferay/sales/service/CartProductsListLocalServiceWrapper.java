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

package com.liferay.sales.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CartProductsListLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CartProductsListLocalService
 * @generated
 */
public class CartProductsListLocalServiceWrapper
	implements CartProductsListLocalService,
			   ServiceWrapper<CartProductsListLocalService> {

	public CartProductsListLocalServiceWrapper(
		CartProductsListLocalService cartProductsListLocalService) {

		_cartProductsListLocalService = cartProductsListLocalService;
	}

	/**
	 * Adds the cart products list to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartProductsListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cartProductsList the cart products list
	 * @return the cart products list that was added
	 */
	@Override
	public com.liferay.sales.model.CartProductsList addCartProductsList(
		com.liferay.sales.model.CartProductsList cartProductsList) {

		return _cartProductsListLocalService.addCartProductsList(
			cartProductsList);
	}

	@Override
	public com.liferay.sales.model.CartProductsList addProductToCartList(
		long productId, long cartId, int quantity) {

		return _cartProductsListLocalService.addProductToCartList(
			productId, cartId, quantity);
	}

	@Override
	public Boolean checkSaleProductInTheList(long cartId, long productId) {
		return _cartProductsListLocalService.checkSaleProductInTheList(
			cartId, productId);
	}

	/**
	 * Creates a new cart products list with the primary key. Does not add the cart products list to the database.
	 *
	 * @param productId the primary key for the new cart products list
	 * @return the new cart products list
	 */
	@Override
	public com.liferay.sales.model.CartProductsList createCartProductsList(
		long productId) {

		return _cartProductsListLocalService.createCartProductsList(productId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartProductsListLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void deleteCartListByID(long id) {
		_cartProductsListLocalService.deleteCartListByID(id);
	}

	/**
	 * Deletes the cart products list from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartProductsListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cartProductsList the cart products list
	 * @return the cart products list that was removed
	 */
	@Override
	public com.liferay.sales.model.CartProductsList deleteCartProductsList(
		com.liferay.sales.model.CartProductsList cartProductsList) {

		return _cartProductsListLocalService.deleteCartProductsList(
			cartProductsList);
	}

	/**
	 * Deletes the cart products list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartProductsListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productId the primary key of the cart products list
	 * @return the cart products list that was removed
	 * @throws PortalException if a cart products list with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.CartProductsList deleteCartProductsList(
			long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartProductsListLocalService.deleteCartProductsList(productId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartProductsListLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cartProductsListLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _cartProductsListLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.CartProductsListModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _cartProductsListLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.CartProductsListModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _cartProductsListLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _cartProductsListLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _cartProductsListLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.sales.model.CartProductsList fetchCartProductsList(
		long productId) {

		return _cartProductsListLocalService.fetchCartProductsList(productId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cartProductsListLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductsInCartByCartID(long id) {

		return _cartProductsListLocalService.getAllProductsInCartByCartID(id);
	}

	@Override
	public com.liferay.sales.model.CartProductsList getCartPorductListByID(
		long id) {

		return _cartProductsListLocalService.getCartPorductListByID(id);
	}

	/**
	 * Returns the cart products list with the primary key.
	 *
	 * @param productId the primary key of the cart products list
	 * @return the cart products list
	 * @throws PortalException if a cart products list with the primary key could not be found
	 */
	@Override
	public com.liferay.sales.model.CartProductsList getCartProductsList(
			long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartProductsListLocalService.getCartProductsList(productId);
	}

	/**
	 * Returns a range of all the cart products lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sales.model.impl.CartProductsListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart products lists
	 * @param end the upper bound of the range of cart products lists (not inclusive)
	 * @return the range of cart products lists
	 */
	@Override
	public java.util.List<com.liferay.sales.model.CartProductsList>
		getCartProductsLists(int start, int end) {

		return _cartProductsListLocalService.getCartProductsLists(start, end);
	}

	/**
	 * Returns the number of cart products lists.
	 *
	 * @return the number of cart products lists
	 */
	@Override
	public int getCartProductsListsCount() {
		return _cartProductsListLocalService.getCartProductsListsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cartProductsListLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cartProductsListLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartProductsListLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void removeProductFromList(
		long productId, long cartId, int quantity) {

		_cartProductsListLocalService.removeProductFromList(
			productId, cartId, quantity);
	}

	/**
	 * Updates the cart products list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartProductsListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cartProductsList the cart products list
	 * @return the cart products list that was updated
	 */
	@Override
	public com.liferay.sales.model.CartProductsList updateCartProductsList(
		com.liferay.sales.model.CartProductsList cartProductsList) {

		return _cartProductsListLocalService.updateCartProductsList(
			cartProductsList);
	}

	@Override
	public CartProductsListLocalService getWrappedService() {
		return _cartProductsListLocalService;
	}

	@Override
	public void setWrappedService(
		CartProductsListLocalService cartProductsListLocalService) {

		_cartProductsListLocalService = cartProductsListLocalService;
	}

	private CartProductsListLocalService _cartProductsListLocalService;

}