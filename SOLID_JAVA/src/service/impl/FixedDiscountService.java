package service.impl;

import model.Order;
import service.DiscountService;

public class FixedDiscountService implements DiscountService {
    private double fixperce;
    public FixedDiscountService(double fixpercte){
        this.fixperce = fixperce;
    }

    @Override
    public double applyDiscount(Order order) {
        return 0;
    }
}
