package model;


public class Product {
    private String productName;
    private double unitValue;

    public Product(String productName, double unitValue) {
        this.productName = productName;
        this.unitValue = unitValue;
    }
    public String getProductName() {
        return productName;
    }

    public double getUnitValue() {
        return unitValue;
    }

}
