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
 * This class is a wrapper for {@link CartProductsList}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CartProductsList
 * @generated
 */
public class CartProductsListWrapper
	extends BaseModelWrapper<CartProductsList>
	implements CartProductsList, ModelWrapper<CartProductsList> {

	public CartProductsListWrapper(CartProductsList cartProductsList) {
		super(cartProductsList);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productId", getProductId());
		attributes.put("cartId", getCartId());
		attributes.put("quantity", getQuantity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long cartId = (Long)attributes.get("cartId");

		if (cartId != null) {
			setCartId(cartId);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}
	}

	/**
	 * Returns the cart ID of this cart products list.
	 *
	 * @return the cart ID of this cart products list
	 */
	@Override
	public long getCartId() {
		return model.getCartId();
	}

	/**
	 * Returns the primary key of this cart products list.
	 *
	 * @return the primary key of this cart products list
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product ID of this cart products list.
	 *
	 * @return the product ID of this cart products list
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	/**
	 * Returns the quantity of this cart products list.
	 *
	 * @return the quantity of this cart products list
	 */
	@Override
	public int getQuantity() {
		return model.getQuantity();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cart ID of this cart products list.
	 *
	 * @param cartId the cart ID of this cart products list
	 */
	@Override
	public void setCartId(long cartId) {
		model.setCartId(cartId);
	}

	/**
	 * Sets the primary key of this cart products list.
	 *
	 * @param primaryKey the primary key of this cart products list
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product ID of this cart products list.
	 *
	 * @param productId the product ID of this cart products list
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	/**
	 * Sets the quantity of this cart products list.
	 *
	 * @param quantity the quantity of this cart products list
	 */
	@Override
	public void setQuantity(int quantity) {
		model.setQuantity(quantity);
	}

	@Override
	protected CartProductsListWrapper wrap(CartProductsList cartProductsList) {
		return new CartProductsListWrapper(cartProductsList);
	}

}