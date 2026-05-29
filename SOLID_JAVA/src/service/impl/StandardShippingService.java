package service.impl;

import model.Order;
import service.ShippingService;

public class StandardShippingService implements ShippingService {
    @Override
    public double calculateShippingCost(Order order) {
        return 5.0; // Fixed standard shipping cost
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Van chuyen theo thu tu" + order.getOrderId() + " dang van chuyen");
        order.setStatus("Chat luong van chuyen");
    }
}
