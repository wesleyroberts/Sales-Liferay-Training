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
import com.liferay.sales.model.StockProductsList;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StockProductsList in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StockProductsListCacheModel
	implements CacheModel<StockProductsList>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StockProductsListCacheModel)) {
			return false;
		}

		StockProductsListCacheModel stockProductsListCacheModel =
			(StockProductsListCacheModel)object;

		if (productId == stockProductsListCacheModel.productId) {
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
		StringBundler sb = new StringBundler(5);

		sb.append("{productId=");
		sb.append(productId);
		sb.append(", StockId=");
		sb.append(StockId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StockProductsList toEntityModel() {
		StockProductsListImpl stockProductsListImpl =
			new StockProductsListImpl();

		stockProductsListImpl.setProductId(productId);
		stockProductsListImpl.setStockId(StockId);

		stockProductsListImpl.resetOriginalValues();

		return stockProductsListImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		productId = objectInput.readLong();

		StockId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(productId);

		objectOutput.writeLong(StockId);
	}

	public long productId;
	public long StockId;

}