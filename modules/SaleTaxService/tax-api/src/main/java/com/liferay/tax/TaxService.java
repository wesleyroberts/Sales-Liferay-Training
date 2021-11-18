package com.liferay.tax;

import com.liferay.sales.model.SaleProduct;

public interface TaxService {
    SaleProduct applyTaxInProduct(SaleProduct product);
}
