import models.*;
import services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // إنشاء المنتجات
        Product cheese = new ExpirableShippableProduct("Cheese", 100, 2, LocalDate.of(2025, 8, 1), 0.4);
        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 1, LocalDate.of(2025, 9, 1), 0.7);
        Product tv = new ShippableProduct("TV", 300, 3, 10.0);
        Product scratchCard = new Product("Scratch Card", 50, 10);

        // إنشاء عميل
        Customer customer = new Customer("Nada", 1000);

        // إنشاء السلة وإضافة المنتجات
        Cart cart = new Cart();
        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(tv, 1);
        cart.addProduct(scratchCard, 1);

        // تنفيذ عملية الشراء
        CheckoutService.checkout(customer, cart);
    }
}
