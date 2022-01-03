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

import com.liferay.sales.model.SaleProduct;

import java.util.List;

/**
 * Provides the remote service utility for SaleProduct. This utility wraps
 * <code>com.liferay.sales.service.impl.SaleProductServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SaleProductService
 * @generated
 */
public class SaleProductServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sales.service.impl.SaleProductServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static List<SaleProduct> addSaleProductInScale(
		String name, double price, long categoryId, long typeId, int quantity) {

		return getService().addSaleProductInScale(
			name, price, categoryId, typeId, quantity);
	}

	public static void deleteById(long id) {
		getService().deleteById(id);
	}

	public static List<SaleProduct> getAllSaleProducts() {
		return getService().getAllSaleProducts();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SaleProduct getSaleProductById(long id) {
		return getService().getSaleProductById(id);
	}

	public static SaleProduct updateSaleProduct(
		long productId, String name, double price, long categoryId,
		long typeId) {

		return getService().updateSaleProduct(
			productId, name, price, categoryId, typeId);
	}

	public static SaleProductService getService() {
		return _service;
	}

	private static volatile SaleProductService _service;

}