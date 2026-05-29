package service;

import model.Order;

public interface PaymentService {
     public String processPayment(Order order, double amount);
}
