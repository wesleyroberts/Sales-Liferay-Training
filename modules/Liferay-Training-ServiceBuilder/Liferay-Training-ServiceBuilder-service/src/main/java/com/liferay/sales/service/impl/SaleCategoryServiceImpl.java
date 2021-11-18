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

package com.liferay.sales.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.sales.model.SaleCategory;
import com.liferay.sales.service.base.SaleCategoryServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the sale category remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.SaleCategoryService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCategoryServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=salestaxe",
		"json.web.service.context.path=SaleCategory"
	},
	service = AopService.class
)
public class SaleCategoryServiceImpl extends SaleCategoryServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.sales.service.SaleCategoryServiceUtil</code> to access the sale category remote service.
	 */
	public SaleCategory createSaleCategory(long id, String name, double tax){
		return saleCategoryLocalService.createSaleCategory(id,name,tax);

	}
	public List<SaleCategory> getAll(){
		return saleCategoryLocalService.getAll();
	}
	public SaleCategory getSaleCategoryById(long id){
		return saleCategoryLocalService.getSaleCategoryById(id);
	}
	public void deleCategoryById(long id){
		saleCategoryLocalService.deleteCategoryById(id);
	}

	public SaleCategory getCategoryByName(String name){
		return saleCategoryLocalService.getByCategoryName(name);
	}
}