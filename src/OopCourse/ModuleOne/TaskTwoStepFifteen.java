package OopCourse.ModuleOne;

import java.util.Scanner;

public class TaskTwoStepFifteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BusinessTrip trip = new BusinessTrip();
        trip.surname = scan.next();
        trip.name = scan.next();
        trip.days = scan.nextInt();
        trip.transportsSpents = scan.nextInt();
        trip.show();
    }
}

class BusinessTrip {
    final static int DAILY = 25;
    String surname;
    String name;
    int transportsSpents;
    int days;

    int getTotal(int transportsSpents, int days) {
        int totalSpents;
        totalSpents = transportsSpents + days * DAILY;
        return totalSpents;
    }
    void show() {
        System.out.println("Суточные = " + DAILY);
        System.out.println("Фамилия Имя = " + surname + " " + name);
        System.out.println("Транспортные расходы = " + transportsSpents);
        System.out.println("Количество дней = " + days);
        System.out.println("Итого расходы = " + getTotal(transportsSpents, days));
    }
}
