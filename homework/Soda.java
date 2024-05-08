package homework;

public class Soda extends Food {

    private int inventory;

    public Soda(String name, Size size, double price, int qty) {
        super(name, size, price, qty);
        if (size == Size.S) {
            inventory = 20;
            int inStock = inventory - qty;
        } else if (size == Size.M) {
        inventory = 20;
        int inStock = inventory - qty;
        } else if (size == Size.L) {
        inventory = 20;
        int inStock = inventory - qty;
        } else if (size == Size.XL) {
        inventory = 20;
        int inStock = inventory - qty;
        }
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
