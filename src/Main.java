import models.*;
import services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // المنتجات المطلوبة بنفس الوزن والسعر
        Product cheese = new ExpirableShippableProduct("Cheese 400g", 100, 10, LocalDate.of(2025, 8, 1), 0.2);
        Product biscuits = new ExpirableShippableProduct("Biscuits 700g", 150, 10, LocalDate.of(2025, 9, 1), 0.7);

        // منتجات إضافية بسعر 0 عشان مش تدخل في الفاتورة
        Product tv = new ShippableProduct("TV", 0, 3, 10.0);
        Product scratchCard = new Product("Scratch Card", 0, 10);

        // العميل
        Customer customer = new Customer("Nada", 1000);

        // السلة
        Cart cart = new Cart();
        cart.addProduct(cheese, 2);         // = 200
        cart.addProduct(biscuits, 1);       // = 150
        cart.addProduct(tv, 1);             // = 0
        cart.addProduct(scratchCard, 1);    // = 0

        // تنفيذ الشراء
        CheckoutService.checkout(customer, cart);
    }
}
