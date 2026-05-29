package service.impl;

import model.Order;
import service.PaymentService;

public class CashPaymentService implements PaymentService {
    @Override
    public String processPayment(Order order, double amount) {
        System.out.println("Thuc hien thanh toan" + amount + " thu tu " + order.getOrderId());
        return "thanh cong";
    }
}
