package services;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private static final double SHIPPING_FEE = 30;

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("❌ Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        List<Shippable> shippables = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (product.isExpired()) {
                System.out.println("❌ Error: Product " + product.getName() + " is expired.");
                return;
            }

            if (!product.isAvailable(item.getQuantity())) {
                System.out.println("❌ Error: Not enough stock for " + product.getName());
                return;
            }

            subtotal += product.getPrice() * item.getQuantity();
            product.reduceQuantity(item.getQuantity());

            if (product instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippables.add((Shippable) product);
                }
            }
        }

        double shippingCost = shippables.isEmpty() ? 0 : SHIPPING_FEE;
        double total = subtotal + shippingCost;

        if (!customer.canPay(total)) {
            System.out.println("❌ Error: Insufficient balance.");
            return;
        }

        customer.pay(total);

        if (!shippables.isEmpty()) {
            ShippingService.ship(shippables);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + (item.getProduct().getPrice() * item.getQuantity()));
        }

        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingCost);
        System.out.println("Amount " + total);
        System.out.println("Remaining Balance: " + customer.getBalance());
    }
}
