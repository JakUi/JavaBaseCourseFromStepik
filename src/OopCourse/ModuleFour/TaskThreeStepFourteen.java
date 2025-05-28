package OopCourse.ModuleFour;


import java.util.ArrayList;
import java.util.Scanner;


public class TaskThreeStepFourteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<PurchaseThreeFourteen> list = new ArrayList<>();
        ArrayList<DiscountPurchase> list2 = new ArrayList<>();
        int type = scan.nextInt();  //читаем тип покупок, которые далее будут в списке
        scan.nextLine(); //очищаем буфер

        String buffer = scan.nextLine();
        while (!"end".equals(buffer)) {
            String[] data = buffer.split(" ");
            if (type == 1) {
                list.add(new PurchaseThreeFourteen(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
            } else {
                list2.add(new DiscountPurchase(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            }
            buffer = scan.nextLine();
        }

        if (type == 1) {
            System.out.println("Total sum = " + getTotalSum(list));
        } else {
            System.out.println("Total sum = " + getTotalSum(list2));
        }
    }

    public static int getTotalSum(ArrayList<? extends PurchaseThreeFourteen> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getCost();
        }
        return sum;
    }
}

class PurchaseThreeFourteen {
    private String name;
    private int price;
    private int number;

    public PurchaseThreeFourteen(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public PurchaseThreeFourteen() {
    }

    int getCost() {
        return price * number;
    }
}

class DiscountPurchase extends PurchaseThreeFourteen {
    private int discount;

    public DiscountPurchase(String name, int price, int number, int discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public DiscountPurchase(String name, int price, int number) {
        super(name, price, number);
        this.discount = 0;
    }

    @Override
    int getCost() {
        return super.getCost() - super.getCost() * discount / 100;
    }

}
