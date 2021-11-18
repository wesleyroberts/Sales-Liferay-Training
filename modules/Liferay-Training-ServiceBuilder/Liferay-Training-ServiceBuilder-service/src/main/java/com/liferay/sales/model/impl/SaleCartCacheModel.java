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

package com.liferay.sales.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.sales.model.SaleCart;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SaleCart in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SaleCartCacheModel
	implements CacheModel<SaleCart>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SaleCartCacheModel)) {
			return false;
		}

		SaleCartCacheModel saleCartCacheModel = (SaleCartCacheModel)object;

		if (cartId == saleCartCacheModel.cartId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cartId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{cartId=");
		sb.append(cartId);
		sb.append(", totalPrice=");
		sb.append(totalPrice);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SaleCart toEntityModel() {
		SaleCartImpl saleCartImpl = new SaleCartImpl();

		saleCartImpl.setCartId(cartId);
		saleCartImpl.setTotalPrice(totalPrice);

		saleCartImpl.resetOriginalValues();

		return saleCartImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cartId = objectInput.readLong();

		totalPrice = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(cartId);

		objectOutput.writeDouble(totalPrice);
	}

	public long cartId;
	public double totalPrice;

}