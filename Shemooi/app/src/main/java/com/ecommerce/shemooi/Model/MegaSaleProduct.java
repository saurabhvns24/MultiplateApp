package com.ecommerce.shemooi.Model;

public class MegaSaleProduct {
    private String productImage;
    private String productName;
    private String productPrize;
    private String productDiscount;

    public MegaSaleProduct(String productImage, String productName, String productPrize, String productDiscount) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrize = productPrize;
        this.productDiscount = productDiscount;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
