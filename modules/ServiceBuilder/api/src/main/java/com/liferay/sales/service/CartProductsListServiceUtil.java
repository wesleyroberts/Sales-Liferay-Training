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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.sales.model.CartProductsList;

import java.util.List;

/**
 * Provides the remote service utility for CartProductsList. This utility wraps
 * <code>com.liferay.sales.service.impl.CartProductsListServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CartProductsListService
 * @generated
 */
public class CartProductsListServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sales.service.impl.CartProductsListServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.sales.model.SaleCart addProductToCartList(
		long productId, long cartId) {

		return getService().addProductToCartList(productId, cartId);
	}

	public static CartProductsList deleteCartProductsList(long productId)
		throws PortalException {

		return getService().deleteCartProductsList(productId);
	}

	public static List<com.liferay.sales.model.SaleProduct>
		getAllProductsByCarID(long id) {

		return getService().getAllProductsByCarID(id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void removeProductToCartList(long productId, long cartId) {
		getService().removeProductToCartList(productId, cartId);
	}

	public static CartProductsListService getService() {
		return _service;
	}

	private static volatile CartProductsListService _service;

}