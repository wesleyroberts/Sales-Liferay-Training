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
 * This class is used by SOAP remote services, specifically {@link com.liferay.sales.service.http.SaleStockServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SaleStockSoap implements Serializable {

	public static SaleStockSoap toSoapModel(SaleStock model) {
		SaleStockSoap soapModel = new SaleStockSoap();

		soapModel.setStockId(model.getStockId());
		soapModel.setName(model.getName());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setPrice(model.getPrice());

		return soapModel;
	}

	public static SaleStockSoap[] toSoapModels(SaleStock[] models) {
		SaleStockSoap[] soapModels = new SaleStockSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SaleStockSoap[][] toSoapModels(SaleStock[][] models) {
		SaleStockSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SaleStockSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SaleStockSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SaleStockSoap[] toSoapModels(List<SaleStock> models) {
		List<SaleStockSoap> soapModels = new ArrayList<SaleStockSoap>(
			models.size());

		for (SaleStock model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SaleStockSoap[soapModels.size()]);
	}

	public SaleStockSoap() {
	}

	public long getPrimaryKey() {
		return _StockId;
	}

	public void setPrimaryKey(long pk) {
		setStockId(pk);
	}

	public long getStockId() {
		return _StockId;
	}

	public void setStockId(long StockId) {
		_StockId = StockId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	private long _StockId;
	private String _name;
	private int _quantity;
	private long _typeId;
	private long _categoryId;
	private double _price;

}