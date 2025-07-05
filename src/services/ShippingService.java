package services;

import models.Shippable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {

    public static void ship(List<Shippable> shippables) {
        System.out.println("** Shipment notice **");

        double totalWeight = 0;
        Map<String, Integer> counts = new HashMap<>();

        for (Shippable s : shippables) {
            counts.put(s.getName(), counts.getOrDefault(s.getName(), 0) + 1);
            totalWeight += s.getWeight();
        }

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey());
        }

        System.out.println("Total package weight " + totalWeight + "kg");
    }
}
