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
 * Provides a wrapper for {@link SaleCategoryService}.
 *
 * @author Brian Wing Shun Chan
 * @see SaleCategoryService
 * @generated
 */
public class SaleCategoryServiceWrapper
	implements SaleCategoryService, ServiceWrapper<SaleCategoryService> {

	public SaleCategoryServiceWrapper(SaleCategoryService saleCategoryService) {
		_saleCategoryService = saleCategoryService;
	}

	@Override
	public com.liferay.sales.model.SaleCategory createSaleCategory(
		String name, double tax) {

		return _saleCategoryService.createSaleCategory(name, tax);
	}

	@Override
	public void deleteCategoryById(long id) {
		_saleCategoryService.deleteCategoryById(id);
	}

	@Override
	public java.util.List<com.liferay.sales.model.SaleCategory>
		getAllSaleCategory() {

		return _saleCategoryService.getAllSaleCategory();
	}

	@Override
	public com.liferay.sales.model.SaleCategory getCategoryByName(String name) {
		return _saleCategoryService.getCategoryByName(name);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saleCategoryService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.sales.model.SaleCategory getSaleCategoryById(long id) {
		return _saleCategoryService.getSaleCategoryById(id);
	}

	@Override
	public com.liferay.sales.model.SaleCategory updateSaleCategory(
		long id, String name, double tax) {

		return _saleCategoryService.updateSaleCategory(id, name, tax);
	}

	@Override
	public SaleCategoryService getWrappedService() {
		return _saleCategoryService;
	}

	@Override
	public void setWrappedService(SaleCategoryService saleCategoryService) {
		_saleCategoryService = saleCategoryService;
	}

	private SaleCategoryService _saleCategoryService;

}