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
 * This class is a wrapper for {@link SaleCategory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCategory
 * @generated
 */
public class SaleCategoryWrapper
	extends BaseModelWrapper<SaleCategory>
	implements ModelWrapper<SaleCategory>, SaleCategory {

	public SaleCategoryWrapper(SaleCategory saleCategory) {
		super(saleCategory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("name", getName());
		attributes.put("tax", getTax());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
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
	 * Returns the category ID of this sale category.
	 *
	 * @return the category ID of this sale category
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the name of this sale category.
	 *
	 * @return the name of this sale category
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this sale category.
	 *
	 * @return the primary key of this sale category
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tax of this sale category.
	 *
	 * @return the tax of this sale category
	 */
	@Override
	public double getTax() {
		return model.getTax();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the category ID of this sale category.
	 *
	 * @param categoryId the category ID of this sale category
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the name of this sale category.
	 *
	 * @param name the name of this sale category
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this sale category.
	 *
	 * @param primaryKey the primary key of this sale category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tax of this sale category.
	 *
	 * @param tax the tax of this sale category
	 */
	@Override
	public void setTax(double tax) {
		model.setTax(tax);
	}

	@Override
	protected SaleCategoryWrapper wrap(SaleCategory saleCategory) {
		return new SaleCategoryWrapper(saleCategory);
	}

}