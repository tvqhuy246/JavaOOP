package model;

public class OrderItem {
    private Product product;
    private int quantity;
    private double discount;

    public OrderItem(Product product, int quantity, double discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }

    public double getSubTotal() {
        return (product.getPrice() * quantity) - discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
