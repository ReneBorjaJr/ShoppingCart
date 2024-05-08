package homework;

import java.util.ArrayList;
import java.util.Iterator;

public class User {
    private final int id;
    private static int sharedId = 1;
    private Cart cart;

    public User(Cart cart) {
        this.cart = cart;
        this.id = sharedId++;
    }

    public int getId() {
        return id;
    }

    public static int getSharedId() {
        return sharedId;
    }

    public static void setSharedId(int sharedId) {
        User.sharedId = sharedId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void addToCart(Product product) {
        if (product == null || product.getQty() <= 0) {
            System.out.println("Cannot add a null product or a non-positive quantity to the cart.");
            return;
        } else if (product.getInventory() == 0) {
            System.out.println("The product is out of stock.");
            return;
        } else if (product.getInventory() < product.getQty()) {
            System.out.println("Insufficient inventory. We only have " + product.getInventory() + " in stock.");
            return;
        }
        // Get the products in the cart
        ArrayList<Product> productsInCart = cart.getProducts();
        // Check if the product is already in the cart
        boolean productFound = false;
        for (Product p : productsInCart) {
            if (p.getID() == product.getID() && p.getSize().equals(product.getSize())) {
                p.setQty(p.getQty() + product.getQty());
                p.setInventory(p.getInventory() - product.getQty());
                productFound = true;
                break;
            }
        }
        // If the product is not in the cart, add it
        if (!productFound) {
            productsInCart.add(product);
            product.setInventory(product.getInventory() - product.getQty());
        }

    }


    public void removeFromCart(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            System.out.println("Cannot remove a null product or a non-positive quantity from the cart.");
            return;
        }
        // Get the products in the cart
        ArrayList<Product> productsInCart = cart.getProducts();
        // Check if the product is already in the cart
        for (Iterator<Product> iterator = productsInCart.iterator(); iterator.hasNext(); ) {
            Product p = iterator.next();
            if (p.getID() == product.getID() && p.getSize().equals(product.getSize())) {
                if (p.getQty() > quantity) {
                    // Reduce the quantity of the product in the cart
                    p.setQty(p.getQty() - quantity);
                    p.setInventory(p.getInventory() + quantity);
                } else {
                    // Remove the product from the cart if quantity to remove is equal or more than in the cart
                    iterator.remove();
                    p.setInventory(p.getInventory() + p.getQty());
                }
                return; // Exit after updating the cart
            }
        }
        System.out.println("Product not found in the cart.");
    }
}
