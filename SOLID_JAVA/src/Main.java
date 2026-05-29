import model.Order;
import model.OrderItem;
import model.Product;
import service.DiscountService;
import service.InvoicePrinter;
import service.PaymentService;
import service.ShippingService;
import service.impl.BankTransferPaymentService;
import service.impl.ConsoleInvoicePrinter;
import service.impl.ExpressShippingService;
import service.impl.PercentageDiscountService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product("P01", "Laptop Dell", 1500.0, "MSI", 10);
        Product mouse = new Product("P02", "chuot Logitech", 50.0, "Chuot khong dây", 50);

        Order order = new Order("ORD-1001", "cus123", new Date(), "CREATED");

        order.addItems(new OrderItem(laptop, 1, 0.0));

        order.addItems(new OrderItem(mouse, 2, 5.0));
        System.out.println("Tổng tiền gốc của đơn hàng: " + order.calculateTotal());

        DiscountService discountService = new PercentageDiscountService(10);
        double finalTotal = discountService.applyDiscount(order);
        System.out.println("Tổng tiền sau khi giảm giá 10%: " + finalTotal);

        PaymentService paymentService = new BankTransferPaymentService();
        paymentService.processPayment(order, finalTotal);

        ShippingService shippingService = new ExpressShippingService();
        System.out.println("Phi van chuyen" + shippingService.calculateShippingCost(order));
        shippingService.shipOrder(order);

        System.out.println();
        InvoicePrinter printer = new ConsoleInvoicePrinter();
        printer.InvoicePrint(order);
    }
}