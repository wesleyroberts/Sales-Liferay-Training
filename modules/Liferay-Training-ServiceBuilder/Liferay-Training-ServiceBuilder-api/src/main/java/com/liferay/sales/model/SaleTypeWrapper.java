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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SaleType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleType
 * @generated
 */
public class SaleTypeWrapper
	extends BaseModelWrapper<SaleType>
	implements ModelWrapper<SaleType>, SaleType {

	public SaleTypeWrapper(SaleType saleType) {
		super(saleType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("typeId", getTypeId());
		attributes.put("name", getName());
		attributes.put("tax", getTax());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Double tax = (Double)attributes.get("tax");

		if (tax != null) {
			setTax(tax);
		}
	}

	/**
	 * Returns the name of this sale type.
	 *
	 * @return the name of this sale type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this sale type.
	 *
	 * @return the primary key of this sale type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tax of this sale type.
	 *
	 * @return the tax of this sale type
	 */
	@Override
	public double getTax() {
		return model.getTax();
	}

	/**
	 * Returns the type ID of this sale type.
	 *
	 * @return the type ID of this sale type
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the name of this sale type.
	 *
	 * @param name the name of this sale type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this sale type.
	 *
	 * @param primaryKey the primary key of this sale type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tax of this sale type.
	 *
	 * @param tax the tax of this sale type
	 */
	@Override
	public void setTax(double tax) {
		model.setTax(tax);
	}

	/**
	 * Sets the type ID of this sale type.
	 *
	 * @param typeId the type ID of this sale type
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	@Override
	protected SaleTypeWrapper wrap(SaleType saleType) {
		return new SaleTypeWrapper(saleType);
	}

}