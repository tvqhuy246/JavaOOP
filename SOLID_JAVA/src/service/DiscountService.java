package service;

import model.Order;

public interface DiscountService {
    double applyDiscount(Order order);
}
