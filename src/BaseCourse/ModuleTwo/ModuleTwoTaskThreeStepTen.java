package BaseCourse.ModuleTwo;

import java.util.Scanner;

public class ModuleTwoTaskThreeStepTen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        if (number < 0)  {
            System.out.println("ERROR");
            return;
        }
        else if (number > 10)  {
            System.out.println("ERROR");
            return;
        }
        for (int row = 1; row <= number; row++) { // идём по строкам
            for (int column = 1; column <= number; column++) {
                System.out.print(row * column);
                System.out.print("\t\t");
            }
            System.out.println();
        }
    }
}
