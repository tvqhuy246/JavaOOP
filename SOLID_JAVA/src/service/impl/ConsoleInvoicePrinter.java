package service.impl;

import model.Order;
import service.InvoicePrinter;

public class ConsoleInvoicePrinter implements InvoicePrinter {
    @Override
    public void InvoicePrint(Order order) {
        System.out.println("Hoa don dien tu");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println(" ID khach: " + order.getCustomerId());
        System.out.println("Tong gia tien" + order.calculateTotal());
        System.out.println("Trang thai: " + order.getStatus());
    }
}
