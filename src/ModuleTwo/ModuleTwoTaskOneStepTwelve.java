package ModuleTwo;//Грузовой самолет должен пролететь с грузом из пункта А в пункт С через пункт В. Емкость бака для топлива у самолета – 300 литров.
// Потребление топлива на 1 км в зависимости от веса груза у самолета следующее:
//
//        - до 500 кг  (включительно) :    1 литров / км
//
//        - до 1000 кг (включительно):   4 литров / км
//
//        - до 1500 кг (включительно):   7 литров / км
//
//        - до 2000 кг (включительно):   9 литров / км.
//
//        - более 2000 кг – самолет не поднимает.

import java.util.Scanner;


class ModuleTwoTaskOneStepTwelve {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int distance_ab = scan.nextInt();
        int distance_bc = scan.nextInt();
        int weight = scan.nextInt();
        int fuel_consumption;
        double refueling = 0;
        double fuel_after_ab = 0;
        double need_fuel_bc;
        boolean can_float;
        if (weight <= 500) {
            fuel_consumption = 1;
        } else if (weight <= 1000) {
            fuel_consumption = 4;
        } else if (weight <= 1500) {
            fuel_consumption = 7;
        } else if (weight <= 2000) {
            fuel_consumption = 9;
        } else {
            System.out.println("ERROR");
            return;
        }
        if ((300 - distance_ab * fuel_consumption) >= 0) {
            fuel_after_ab = 300 - distance_ab * fuel_consumption; // осталось топлива полсле ab
        }
        else {
            System.out.println("ERROR");
            return;
        } // верно
        need_fuel_bc = distance_bc * fuel_consumption; // верно нужно топлива до точки c
        if (need_fuel_bc > 300) {
            System.out.println("ERROR");
            return;
        } else {
            refueling = need_fuel_bc - fuel_after_ab;
        }
        if (refueling < 0) refueling = 0;
        System.out.printf("%.2f \n", refueling);
        scan.close();
    }
}
