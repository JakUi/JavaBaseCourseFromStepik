package OopCourse.ModuleFour;


import java.util.ArrayList;
import java.util.Scanner;


public class TaskThreeStepFifteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<PurchaseThreeFifteen> list = new ArrayList<>();
        String buffer = "";
        buffer = scan.nextLine();
        while (!"end".equals(buffer)) {
            String[] data = buffer.split(" ");
            int type = Integer.parseInt(data[0]);
            if (type == 1) {
                list.add(new PurchaseThreeFifteen(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            }
            else {
                list.add(new DiscountPurchaseThreeFifteen(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])));
            }
            buffer = scan.nextLine();
        }
        System.out.println("Total sum = " + getTotalSum(list));
    }

    public static int getTotalSum(ArrayList<? extends PurchaseThreeFifteen> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getCost();
        }
        return sum;
    }
}

class PurchaseThreeFifteen {
    private String name;
    private int price;
    private int number;

    public PurchaseThreeFifteen(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public PurchaseThreeFifteen() {
    }

    int getCost() {
        return price * number;
    }
}

class DiscountPurchaseThreeFifteen extends PurchaseThreeFifteen {
    private int discount;

    public DiscountPurchaseThreeFifteen(String name, int price, int number, int discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public DiscountPurchaseThreeFifteen() {
        this.discount = 0;
    }

    @Override
    int getCost() {
        return super.getCost() - super.getCost() * discount / 100;
    }
}
