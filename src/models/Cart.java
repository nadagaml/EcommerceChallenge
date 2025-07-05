package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        if (product.isExpired()) {
            System.out.println("❌ Cannot add " + product.getName() + ": expired.");
            return;
        }

        if (!product.isAvailable(quantity)) {
            System.out.println("❌ Cannot add " + product.getName() + ": not enough in stock.");
            return;
        }

        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getItems() {
        return items;
    }
}
