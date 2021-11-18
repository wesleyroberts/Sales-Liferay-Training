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
 * This class is a wrapper for {@link SaleCart}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCart
 * @generated
 */
public class SaleCartWrapper
	extends BaseModelWrapper<SaleCart>
	implements ModelWrapper<SaleCart>, SaleCart {

	public SaleCartWrapper(SaleCart saleCart) {
		super(saleCart);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cartId", getCartId());
		attributes.put("totalPrice", getTotalPrice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cartId = (Long)attributes.get("cartId");

		if (cartId != null) {
			setCartId(cartId);
		}

		Double totalPrice = (Double)attributes.get("totalPrice");

		if (totalPrice != null) {
			setTotalPrice(totalPrice);
		}
	}

	/**
	 * Returns the cart ID of this sale cart.
	 *
	 * @return the cart ID of this sale cart
	 */
	@Override
	public long getCartId() {
		return model.getCartId();
	}

	/**
	 * Returns the primary key of this sale cart.
	 *
	 * @return the primary key of this sale cart
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the total price of this sale cart.
	 *
	 * @return the total price of this sale cart
	 */
	@Override
	public double getTotalPrice() {
		return model.getTotalPrice();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cart ID of this sale cart.
	 *
	 * @param cartId the cart ID of this sale cart
	 */
	@Override
	public void setCartId(long cartId) {
		model.setCartId(cartId);
	}

	/**
	 * Sets the primary key of this sale cart.
	 *
	 * @param primaryKey the primary key of this sale cart
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the total price of this sale cart.
	 *
	 * @param totalPrice the total price of this sale cart
	 */
	@Override
	public void setTotalPrice(double totalPrice) {
		model.setTotalPrice(totalPrice);
	}

	@Override
	protected SaleCartWrapper wrap(SaleCart saleCart) {
		return new SaleCartWrapper(saleCart);
	}

}