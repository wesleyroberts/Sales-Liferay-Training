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
	public java.util.List<com.liferay.sales.model.SaleProduct>
		addProductToCartList(int quantity, long cartId, long stockId) {

		return _cartProductsListService.addProductToCartList(
			quantity, cartId, stockId);
	}

	@Override
	public void deleteCartProductsList(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cartProductsListService.deleteCartProductsList(productId);
	}

	@Override
	public com.liferay.sales.model.SaleCart finishCart(long cartId) {
		return _cartProductsListService.finishCart(cartId);
	}

	@Override
	public java.util.List<com.liferay.sales.model.CartProductsList>
		getAllCartProductsList() {

		return _cartProductsListService.getAllCartProductsList();
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductsByCarID(long id) {

		return _cartProductsListService.getAllProductsByCarID(id);
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
	public void removeProductToCartList(long cartId, long productId) {
		_cartProductsListService.removeProductToCartList(cartId, productId);
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