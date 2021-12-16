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
 * Provides a wrapper for {@link CartProductsListService}.
 *
 * @author Brian Wing Shun Chan
 * @see CartProductsListService
 * @generated
 */
public class CartProductsListServiceWrapper
	implements CartProductsListService,
			   ServiceWrapper<CartProductsListService> {

	public CartProductsListServiceWrapper(
		CartProductsListService cartProductsListService) {

		_cartProductsListService = cartProductsListService;
	}

	@Override
	public com.liferay.sales.model.CartProductsList addProductToCartList(
		long productId, long cartId, int quantity) {

		return _cartProductsListService.addProductToCartList(
			productId, cartId, quantity);
	}

	@Override
	public void deleteCartListByID(long id) {
		_cartProductsListService.deleteCartListByID(id);
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductsInCartByCartID(long id) {

		return _cartProductsListService.getAllProductsInCartByCartID(id);
	}

	@Override
	public com.liferay.sales.model.CartProductsList getCartPorductListByID(
		long id) {

		return _cartProductsListService.getCartPorductListByID(id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cartProductsListService.getOSGiServiceIdentifier();
	}

	@Override
	public void removeProductFromList(
		long productId, long cartId, int quantity) {

		_cartProductsListService.removeProductFromList(
			productId, cartId, quantity);
	}

	@Override
	public CartProductsListService getWrappedService() {
		return _cartProductsListService;
	}

	@Override
	public void setWrappedService(
		CartProductsListService cartProductsListService) {

		_cartProductsListService = cartProductsListService;
	}

	private CartProductsListService _cartProductsListService;

}