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
import com.liferay.sales.model.SaleCart;
import com.liferay.sales.model.SaleCartModel;
import com.liferay.sales.model.SaleCartSoap;

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
 * The base model implementation for the SaleCart service. Represents a row in the &quot;SalesTaxe_SaleCart&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SaleCartModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SaleCartImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCartImpl
 * @generated
 */
@JSON(strict = true)
public class SaleCartModelImpl
	extends BaseModelImpl<SaleCart> implements SaleCartModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sale cart model instance should use the <code>SaleCart</code> interface instead.
	 */
	public static final String TABLE_NAME = "SalesTaxe_SaleCart";

	public static final Object[][] TABLE_COLUMNS = {
		{"cartId", Types.BIGINT}, {"totalPrice", Types.DOUBLE},
		{"able", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("cartId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalPrice", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("able", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SalesTaxe_SaleCart (cartId LONG not null primary key,totalPrice DOUBLE,able BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table SalesTaxe_SaleCart";

	public static final String ORDER_BY_JPQL = " ORDER BY saleCart.cartId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SalesTaxe_SaleCart.cartId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CARTID_COLUMN_BITMASK = 1L;

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
	public static SaleCart toModel(SaleCartSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SaleCart model = new SaleCartImpl();

		model.setCartId(soapModel.getCartId());
		model.setTotalPrice(soapModel.getTotalPrice());
		model.setAble(soapModel.isAble());

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
	public static List<SaleCart> toModels(SaleCartSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SaleCart> models = new ArrayList<SaleCart>(soapModels.length);

		for (SaleCartSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public SaleCartModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cartId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCartId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cartId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SaleCart.class;
	}

	@Override
	public String getModelClassName() {
		return SaleCart.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SaleCart, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SaleCart, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SaleCart, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((SaleCart)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SaleCart, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SaleCart, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SaleCart)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SaleCart, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SaleCart, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SaleCart>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SaleCart.class.getClassLoader(), SaleCart.class,
			ModelWrapper.class);

		try {
			Constructor<SaleCart> constructor =
				(Constructor<SaleCart>)proxyClass.getConstructor(
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

	private static final Map<String, Function<SaleCart, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SaleCart, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SaleCart, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<SaleCart, Object>>();
		Map<String, BiConsumer<SaleCart, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SaleCart, ?>>();

		attributeGetterFunctions.put("cartId", SaleCart::getCartId);
		attributeSetterBiConsumers.put(
			"cartId", (BiConsumer<SaleCart, Long>)SaleCart::setCartId);
		attributeGetterFunctions.put("totalPrice", SaleCart::getTotalPrice);
		attributeSetterBiConsumers.put(
			"totalPrice",
			(BiConsumer<SaleCart, Double>)SaleCart::setTotalPrice);
		attributeGetterFunctions.put("able", SaleCart::getAble);
		attributeSetterBiConsumers.put(
			"able", (BiConsumer<SaleCart, Boolean>)SaleCart::setAble);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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

	@JSON
	@Override
	public double getTotalPrice() {
		return _totalPrice;
	}

	@Override
	public void setTotalPrice(double totalPrice) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_totalPrice = totalPrice;
	}

	@JSON
	@Override
	public boolean getAble() {
		return _able;
	}

	@JSON
	@Override
	public boolean isAble() {
		return _able;
	}

	@Override
	public void setAble(boolean able) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_able = able;
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
			0, SaleCart.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SaleCart toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SaleCart>
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
		SaleCartImpl saleCartImpl = new SaleCartImpl();

		saleCartImpl.setCartId(getCartId());
		saleCartImpl.setTotalPrice(getTotalPrice());
		saleCartImpl.setAble(isAble());

		saleCartImpl.resetOriginalValues();

		return saleCartImpl;
	}

	@Override
	public int compareTo(SaleCart saleCart) {
		long primaryKey = saleCart.getPrimaryKey();

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

		if (!(object instanceof SaleCart)) {
			return false;
		}

		SaleCart saleCart = (SaleCart)object;

		long primaryKey = saleCart.getPrimaryKey();

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
	public CacheModel<SaleCart> toCacheModel() {
		SaleCartCacheModel saleCartCacheModel = new SaleCartCacheModel();

		saleCartCacheModel.cartId = getCartId();

		saleCartCacheModel.totalPrice = getTotalPrice();

		saleCartCacheModel.able = isAble();

		return saleCartCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SaleCart, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SaleCart, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SaleCart, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((SaleCart)this));
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
		Map<String, Function<SaleCart, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SaleCart, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SaleCart, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SaleCart)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SaleCart>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _cartId;
	private double _totalPrice;
	private boolean _able;

	public <T> T getColumnValue(String columnName) {
		Function<SaleCart, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((SaleCart)this);
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

		_columnOriginalValues.put("cartId", _cartId);
		_columnOriginalValues.put("totalPrice", _totalPrice);
		_columnOriginalValues.put("able", _able);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("cartId", 1L);

		columnBitmasks.put("totalPrice", 2L);

		columnBitmasks.put("able", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private SaleCart _escapedModel;

}