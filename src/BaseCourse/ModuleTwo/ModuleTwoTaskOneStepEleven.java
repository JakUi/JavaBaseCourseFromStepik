package BaseCourse.ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskOneStepEleven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = scan.nextInt();
        double tariff = scan.nextDouble();
        double salary;
        if (hours < 0||tariff < 0){
            System.out.println("ERROR");
            return;
        }
        if (hours <= 20) {
            salary = hours * tariff;
            System.out.printf("%.2f",salary);
        }
        else if ((hours > 20) & (hours <= 40)) {
            salary = 20 * tariff + ((hours - 20) * tariff * 1.5);
            System.out.printf("%.2f",salary);
        }
        else if (hours > 40) {
            salary = 20 * tariff + (20 * tariff * 1.5) + ((hours - 40) * tariff * 2.0);
            System.out.printf("%.2f",salary);
        }
        scan.close();
    }
}
