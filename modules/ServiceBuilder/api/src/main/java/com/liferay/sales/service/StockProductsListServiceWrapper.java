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
 * Provides a wrapper for {@link StockProductsListService}.
 *
 * @author Brian Wing Shun Chan
 * @see StockProductsListService
 * @generated
 */
public class StockProductsListServiceWrapper
	implements ServiceWrapper<StockProductsListService>,
			   StockProductsListService {

	public StockProductsListServiceWrapper(
		StockProductsListService stockProductsListService) {

		_stockProductsListService = stockProductsListService;
	}

	@Override
	public com.liferay.sales.model.SaleStock addProductToStock(
		com.liferay.sales.model.SaleProduct product) {

		return _stockProductsListService.addProductToStock(product);
	}

	@Override
	public void deleteStockProductListByID(long id) {
		_stockProductsListService.deleteStockProductListByID(id);
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductInStock() {

		return _stockProductsListService.getAllProductInStock();
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductInStockByProductName(String name) {

		return _stockProductsListService.getAllProductInStockByProductName(
			name);
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleProduct>
		getAllProductInStockByStockId(long stockId) {

		return _stockProductsListService.getAllProductInStockByStockId(stockId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stockProductsListService.getOSGiServiceIdentifier();
	}

	@Override
	public void removeProductFromStock(long productID) {
		_stockProductsListService.removeProductFromStock(productID);
	}

	@Override
	public StockProductsListService getWrappedService() {
		return _stockProductsListService;
	}

	@Override
	public void setWrappedService(
		StockProductsListService stockProductsListService) {

		_stockProductsListService = stockProductsListService;
	}

	private StockProductsListService _stockProductsListService;

}