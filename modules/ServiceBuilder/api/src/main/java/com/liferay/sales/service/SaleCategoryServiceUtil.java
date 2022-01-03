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

import com.liferay.sales.model.SaleCategory;

import java.util.List;

/**
 * Provides the remote service utility for SaleCategory. This utility wraps
 * <code>com.liferay.sales.service.impl.SaleCategoryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SaleCategoryService
 * @generated
 */
public class SaleCategoryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sales.service.impl.SaleCategoryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SaleCategory addSaleCategory(String name, double tax) {
		return getService().addSaleCategory(name, tax);
	}

	public static void deleteCategoryById(long id) {
		getService().deleteCategoryById(id);
	}

	public static List<SaleCategory> getAllSaleCategory() {
		return getService().getAllSaleCategory();
	}

	public static SaleCategory getCategoryByName(String name) {
		return getService().getCategoryByName(name);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SaleCategory getSaleCategoryById(long id) {
		return getService().getSaleCategoryById(id);
	}

	public static SaleCategory updateSaleCategory(
		long id, String name, double tax) {

		return getService().updateSaleCategory(id, name, tax);
	}

	public static SaleCategoryService getService() {
		return _service;
	}

	private static volatile SaleCategoryService _service;

}