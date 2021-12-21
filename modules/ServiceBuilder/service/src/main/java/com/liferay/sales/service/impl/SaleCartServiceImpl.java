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
import com.liferay.sales.model.SaleCart;
import com.liferay.sales.service.base.SaleCartServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the sale cart remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.SaleCartService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCartServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=salestaxe",
		"json.web.service.context.path=SaleCart"
	},
	service = AopService.class
)
public class SaleCartServiceImpl extends SaleCartServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.sales.service.SaleCartServiceUtil</code> to access the sale cart remote service.
	 */
	public List<SaleCart> getAllSaleCart(){
		return saleCartLocalService.getAllSaleCart();
	}

	public SaleCart getSaleCartById(long id){
		return saleCartLocalService.getSaleCartById(id);
	}

	public SaleCart addProductPriceToCartTotalValue(double price,long cartId){
		return saleCartLocalService.addProductPriceToCartTotalValue(price,cartId);
	}

	public SaleCart removeProductPriceToCartTotalValue(double price,long cartId){
		return saleCartLocalService.removeProductPriceToCartTotalValue(price,cartId);
	}

	public Double getFinalValueByCartId(long cartId){
		return saleCartLocalService.getFinalValueByCartId(cartId);
	}

	public SaleCart createSaleCartById(){
		return saleCartLocalService.createSaleCartById();
	}

	public void deleteSaleCartById(long id){
		saleCartLocalService.deleteSaleCartById(id);
	}
}