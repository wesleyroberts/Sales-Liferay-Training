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

import com.liferay.sales.model.SaleType;

import java.util.List;

/**
 * Provides the remote service utility for SaleType. This utility wraps
 * <code>com.liferay.sales.service.impl.SaleTypeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SaleTypeService
 * @generated
 */
public class SaleTypeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sales.service.impl.SaleTypeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SaleType addSaleType(String name, double tax) {
		return getService().addSaleType(name, tax);
	}

	public static void deleteTypeById(long id) {
		getService().deleteTypeById(id);
	}

	public static List<SaleType> getAllSaleType() {
		return getService().getAllSaleType();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SaleType getSaleTypeByID(long id) {
		return getService().getSaleTypeByID(id);
	}

	public static SaleType updateSaleType(Long id, String name, double tax) {
		return getService().updateSaleType(id, name, tax);
	}

	public static SaleTypeService getService() {
		return _service;
	}

	private static volatile SaleTypeService _service;

}