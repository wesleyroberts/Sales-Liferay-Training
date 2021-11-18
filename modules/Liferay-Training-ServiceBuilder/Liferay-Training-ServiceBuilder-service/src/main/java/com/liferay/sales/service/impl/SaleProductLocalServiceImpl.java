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
import com.liferay.sales.exception.NoSuchSaleProductException;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.base.SaleProductLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the sale product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.SaleProductLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleProductLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.sales.model.SaleProduct",
	service = AopService.class
)
public class SaleProductLocalServiceImpl
	extends SaleProductLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.sales.service.SaleProductLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.sales.service.SaleProductLocalServiceUtil</code>.
	 */
	public SaleProduct createProduct(String name, double price, long productId, long categoryId, long typeId){
		try{
			SaleProduct product = saleProductPersistence.create(productId);
			product.setName(name);
			product.setPrice(price);
			product.setCategoryId(categoryId);
			product.setTypeId(typeId);
			return saleProductPersistence.update(product);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<SaleProduct> getAll(){
		try {
			return saleProductPersistence.findAll();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public SaleProduct getById(long id){
		try {
			return saleProductPersistence.findByPrimaryKey(id);
		} catch ( NoSuchSaleProductException e) {
			e.printStackTrace();
			return null;
		}
	}

	public SaleProduct getByName(String name){
		try {
			return saleProductPersistence.findByName(name);
		} catch (NoSuchSaleProductException e) {
			e.printStackTrace();
			return null;
		}
	}

	public SaleProduct deleteById(long id){
		try {
			return saleProductPersistence.remove(id);
		} catch ( NoSuchSaleProductException e) {
			e.printStackTrace();
			return null;
		}
	}

}