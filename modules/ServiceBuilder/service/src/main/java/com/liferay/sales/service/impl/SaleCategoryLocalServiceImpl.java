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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.sales.exception.NoSuchSaleCategoryException;
import com.liferay.sales.model.SaleCategory;
import com.liferay.sales.service.base.SaleCategoryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the sale category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.sales.service.SaleCategoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCategoryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.sales.model.SaleCategory",
	service = AopService.class
)
public class SaleCategoryLocalServiceImpl
	extends SaleCategoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.sales.service.SaleCategoryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.sales.service.SaleCategoryLocalServiceUtil</code>.
	 */
	public SaleCategory createSaleCategory(String name,double tax){

		SaleCategory category = saleCategoryPersistence.create(counterLocalService.increment());
		if(!(name == null || name.equals(""))){
			category.setTax(tax);
			category.setName(name);
			return saleCategoryPersistence.update(category);
		}else{
			return  null;
		}
	}

	public SaleCategory updateSaleCategory(long id, String name, double tax){

		SaleCategory updateCategory = null;
		try {
			updateCategory = saleCategoryPersistence.findByPrimaryKey(id);
		} catch (NoSuchSaleCategoryException e) {
			e.printStackTrace();
		}
			if (updateCategory != null) {
				if(!(name == null || name.equals(""))) {
					updateCategory.setName(name);
					updateCategory.setTax(tax);
					return saleCategoryPersistence.update(updateCategory);
				}else{
					return null;
				}
			}else{
				return null;
		}
	}

	public List<SaleCategory> getAll(){
		try{
		return saleCategoryPersistence.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return  null;
		}
	}

	public SaleCategory getByCategoryName(String name){
		try {
			return saleCategoryPersistence.findByName(name);
		} catch (NoSuchSaleCategoryException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public SaleCategory getSaleCategoryById(long id){
		try {
			return saleCategoryPersistence.findByPrimaryKey(id);
		} catch (NoSuchSaleCategoryException | IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteCategoryById(long id){
		try {
			saleCategoryPersistence.remove(id);
		} catch (NoSuchSaleCategoryException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}