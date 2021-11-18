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
 * This class is used by SOAP remote services, specifically {@link com.liferay.sales.service.http.CartProductsListServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CartProductsListSoap implements Serializable {

	public static CartProductsListSoap toSoapModel(CartProductsList model) {
		CartProductsListSoap soapModel = new CartProductsListSoap();

		soapModel.setProductId(model.getProductId());
		soapModel.setCartId(model.getCartId());

		return soapModel;
	}

	public static CartProductsListSoap[] toSoapModels(
		CartProductsList[] models) {

		CartProductsListSoap[] soapModels =
			new CartProductsListSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CartProductsListSoap[][] toSoapModels(
		CartProductsList[][] models) {

		CartProductsListSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CartProductsListSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CartProductsListSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CartProductsListSoap[] toSoapModels(
		List<CartProductsList> models) {

		List<CartProductsListSoap> soapModels =
			new ArrayList<CartProductsListSoap>(models.size());

		for (CartProductsList model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CartProductsListSoap[soapModels.size()]);
	}

	public CartProductsListSoap() {
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

	public long getCartId() {
		return _cartId;
	}

	public void setCartId(long cartId) {
		_cartId = cartId;
	}

	private long _productId;
	private long _cartId;

}