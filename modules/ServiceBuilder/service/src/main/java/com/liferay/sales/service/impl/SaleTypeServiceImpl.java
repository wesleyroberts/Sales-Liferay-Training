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
import com.liferay.sales.model.SaleType;
import com.liferay.sales.service.base.SaleTypeServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the sale type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.SaleTypeService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleTypeServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=salestaxe",
		"json.web.service.context.path=SaleType"
	},
	service = AopService.class
)
public class SaleTypeServiceImpl extends SaleTypeServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.sales.service.SaleTypeServiceUtil</code> to access the sale type remote service.
	 */
	public SaleType createSaleType(String name, double tax){
		return saleTypeLocalService.createSaleType(name, tax);
	}

	@Override
	public void deleteTypeById(long id) {
		saleTypeLocalService.deleteTypeById(id);
	}

	public List<SaleType> getAll(){
		return saleTypeLocalService.getAll();
	}

	public SaleType getSaleTypeByID(long id){
		return saleTypeLocalService.getSaleTypeById(id);
	}
}