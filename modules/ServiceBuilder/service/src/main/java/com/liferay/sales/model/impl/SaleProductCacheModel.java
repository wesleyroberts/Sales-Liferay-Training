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
import com.liferay.sales.model.SaleProduct;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SaleProduct in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SaleProductCacheModel
	implements CacheModel<SaleProduct>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SaleProductCacheModel)) {
			return false;
		}

		SaleProductCacheModel saleProductCacheModel =
			(SaleProductCacheModel)object;

		if (productId == saleProductCacheModel.productId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{productId=");
		sb.append(productId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", price=");
		sb.append(price);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SaleProduct toEntityModel() {
		SaleProductImpl saleProductImpl = new SaleProductImpl();

		saleProductImpl.setProductId(productId);

		if (name == null) {
			saleProductImpl.setName("");
		}
		else {
			saleProductImpl.setName(name);
		}

		saleProductImpl.setPrice(price);
		saleProductImpl.setCategoryId(categoryId);
		saleProductImpl.setTypeId(typeId);
		saleProductImpl.setQuantity(quantity);

		saleProductImpl.resetOriginalValues();

		return saleProductImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		productId = objectInput.readLong();
		name = objectInput.readUTF();

		price = objectInput.readDouble();

		categoryId = objectInput.readLong();

		typeId = objectInput.readLong();

		quantity = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(productId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeDouble(price);

		objectOutput.writeLong(categoryId);

		objectOutput.writeLong(typeId);

		objectOutput.writeInt(quantity);
	}

	public long productId;
	public String name;
	public double price;
	public long categoryId;
	public long typeId;
	public int quantity;

}