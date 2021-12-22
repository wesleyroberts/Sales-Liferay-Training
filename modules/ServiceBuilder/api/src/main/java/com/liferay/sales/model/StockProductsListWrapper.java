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
 * This class is a wrapper for {@link StockProductsList}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StockProductsList
 * @generated
 */
public class StockProductsListWrapper
	extends BaseModelWrapper<StockProductsList>
	implements ModelWrapper<StockProductsList>, StockProductsList {

	public StockProductsListWrapper(StockProductsList stockProductsList) {
		super(stockProductsList);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productId", getProductId());
		attributes.put("StockId", getStockId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long StockId = (Long)attributes.get("StockId");

		if (StockId != null) {
			setStockId(StockId);
		}
	}

	/**
	 * Returns the primary key of this stock products list.
	 *
	 * @return the primary key of this stock products list
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product ID of this stock products list.
	 *
	 * @return the product ID of this stock products list
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	/**
	 * Returns the stock ID of this stock products list.
	 *
	 * @return the stock ID of this stock products list
	 */
	@Override
	public long getStockId() {
		return model.getStockId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this stock products list.
	 *
	 * @param primaryKey the primary key of this stock products list
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product ID of this stock products list.
	 *
	 * @param productId the product ID of this stock products list
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	/**
	 * Sets the stock ID of this stock products list.
	 *
	 * @param StockId the stock ID of this stock products list
	 */
	@Override
	public void setStockId(long StockId) {
		model.setStockId(StockId);
	}

	@Override
	protected StockProductsListWrapper wrap(
		StockProductsList stockProductsList) {

		return new StockProductsListWrapper(stockProductsList);
	}

}