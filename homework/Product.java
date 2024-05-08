package homework;

public abstract class Product {
    private final int ID;
    private static int sharedId = 1;
    private String name;
    private Size size;
    private double price;
    private int qty;
    private int inventory;

    public Product(String name, Size size, double price, int qty) {
        ID = sharedId++;
        this.name = name;
        this.size = size;
        this.price = price;
        this.qty = qty;
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

    public int getID() {
        return ID;
    }

    public static int getSharedId() {
        return sharedId;
    }

    public static void setSharedId(int sharedId) {
        Product.sharedId = sharedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
