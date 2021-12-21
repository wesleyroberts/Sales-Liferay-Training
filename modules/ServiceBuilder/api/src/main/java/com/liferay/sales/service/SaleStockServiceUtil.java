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

import com.liferay.sales.model.SaleStock;

import java.util.List;

/**
 * Provides the remote service utility for SaleStock. This utility wraps
 * <code>com.liferay.sales.service.impl.SaleStockServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SaleStockService
 * @generated
 */
public class SaleStockServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sales.service.impl.SaleStockServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SaleStock createSaleStock() {
		return getService().createSaleStock();
	}

	public static void deletesaleCartById(long id) {
		getService().deletesaleCartById(id);
	}

	public static List<SaleStock> getAllSaleStock() {
		return getService().getAllSaleStock();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SaleStock getSaleStockById(long id) {
		return getService().getSaleStockById(id);
	}

	public static SaleStock getSaleStockByProduct(
		com.liferay.sales.model.SaleProduct product) {

		return getService().getSaleStockByProduct(product);
	}

	public static SaleStock updateStock(
		long stockId, int quantity, String name, long typeId) {

		return getService().updateStock(stockId, quantity, name, typeId);
	}

	public static SaleStockService getService() {
		return _service;
	}

	private static volatile SaleStockService _service;

}