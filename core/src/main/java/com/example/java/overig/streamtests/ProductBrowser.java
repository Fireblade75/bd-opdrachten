package com.example.java.overig.streamtests;

import java.math.BigDecimal;
import java.util.List;

public class ProductBrowser {

   private final List<Product> products;

    public ProductBrowser(List<Product> products) {
        this.products = products;
    }

    public static enum ProductType {
        FOOD,
        ELECTRONICS,
        CLOTHES,
        MEDIA
    }

    public double getAverageFoodPrice() {
        return products.stream()
                .filter(p -> p.productType.equals(ProductType.FOOD))
                .mapToDouble(p -> p.price.doubleValue())
                .average()
                .orElse(0);
    }

    public static class Product {
        public final ProductType productType;
        public final String productName;
        public final BigDecimal price;

        public Product(ProductType productType, String productName, BigDecimal price) {
            this.productType = productType;
            this.productName = productName;
            this.price = price;
        }
    }
}
