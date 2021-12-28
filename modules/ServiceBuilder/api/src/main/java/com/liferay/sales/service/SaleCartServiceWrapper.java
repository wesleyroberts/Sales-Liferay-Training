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
 * Provides a wrapper for {@link SaleCartService}.
 *
 * @author Brian Wing Shun Chan
 * @see SaleCartService
 * @generated
 */
public class SaleCartServiceWrapper
	implements SaleCartService, ServiceWrapper<SaleCartService> {

	public SaleCartServiceWrapper(SaleCartService saleCartService) {
		_saleCartService = saleCartService;
	}

	@Override
	public com.liferay.sales.model.SaleCart addProductPriceToCartTotalValue(
		double price, long cartId) {

		return _saleCartService.addProductPriceToCartTotalValue(price, cartId);
	}

	@Override
	public com.liferay.sales.model.SaleCart createSaleCartById() {
		return _saleCartService.createSaleCartById();
	}

	@Override
	public void deleteSaleCartById(long id) {
		_saleCartService.deleteSaleCartById(id);
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleCart> getAllSaleCart() {
		return _saleCartService.getAllSaleCart();
	}

	@Override
	public Double getFinalValueByCartId(long cartId) {
		return _saleCartService.getFinalValueByCartId(cartId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saleCartService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.sales.model.SaleCart getSaleCartById(long id) {
		return _saleCartService.getSaleCartById(id);
	}

	@Override
	public com.liferay.sales.model.SaleCart removeProductPriceToCartTotalValue(
		double price, long cartId) {

		return _saleCartService.removeProductPriceToCartTotalValue(
			price, cartId);
	}

	@Override
	public com.liferay.sales.model.SaleCart updateSaleCartById(
		com.liferay.sales.model.SaleCart saleCart) {

		return _saleCartService.updateSaleCartById(saleCart);
	}

	@Override
	public SaleCartService getWrappedService() {
		return _saleCartService;
	}

	@Override
	public void setWrappedService(SaleCartService saleCartService) {
		_saleCartService = saleCartService;
	}

	private SaleCartService _saleCartService;

}