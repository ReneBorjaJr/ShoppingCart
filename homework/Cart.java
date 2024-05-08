package homework;

import java.util.ArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();
    private final float TAX = 0.10f;
    private Special special;

    public Cart(ArrayList<Product> products) {
        this.products = products;
    }


    public int cartQty() {
        return products.size();
    }

    public double subtotal() {
        double subtotal = 0;
        for (Product product : products) {
            subtotal += product.getPrice() * product.getQty();
        }
        return subtotal;
    }

    public double totalAfterTax() {
        return subtotal() * (1 + TAX);
    }

    public void checkout(Special special) {
        double subtotal = subtotal();
        if (products.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            System.out.println("Items in cart:");
            int i = 1;
            for (Product product : products) {
                System.out.println(i + ". " + "name" + ": " + product.getName() + " ||" + " size" + ": " + product.getSize() + " ||" + " price" + ": " + product.getPrice() + " ||" + " qty" + ": " + product.getQty());
                i++;
            }
            int total = 0;
            for (Product product : products) {
                total += product.getQty();
            }
            System.out.println("Cart quantity: " + total);

            switch (special) {
                case MON:
                    System.out.println("Monday: 10% off");
                    System.out.printf("Subtotal: $%.2f\nTotal after tax: $%.2f\nTotal after discount: $%.2f\n", subtotal, totalAfterTax(), subtotal * 0.90);
                    break;
                case TUE:
                    System.out.println("Tuesday: 15% off");
                    System.out.printf("Subtotal: $%.2f\nTotal after tax: $%.2f\nTotal after discount: $%.2f\n", subtotal, totalAfterTax(), subtotal * 0.85);

                    break;
                case WED:
                    System.out.println("Wednesday: 20% off");
                    System.out.printf("Subtotal: $%.2f\nTotal after tax: $%.2f\nTotal after discount: $%.2f\n", subtotal, totalAfterTax(), subtotal * 0.80);

                    break;
                case THU:
                    System.out.println("Thursday: 25% off");
                    System.out.printf("Subtotal: $%.2f\nTotal after tax: $%.2f\nTotal after discount: $%.2f\n", subtotal, totalAfterTax(), subtotal * 0.75);
                    break;
                case FRI:
                    System.out.println("Friday: 30% off");
                    System.out.printf("Subtotal: $%.2f\nTotal after tax: $%.2f\nTotal after discount: $%.2f\n", subtotal, totalAfterTax(), subtotal * 0.70);
                    break;
                case SAT:
                    System.out.println("Saturday: 35% off");
                    System.out.printf("Subtotal: $%.2f\nTotal after tax: $%.2f\nTotal after discount: $%.2f\n", subtotal, totalAfterTax(), subtotal * 0.65);
                    break;
                case SUN:
                    System.out.println("Buy one get one free for fries on Sunday");
                    int friesCount = 0;
                    double totalCost = 0.0;
                    for (Product product : products) {
                        if (product instanceof Fries) {
                            friesCount += product.getQty();
                            int paidItems = (product.getQty() + 1) / 2;
                            totalCost += paidItems * product.getPrice();
                        }
                    }
                    double tax = totalCost * TAX;
                    double priceAfterTax = totalCost + tax;
                    System.out.printf("Subtotal: $%.2f\nTotal after discount: $%.2f\nTotal after tax: $%.2f\n", subtotal, totalCost, priceAfterTax);
                    break;
                default:
                    break;
            }
            System.out.println("Thank you for shopping with us!");
        }
    }

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }

    public float getTAX() {
        return TAX;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }
    }
}

