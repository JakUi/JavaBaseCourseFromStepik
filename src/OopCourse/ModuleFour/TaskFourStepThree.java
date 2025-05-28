package OopCourse.ModuleFour;

import java.util.Scanner;
import static java.util.Arrays.sort;
import java.util.Comparator;


public class TaskFourStepThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arraySize = scan.nextInt();
        PurchaseWithSort[] gruppa = new PurchaseWithSort[arraySize];
        for(int i = 0; i < arraySize; i++){
            gruppa[i] = new PurchaseWithSort(scan.next(), scan.nextInt(), scan.nextInt());
        }
        PurchaseComparator comp = new PurchaseComparator();
        sort(gruppa, comp);
        for (PurchaseWithSort product : gruppa) {
            System.out.println(product);
        }
        System.out.println();
        sort(gruppa);
        for (PurchaseWithSort product : gruppa) {
            System.out.println(product);
        }
    }
}

class PurchaseWithSort implements Comparable<PurchaseWithSort> {
    private String name;
    private int price;
    private int number;

    public PurchaseWithSort(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public PurchaseWithSort() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    int getCost() {
        return price * number;
    }

    @Override
    public String toString() {
        return name + " " + price + " " + number + " " + getCost();
    }

    @Override
    public int compareTo(PurchaseWithSort o) {
        if(getCost() - o.getCost() > 0) return 1;
        if(getCost() - o.getCost() < 0) return -1;
        return 0;
    }
}

class PurchaseComparator implements Comparator<PurchaseWithSort> {
    @Override
    public int compare(PurchaseWithSort o1, PurchaseWithSort o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
