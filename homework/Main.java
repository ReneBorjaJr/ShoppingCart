package homework;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Cart cart = new Cart(products);
        User user = new User(cart);

        user.addToCart(new Fries("Fries", Size.L, 4.99, 5));
        user.addToCart(new Shirt("Shirt", Size.XL, 1.99, 2));
        user.addToCart(new Hat("Hat", Size.S, 2.99, 3));
        user.addToCart(new Sweater("Sweater", Size.M, 2.99, 10));
        user.addToCart(new Soda("Soda", Size.L, 12.99, 15));

        cart.checkout(Special.MON);

        // print the quantity of each product in the cart


//        System.out.println(products.get(0).getID());
//        System.out.println(products.get(1).getID());
//        System.out.println(products.get(0).getID());
//
//        System.out.println(products.get(0).getInventory());
//
//        user.addToCart(new Fries("Fries", Size.S, 1.99, 5));
//        System.out.println(products.get(3).getInventory());



        }
    }
