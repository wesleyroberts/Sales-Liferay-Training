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
import com.liferay.sales.model.SaleCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SaleCategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SaleCategoryCacheModel
	implements CacheModel<SaleCategory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SaleCategoryCacheModel)) {
			return false;
		}

		SaleCategoryCacheModel saleCategoryCacheModel =
			(SaleCategoryCacheModel)object;

		if (categoryId == saleCategoryCacheModel.categoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, categoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", tax=");
		sb.append(tax);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SaleCategory toEntityModel() {
		SaleCategoryImpl saleCategoryImpl = new SaleCategoryImpl();

		saleCategoryImpl.setCategoryId(categoryId);

		if (name == null) {
			saleCategoryImpl.setName("");
		}
		else {
			saleCategoryImpl.setName(name);
		}

		saleCategoryImpl.setTax(tax);

		saleCategoryImpl.resetOriginalValues();

		return saleCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		categoryId = objectInput.readLong();
		name = objectInput.readUTF();

		tax = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(categoryId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeDouble(tax);
	}

	public long categoryId;
	public String name;
	public double tax;

}