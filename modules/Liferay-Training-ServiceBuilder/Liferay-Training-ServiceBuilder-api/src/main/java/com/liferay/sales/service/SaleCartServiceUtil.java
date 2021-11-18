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

import com.liferay.sales.model.SaleCart;

import java.util.List;

/**
 * Provides the remote service utility for SaleCart. This utility wraps
 * <code>com.liferay.sales.service.impl.SaleCartServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SaleCartService
 * @generated
 */
public class SaleCartServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sales.service.impl.SaleCartServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SaleCart addProductPriceToCartTotalValue(
		double price, long cartId) {

		return getService().addProductPriceToCartTotalValue(price, cartId);
	}

	public static SaleCart createSaleCartById(long id) {
		return getService().createSaleCartById(id);
	}

	public static void deleteSaleCartById(long id) {
		getService().deleteSaleCartById(id);
	}

	public static List<SaleCart> getAllSaleCart() {
		return getService().getAllSaleCart();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SaleCart getSaleCartById(long id) {
		return getService().getSaleCartById(id);
	}

	public static SaleCart removeProductPriceToCartTotalValue(
		double price, long cartId) {

		return getService().removeProductPriceToCartTotalValue(price, cartId);
	}

	public static SaleCartService getService() {
		return _service;
	}

	private static volatile SaleCartService _service;

}