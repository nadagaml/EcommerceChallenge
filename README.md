# 🛍️ E-commerce System - Fawry Quantum Internship Challenge

### 👩‍💻 Developed by: Nada Gamal

This is a Java-based console application that simulates a simplified e-commerce system. It is implemented as part of the **Fawry Quantum Full Stack Development Internship Challenge**.

---

## ✅ Features

- Define products with `name`, `price`, and `quantity`
- Some products:
  - May **expire** (like Cheese, Biscuits)
  - May **require shipping** (like TV, Cheese)
- Shippable items provide their `weight`
- Customers can:
  - Add products to cart
  - Checkout with validation
- Checkout prints:
  - Subtotal
  - Shipping fees
  - Total paid
  - Remaining balance
  - Shipment details (names & total weight)
- Errors handled for:
  - Empty cart
  - Expired products
  - Insufficient quantity
  - Insufficient customer balance

---

## 🧾 Sample Output

** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
1x TV
Total package weight 11.5kg
** Checkout receipt **
2x Cheese 200.0
1x Biscuits 150.0
1x TV 0.0
1x Scratch Card 0.0
Subtotal 350.0
Shipping 30.0
Amount 380.0
Remaining Balance: 620.0


## 📦 Project Structure

src/
├── models/
│ ├── Product.java
│ ├── ExpirableProduct.java
│ ├── Shippable.java
│ ├── ShippableProduct.java
│ ├── ExpirableShippableProduct.java
│ ├── CartItem.java
│ ├── Cart.java
│ └── Customer.java
│
├── services/
│ ├── CheckoutService.java
│ └── ShippingService.java
│
└── Main.java

## ▶️ How to Run

1. Clone the repository or download ZIP
2. Open it using IntelliJ IDEA
3. Run the `Main.java` file

---

## ✅ Technologies Used

- Java 21
- IntelliJ IDEA
- Object-Oriented Programming (OOP)
