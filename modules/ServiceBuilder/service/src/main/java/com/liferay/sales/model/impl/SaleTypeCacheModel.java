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
import com.liferay.sales.model.SaleType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SaleType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SaleTypeCacheModel
	implements CacheModel<SaleType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SaleTypeCacheModel)) {
			return false;
		}

		SaleTypeCacheModel saleTypeCacheModel = (SaleTypeCacheModel)object;

		if (typeId == saleTypeCacheModel.typeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, typeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{typeId=");
		sb.append(typeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", tax=");
		sb.append(tax);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SaleType toEntityModel() {
		SaleTypeImpl saleTypeImpl = new SaleTypeImpl();

		saleTypeImpl.setTypeId(typeId);

		if (name == null) {
			saleTypeImpl.setName("");
		}
		else {
			saleTypeImpl.setName(name);
		}

		saleTypeImpl.setTax(tax);

		saleTypeImpl.resetOriginalValues();

		return saleTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		typeId = objectInput.readLong();
		name = objectInput.readUTF();

		tax = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(typeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeDouble(tax);
	}

	public long typeId;
	public String name;
	public double tax;

}