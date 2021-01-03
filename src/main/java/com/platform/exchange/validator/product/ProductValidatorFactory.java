package com.platform.exchange.validator.product;

import com.platform.exchange.model.product.ProductType;

public final class ProductValidatorFactory {

    public static ProductValidator getValidator(ProductType productType) {
        return switch (productType) {
            case REGULAR -> new ProductValidator();
            case AUTO -> new AutoValidator();
            case REAL_ESTATE -> new RealEstateValidator();
        };
    }
}
