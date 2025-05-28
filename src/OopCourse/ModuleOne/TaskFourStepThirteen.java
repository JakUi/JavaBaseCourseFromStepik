package OopCourse.ModuleOne;

import java.util.Scanner;

public class TaskFourStepThirteen {
    public static void main(String[] args) {
//        Считать с консоли размер массива. Если введено отрицательное число, то напечатать ERROR и закончить программу.
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        if (size < 0) {
            System.out.println("ERROR");
            return;
        }
        int maxTotal = 0;
        PurchaseChanged[] gruppa = new PurchaseChanged[size]; // Создать массив покупок (типа Purchase) нужного размера.
        for (int i = 0; i < gruppa.length; i++) {
            String product = scan.next();
            int price = scan.nextInt();
            int quantity = scan.nextInt();
            gruppa[i] = new PurchaseChanged(product, price, quantity);
            if (gruppa[i].getCost() > maxTotal) {
                maxTotal = gruppa[i].getCost();
            }
        }
        for (int j = 0; j < gruppa.length; j++) {
            if (gruppa[j].getCost() == maxTotal) {
                System.out.println(gruppa[j].toString());
            }
        }
    }
}

class PurchaseChanged {
    private String product;
    private int quantity;
    private int price;

    public PurchaseChanged(String product, int price, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    public PurchaseChanged(String product, int price) {
        this.product = product;
        this.quantity = 0;
        this.price = price;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getCost() {
        int cost;
        cost = price * quantity;
        return cost;
    }
    @Override
    public String toString() {
        return product + ";" + price + ";" + quantity + ";" + getCost();
    }
}

class CommodityChanged {
    private String name;
    private int price;

    public CommodityChanged(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public CommodityChanged(String name) {
        this.name = name;
        this.price = 1;
    }
    @Override
    public String toString() {
        return name + ";" + price;
    }
}
