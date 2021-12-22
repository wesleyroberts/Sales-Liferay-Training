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
 * This class is used by SOAP remote services, specifically {@link com.liferay.sales.service.http.StockProductsListServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class StockProductsListSoap implements Serializable {

	public static StockProductsListSoap toSoapModel(StockProductsList model) {
		StockProductsListSoap soapModel = new StockProductsListSoap();

		soapModel.setProductId(model.getProductId());
		soapModel.setStockId(model.getStockId());

		return soapModel;
	}

	public static StockProductsListSoap[] toSoapModels(
		StockProductsList[] models) {

		StockProductsListSoap[] soapModels =
			new StockProductsListSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StockProductsListSoap[][] toSoapModels(
		StockProductsList[][] models) {

		StockProductsListSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StockProductsListSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StockProductsListSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StockProductsListSoap[] toSoapModels(
		List<StockProductsList> models) {

		List<StockProductsListSoap> soapModels =
			new ArrayList<StockProductsListSoap>(models.size());

		for (StockProductsList model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StockProductsListSoap[soapModels.size()]);
	}

	public StockProductsListSoap() {
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

	public long getStockId() {
		return _StockId;
	}

	public void setStockId(long StockId) {
		_StockId = StockId;
	}

	private long _productId;
	private long _StockId;

}