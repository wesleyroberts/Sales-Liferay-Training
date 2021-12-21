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
 * Provides a wrapper for {@link SaleStockService}.
 *
 * @author Brian Wing Shun Chan
 * @see SaleStockService
 * @generated
 */
public class SaleStockServiceWrapper
	implements SaleStockService, ServiceWrapper<SaleStockService> {

	public SaleStockServiceWrapper(SaleStockService saleStockService) {
		_saleStockService = saleStockService;
	}

	@Override
	public com.liferay.sales.model.SaleStock createSaleStock() {
		return _saleStockService.createSaleStock();
	}

	@Override
	public void deletesaleCartById(long id) {
		_saleStockService.deletesaleCartById(id);
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleStock> getAllSaleStock() {
		return _saleStockService.getAllSaleStock();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saleStockService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.sales.model.SaleStock getSaleStockById(long id) {
		return _saleStockService.getSaleStockById(id);
	}

	@Override
	public com.liferay.sales.model.SaleStock getSaleStockByProduct(
		com.liferay.sales.model.SaleProduct product) {

		return _saleStockService.getSaleStockByProduct(product);
	}

	@Override
	public com.liferay.sales.model.SaleStock updateStock(
		long stockId, int quantity, String name, long typeId) {

		return _saleStockService.updateStock(stockId, quantity, name, typeId);
	}

	@Override
	public SaleStockService getWrappedService() {
		return _saleStockService;
	}

	@Override
	public void setWrappedService(SaleStockService saleStockService) {
		_saleStockService = saleStockService;
	}

	private SaleStockService _saleStockService;

}