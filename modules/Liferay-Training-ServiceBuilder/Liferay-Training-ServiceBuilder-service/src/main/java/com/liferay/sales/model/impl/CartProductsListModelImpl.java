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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.sales.model.CartProductsList;
import com.liferay.sales.model.CartProductsListModel;
import com.liferay.sales.model.CartProductsListSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CartProductsList service. Represents a row in the &quot;SalesTaxe_CartProductsList&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CartProductsListModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CartProductsListImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CartProductsListImpl
 * @generated
 */
@JSON(strict = true)
public class CartProductsListModelImpl
	extends BaseModelImpl<CartProductsList> implements CartProductsListModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cart products list model instance should use the <code>CartProductsList</code> interface instead.
	 */
	public static final String TABLE_NAME = "SalesTaxe_CartProductsList";

	public static final Object[][] TABLE_COLUMNS = {
		{"productId", Types.BIGINT}, {"cartId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("productId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cartId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SalesTaxe_CartProductsList (productId LONG not null primary key,cartId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table SalesTaxe_CartProductsList";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cartProductsList.productId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SalesTaxe_CartProductsList.productId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PRODUCTID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CartProductsList toModel(CartProductsListSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CartProductsList model = new CartProductsListImpl();

		model.setProductId(soapModel.getProductId());
		model.setCartId(soapModel.getCartId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<CartProductsList> toModels(
		CartProductsListSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CartProductsList> models = new ArrayList<CartProductsList>(
			soapModels.length);

		for (CartProductsListSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CartProductsListModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _productId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProductId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _productId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CartProductsList.class;
	}

	@Override
	public String getModelClassName() {
		return CartProductsList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CartProductsList, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CartProductsList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CartProductsList, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CartProductsList)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CartProductsList, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CartProductsList, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CartProductsList)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CartProductsList, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CartProductsList, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CartProductsList>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CartProductsList.class.getClassLoader(), CartProductsList.class,
			ModelWrapper.class);

		try {
			Constructor<CartProductsList> constructor =
				(Constructor<CartProductsList>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CartProductsList, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CartProductsList, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CartProductsList, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CartProductsList, Object>>();
		Map<String, BiConsumer<CartProductsList, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CartProductsList, ?>>();

		attributeGetterFunctions.put(
			"productId", CartProductsList::getProductId);
		attributeSetterBiConsumers.put(
			"productId",
			(BiConsumer<CartProductsList, Long>)CartProductsList::setProductId);
		attributeGetterFunctions.put("cartId", CartProductsList::getCartId);
		attributeSetterBiConsumers.put(
			"cartId",
			(BiConsumer<CartProductsList, Long>)CartProductsList::setCartId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getProductId() {
		return _productId;
	}

	@Override
	public void setProductId(long productId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_productId = productId;
	}

	@JSON
	@Override
	public long getCartId() {
		return _cartId;
	}

	@Override
	public void setCartId(long cartId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cartId = cartId;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CartProductsList.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CartProductsList toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CartProductsList>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CartProductsListImpl cartProductsListImpl = new CartProductsListImpl();

		cartProductsListImpl.setProductId(getProductId());
		cartProductsListImpl.setCartId(getCartId());

		cartProductsListImpl.resetOriginalValues();

		return cartProductsListImpl;
	}

	@Override
	public int compareTo(CartProductsList cartProductsList) {
		long primaryKey = cartProductsList.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CartProductsList)) {
			return false;
		}

		CartProductsList cartProductsList = (CartProductsList)object;

		long primaryKey = cartProductsList.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CartProductsList> toCacheModel() {
		CartProductsListCacheModel cartProductsListCacheModel =
			new CartProductsListCacheModel();

		cartProductsListCacheModel.productId = getProductId();

		cartProductsListCacheModel.cartId = getCartId();

		return cartProductsListCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CartProductsList, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CartProductsList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CartProductsList, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CartProductsList)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CartProductsList, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CartProductsList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CartProductsList, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CartProductsList)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CartProductsList>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _productId;
	private long _cartId;

	public <T> T getColumnValue(String columnName) {
		Function<CartProductsList, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CartProductsList)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("productId", _productId);
		_columnOriginalValues.put("cartId", _cartId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("productId", 1L);

		columnBitmasks.put("cartId", 2L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CartProductsList _escapedModel;

}