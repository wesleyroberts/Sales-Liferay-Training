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
 * This class is used by SOAP remote services, specifically {@link com.liferay.sales.service.http.SaleTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SaleTypeSoap implements Serializable {

	public static SaleTypeSoap toSoapModel(SaleType model) {
		SaleTypeSoap soapModel = new SaleTypeSoap();

		soapModel.setTypeId(model.getTypeId());
		soapModel.setName(model.getName());
		soapModel.setTax(model.getTax());

		return soapModel;
	}

	public static SaleTypeSoap[] toSoapModels(SaleType[] models) {
		SaleTypeSoap[] soapModels = new SaleTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SaleTypeSoap[][] toSoapModels(SaleType[][] models) {
		SaleTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SaleTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SaleTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SaleTypeSoap[] toSoapModels(List<SaleType> models) {
		List<SaleTypeSoap> soapModels = new ArrayList<SaleTypeSoap>(
			models.size());

		for (SaleType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SaleTypeSoap[soapModels.size()]);
	}

	public SaleTypeSoap() {
	}

	public long getPrimaryKey() {
		return _typeId;
	}

	public void setPrimaryKey(long pk) {
		setTypeId(pk);
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
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

	private long _typeId;
	private String _name;
	private double _tax;

}