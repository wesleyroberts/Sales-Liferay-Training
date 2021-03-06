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

import java.util.List;

/**
 * Provides the remote service utility for StockProductsList. This utility wraps
 * <code>com.liferay.sales.service.impl.StockProductsListServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see StockProductsListService
 * @generated
 */
public class StockProductsListServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sales.service.impl.StockProductsListServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.sales.model.SaleStock addProductToStock(
		com.liferay.sales.model.SaleProduct product) {

		return getService().addProductToStock(product);
	}

	public static int checkQuantityInStockByStockId(long stockId) {
		return getService().checkQuantityInStockByStockId(stockId);
	}

	public static void deleteStockProductListByID(long id) {
		getService().deleteStockProductListByID(id);
	}

	public static List<com.liferay.sales.model.SaleProduct>
		getAllProductInStock() {

		return getService().getAllProductInStock();
	}

	public static List<com.liferay.sales.model.SaleProduct>
		getAllProductInStockByProductName(String name) {

		return getService().getAllProductInStockByProductName(name);
	}

	public static List<com.liferay.sales.model.SaleProduct>
		getAllProductInStockByStockId(long stockId) {

		return getService().getAllProductInStockByStockId(stockId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void removeProductFromStock(long productID) {
		getService().removeProductFromStock(productID);
	}

	public static StockProductsListService getService() {
		return _service;
	}

	private static volatile StockProductsListService _service;

}