package OopCourse.ModuleOne;

import java.util.Scanner;

public class TaskTwoStepSixteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Commodity position = new Commodity();
        position.name = scan.nextLine();
        position.price = scan.nextInt();
        Purchase deal = new Purchase();
        deal.product = position.name;
        deal.quantity = scan.nextInt();
        deal.price = position.price;
        deal.show();
        position.price = scan.nextInt();
        System.out.println();
        deal.price = position.price;
        deal.show();
    }
}

class Commodity {

    String name;
    int price;

    void show() {
        System.out.println("Наименование товара: " + name);
        System.out.println("Цена товара: " + price);
    }
}

class Purchase {
    String product;
    int quantity;
    int price;
    private int getCost() {
        int cost;
        cost = price * quantity;
        return cost;
    }

    void show() {
        System.out.println("Наименование товара: " + product);
        System.out.println("Цена товара: " + price);
        System.out.println("Количество: " + quantity);
        System.out.println("Стоимость покупки: " + getCost());
    }
}
