package com.ecommerce.shemooi.Model;

public class FeatureBrandProduct {
    private String productImage;
    private String productPrize;
    private String productDiscount;

    public FeatureBrandProduct(String productImage, String productPrize, String productDiscount) {
        this.productImage = productImage;
        this.productPrize = productPrize;
        this.productDiscount = productDiscount;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductPrize() {
        return productPrize;
    }

    public void setProductPrize(String productPrize) {
        this.productPrize = productPrize;
    }

    public String getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(String productDiscount) {
        this.productDiscount = productDiscount;
    }
}
