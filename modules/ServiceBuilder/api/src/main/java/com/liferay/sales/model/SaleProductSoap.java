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
 * This class is used by SOAP remote services, specifically {@link com.liferay.sales.service.http.SaleProductServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SaleProductSoap implements Serializable {

	public static SaleProductSoap toSoapModel(SaleProduct model) {
		SaleProductSoap soapModel = new SaleProductSoap();

		soapModel.setProductId(model.getProductId());
		soapModel.setName(model.getName());
		soapModel.setPrice(model.getPrice());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setQuantity(model.getQuantity());

		return soapModel;
	}

	public static SaleProductSoap[] toSoapModels(SaleProduct[] models) {
		SaleProductSoap[] soapModels = new SaleProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SaleProductSoap[][] toSoapModels(SaleProduct[][] models) {
		SaleProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SaleProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SaleProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SaleProductSoap[] toSoapModels(List<SaleProduct> models) {
		List<SaleProductSoap> soapModels = new ArrayList<SaleProductSoap>(
			models.size());

		for (SaleProduct model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SaleProductSoap[soapModels.size()]);
	}

	public SaleProductSoap() {
	}

	public long getPrimaryKey() {
		return _productId;
	}

	public void setPrimaryKey(long pk) {
		setProductId(pk);
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	private long _productId;
	private String _name;
	private double _price;
	private long _categoryId;
	private long _typeId;
	private int _quantity;

}