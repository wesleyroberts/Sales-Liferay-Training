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
 * This class is a wrapper for {@link SaleStock}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleStock
 * @generated
 */
public class SaleStockWrapper
	extends BaseModelWrapper<SaleStock>
	implements ModelWrapper<SaleStock>, SaleStock {

	public SaleStockWrapper(SaleStock saleStock) {
		super(saleStock);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("StockId", getStockId());
		attributes.put("name", getName());
		attributes.put("quantity", getQuantity());
		attributes.put("typeId", getTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long StockId = (Long)attributes.get("StockId");

		if (StockId != null) {
			setStockId(StockId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}
	}

	/**
	 * Returns the name of this sale stock.
	 *
	 * @return the name of this sale stock
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this sale stock.
	 *
	 * @return the primary key of this sale stock
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quantity of this sale stock.
	 *
	 * @return the quantity of this sale stock
	 */
	@Override
	public int getQuantity() {
		return model.getQuantity();
	}

	/**
	 * Returns the stock ID of this sale stock.
	 *
	 * @return the stock ID of this sale stock
	 */
	@Override
	public long getStockId() {
		return model.getStockId();
	}

	/**
	 * Returns the type ID of this sale stock.
	 *
	 * @return the type ID of this sale stock
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
	 * Sets the name of this sale stock.
	 *
	 * @param name the name of this sale stock
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this sale stock.
	 *
	 * @param primaryKey the primary key of this sale stock
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quantity of this sale stock.
	 *
	 * @param quantity the quantity of this sale stock
	 */
	@Override
	public void setQuantity(int quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the stock ID of this sale stock.
	 *
	 * @param StockId the stock ID of this sale stock
	 */
	@Override
	public void setStockId(long StockId) {
		model.setStockId(StockId);
	}

	/**
	 * Sets the type ID of this sale stock.
	 *
	 * @param typeId the type ID of this sale stock
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	@Override
	protected SaleStockWrapper wrap(SaleStock saleStock) {
		return new SaleStockWrapper(saleStock);
	}

}