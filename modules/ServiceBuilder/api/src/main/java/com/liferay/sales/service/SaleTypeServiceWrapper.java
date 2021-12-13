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
 * Provides a wrapper for {@link SaleTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see SaleTypeService
 * @generated
 */
public class SaleTypeServiceWrapper
	implements SaleTypeService, ServiceWrapper<SaleTypeService> {

	public SaleTypeServiceWrapper(SaleTypeService saleTypeService) {
		_saleTypeService = saleTypeService;
	}

	@Override
	public com.liferay.sales.model.SaleType createSaleType(
		String name, double tax) {

		return _saleTypeService.createSaleType(name, tax);
	}

	@Override
	public void deleteTypeById(long id) {
		_saleTypeService.deleteTypeById(id);
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleType> getAll() {
		return _saleTypeService.getAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saleTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.sales.model.SaleType getSaleTypeByID(long id) {
		return _saleTypeService.getSaleTypeByID(id);
	}

	@Override
	public SaleTypeService getWrappedService() {
		return _saleTypeService;
	}

	@Override
	public void setWrappedService(SaleTypeService saleTypeService) {
		_saleTypeService = saleTypeService;
	}

	private SaleTypeService _saleTypeService;

}