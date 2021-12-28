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
 * This class is used by SOAP remote services, specifically {@link com.liferay.sales.service.http.SaleCartServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SaleCartSoap implements Serializable {

	public static SaleCartSoap toSoapModel(SaleCart model) {
		SaleCartSoap soapModel = new SaleCartSoap();

		soapModel.setCartId(model.getCartId());
		soapModel.setTotalPrice(model.getTotalPrice());
		soapModel.setAble(model.isAble());

		return soapModel;
	}

	public static SaleCartSoap[] toSoapModels(SaleCart[] models) {
		SaleCartSoap[] soapModels = new SaleCartSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SaleCartSoap[][] toSoapModels(SaleCart[][] models) {
		SaleCartSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SaleCartSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SaleCartSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SaleCartSoap[] toSoapModels(List<SaleCart> models) {
		List<SaleCartSoap> soapModels = new ArrayList<SaleCartSoap>(
			models.size());

		for (SaleCart model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SaleCartSoap[soapModels.size()]);
	}

	public SaleCartSoap() {
	}

	public long getPrimaryKey() {
		return _cartId;
	}

	public void setPrimaryKey(long pk) {
		setCartId(pk);
	}

	public long getCartId() {
		return _cartId;
	}

	public void setCartId(long cartId) {
		_cartId = cartId;
	}

	public double getTotalPrice() {
		return _totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		_totalPrice = totalPrice;
	}

	public boolean getAble() {
		return _able;
	}

	public boolean isAble() {
		return _able;
	}

	public void setAble(boolean able) {
		_able = able;
	}

	private long _cartId;
	private double _totalPrice;
	private boolean _able;

}