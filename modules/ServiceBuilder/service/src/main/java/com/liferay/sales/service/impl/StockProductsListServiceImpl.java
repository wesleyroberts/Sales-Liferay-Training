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
import com.liferay.sales.model.SaleStock;
import com.liferay.sales.service.base.StockProductsListServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the stock products list remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.StockProductsListService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StockProductsListServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=salestaxe",
		"json.web.service.context.path=StockProductsList"
	},
	service = AopService.class
)
public class StockProductsListServiceImpl
	extends StockProductsListServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.sales.service.StockProductsListServiceUtil</code> to access the stock products list remote service.
	 */

	public SaleStock addProductToStock(SaleProduct product){
		return stockProductsListLocalService.addProductToStock(product);
	}

	public List<SaleProduct> getAllProductInStock(){
		return stockProductsListLocalService.getAllProductInStock();
	}

	public List<SaleProduct> getAllProductInStockByProductName(String name){
		return stockProductsListLocalService.getAllProductInStockByProductName(name);
	}
	public void deleteStockProductListByID(long id){
		 stockProductsListLocalService.deleteStockProductListByID(id);
	}
	public void removeProductFromStock(long productID){
		stockProductsListLocalService.removeProductFromStock(productID);
	}
}