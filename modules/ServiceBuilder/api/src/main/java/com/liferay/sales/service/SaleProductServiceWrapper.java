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
 * Provides a wrapper for {@link SaleProductService}.
 *
 * @author Brian Wing Shun Chan
 * @see SaleProductService
 * @generated
 */
public class SaleProductServiceWrapper
	implements SaleProductService, ServiceWrapper<SaleProductService> {

	public SaleProductServiceWrapper(SaleProductService saleProductService) {
		_saleProductService = saleProductService;
	}

	@Override
	public com.liferay.sales.model.SaleProduct createSaleProduct(
		String name, double price, long categoryId, long typeId) {

		return _saleProductService.createSaleProduct(
			name, price, categoryId, typeId);
	}

	@Override
	public com.liferay.sales.model.SaleProduct deleteById(long id) {
		return _saleProductService.deleteById(id);
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleProduct>
		getAllSaleProducts() {

		return _saleProductService.getAllSaleProducts();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saleProductService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.sales.model.SaleProduct getSaleProductById(long id) {
		return _saleProductService.getSaleProductById(id);
	}

	@Override
	public com.liferay.sales.model.SaleProduct getSaleProductByName(
		String name) {

		return _saleProductService.getSaleProductByName(name);
	}

	@Override
	public SaleProductService getWrappedService() {
		return _saleProductService;
	}

	@Override
	public void setWrappedService(SaleProductService saleProductService) {
		_saleProductService = saleProductService;
	}

	private SaleProductService _saleProductService;

}