package service.impl;

import model.Order;
import service.ShippingService;

public class ExpressShippingService implements ShippingService {
    @Override
    public double calculateShippingCost(Order order) {
        return 15.0; // Fixed express shipping cost
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Van chuyen theo thu tu " + order.getOrderId() + " Dang van chuyen");
        order.setStatus("dang shipped");
    }
}
