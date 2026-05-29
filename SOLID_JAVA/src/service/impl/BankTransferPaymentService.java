package service.impl;

import model.Order;
import service.PaymentService;

public class BankTransferPaymentService implements PaymentService {
    @Override
    public String processPayment(Order order, double payment) {
        System.out.println(" Thanh doi phuong thuc thanh toan" +payment+ " so du: " + order.getOrderId());
        return "thay doi thanh cong";
    }
}
