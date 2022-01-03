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
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.base.SaleProductServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the sale product remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.SaleProductService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleProductServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=salestaxe",
		"json.web.service.context.path=SaleProduct"
	},
	service = AopService.class
)
public class SaleProductServiceImpl extends SaleProductServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.sales.service.SaleProductServiceUtil</code> to access the sale product remote service.
	 */

	public List<SaleProduct> createSaleProductInScale(String name, double price,long categoryId, long typeId,int quantity){
		return saleProductLocalService.addSaleProductInScale(name, price, categoryId, typeId,quantity);
	}

	public List<SaleProduct> getAllSaleProducts(){
		return saleProductLocalService.getAllSaleProduct();
	}

	public SaleProduct updateSaleProduct(long productId, String name, double price, long categoryId, long typeId){
		return saleProductLocalService.updateSaleProduct(productId, name, price, categoryId, typeId);
	}

	public SaleProduct getSaleProductById(long id){
		return saleProductLocalService.getSalePoductById(id);
	}

	public void deleteById(long id){
		 saleProductLocalService.deleteSaleProductById(id);
	}

}