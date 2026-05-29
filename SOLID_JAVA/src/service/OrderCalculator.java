package service;

import model.Order;

public interface OrderCalculator {
    double calculateTotal(Order order);
}
