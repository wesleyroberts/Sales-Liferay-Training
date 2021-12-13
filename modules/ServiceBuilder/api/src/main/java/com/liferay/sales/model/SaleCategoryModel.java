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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the SaleCategory service. Represents a row in the &quot;SalesTaxe_SaleCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.sales.model.impl.SaleCategoryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.sales.model.impl.SaleCategoryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SaleCategory
 * @generated
 */
@ProviderType
public interface SaleCategoryModel extends BaseModel<SaleCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a sale category model instance should use the {@link SaleCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this sale category.
	 *
	 * @return the primary key of this sale category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this sale category.
	 *
	 * @param primaryKey the primary key of this sale category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the category ID of this sale category.
	 *
	 * @return the category ID of this sale category
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this sale category.
	 *
	 * @param categoryId the category ID of this sale category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the name of this sale category.
	 *
	 * @return the name of this sale category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this sale category.
	 *
	 * @param name the name of this sale category
	 */
	public void setName(String name);

	/**
	 * Returns the tax of this sale category.
	 *
	 * @return the tax of this sale category
	 */
	public double getTax();

	/**
	 * Sets the tax of this sale category.
	 *
	 * @param tax the tax of this sale category
	 */
	public void setTax(double tax);

}