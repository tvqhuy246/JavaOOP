package service;

import model.Order;

public interface ShippingService {
    double calculateShippingCost(Order order);
    void shipOrder(Order order);
}
