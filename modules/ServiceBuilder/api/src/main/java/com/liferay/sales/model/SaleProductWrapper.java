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
 * This class is a wrapper for {@link SaleProduct}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleProduct
 * @generated
 */
public class SaleProductWrapper
	extends BaseModelWrapper<SaleProduct>
	implements ModelWrapper<SaleProduct>, SaleProduct {

	public SaleProductWrapper(SaleProduct saleProduct) {
		super(saleProduct);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productId", getProductId());
		attributes.put("name", getName());
		attributes.put("price", getPrice());
		attributes.put("categoryId", getCategoryId());
		attributes.put("typeId", getTypeId());
		attributes.put("quantity", getQuantity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}
	}

	/**
	 * Returns the category ID of this sale product.
	 *
	 * @return the category ID of this sale product
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the name of this sale product.
	 *
	 * @return the name of this sale product
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the price of this sale product.
	 *
	 * @return the price of this sale product
	 */
	@Override
	public double getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this sale product.
	 *
	 * @return the primary key of this sale product
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product ID of this sale product.
	 *
	 * @return the product ID of this sale product
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	/**
	 * Returns the quantity of this sale product.
	 *
	 * @return the quantity of this sale product
	 */
	@Override
	public int getQuantity() {
		return model.getQuantity();
	}

	/**
	 * Returns the type ID of this sale product.
	 *
	 * @return the type ID of this sale product
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
	 * Sets the category ID of this sale product.
	 *
	 * @param categoryId the category ID of this sale product
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the name of this sale product.
	 *
	 * @param name the name of this sale product
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the price of this sale product.
	 *
	 * @param price the price of this sale product
	 */
	@Override
	public void setPrice(double price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this sale product.
	 *
	 * @param primaryKey the primary key of this sale product
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product ID of this sale product.
	 *
	 * @param productId the product ID of this sale product
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	/**
	 * Sets the quantity of this sale product.
	 *
	 * @param quantity the quantity of this sale product
	 */
	@Override
	public void setQuantity(int quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the type ID of this sale product.
	 *
	 * @param typeId the type ID of this sale product
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	@Override
	protected SaleProductWrapper wrap(SaleProduct saleProduct) {
		return new SaleProductWrapper(saleProduct);
	}

}