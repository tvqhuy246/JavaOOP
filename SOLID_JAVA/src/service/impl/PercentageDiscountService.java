package service.impl;

import model.Order;
import service.DiscountService;

public class PercentageDiscountService implements DiscountService {
    private double percentage;

    public PercentageDiscountService(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(Order order) {
        double total = order.calculateTotal();
        return total * (100 - (percentage))/100;
    }
}
