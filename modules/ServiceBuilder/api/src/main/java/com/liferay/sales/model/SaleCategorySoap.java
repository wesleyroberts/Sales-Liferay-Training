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

package com.liferay.sales.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.sales.service.http.SaleCategoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SaleCategorySoap implements Serializable {

	public static SaleCategorySoap toSoapModel(SaleCategory model) {
		SaleCategorySoap soapModel = new SaleCategorySoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setName(model.getName());
		soapModel.setTax(model.getTax());

		return soapModel;
	}

	public static SaleCategorySoap[] toSoapModels(SaleCategory[] models) {
		SaleCategorySoap[] soapModels = new SaleCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SaleCategorySoap[][] toSoapModels(SaleCategory[][] models) {
		SaleCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SaleCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SaleCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SaleCategorySoap[] toSoapModels(List<SaleCategory> models) {
		List<SaleCategorySoap> soapModels = new ArrayList<SaleCategorySoap>(
			models.size());

		for (SaleCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SaleCategorySoap[soapModels.size()]);
	}

	public SaleCategorySoap() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryId(pk);
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public double getTax() {
		return _tax;
	}

	public void setTax(double tax) {
		_tax = tax;
	}

	private long _categoryId;
	private String _name;
	private double _tax;

}