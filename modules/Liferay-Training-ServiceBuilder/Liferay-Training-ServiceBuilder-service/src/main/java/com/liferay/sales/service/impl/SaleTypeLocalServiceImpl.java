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
import com.liferay.sales.exception.NoSuchSaleTypeException;
import com.liferay.sales.model.SaleType;
import com.liferay.sales.service.base.SaleTypeLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * The implementation of the sale type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.SaleTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleTypeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.sales.model.SaleType",
	service = AopService.class
)
public class SaleTypeLocalServiceImpl extends SaleTypeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.sales.service.SaleTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.sales.service.SaleTypeLocalServiceUtil</code>.
	 */
	public SaleType createSaleType(long id, String name, double tax){
		try{
		SaleType saleType = saleTypePersistence.create(id);
		saleType.setTax(tax);
		saleType.setName(name);
		return saleTypePersistence.update(saleType);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<SaleType> getAll(){
		try {
			return saleTypePersistence.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteTypeById(long id){
		try {
			saleTypePersistence.remove(id);
		} catch (NoSuchSaleTypeException e) {
			e.printStackTrace();
		}
	}

	public SaleType getSaleTypeById(long id){
		try {
			return saleTypePersistence.findByPrimaryKey(id);
		} catch (NoSuchSaleTypeException e) {
			e.printStackTrace();
			return null;
		}
	}
}