package com.liferay.tax;

import restbuilder.dto.v1_0.Product;

public interface TaxService {
    Product applyTaxInProduct(Product product);
}
