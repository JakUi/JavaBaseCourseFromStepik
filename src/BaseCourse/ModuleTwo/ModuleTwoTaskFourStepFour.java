package BaseCourse.ModuleTwo;

import java.util.Scanner;

public class ModuleTwoTaskFourStepFour {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int number_a = scan.nextInt();
            int number_b = scan.nextInt();
            int result = 0;
            if (number_a <0) {
                System.out.println("ERROR");
            }
            else if (number_b <0) {
                System.out.println("ERROR");
            }
            for (int i = number_a; i <= number_b; i++) {
                if (i == 2) {
                    System.out.print(i + " ");
                    continue;
                }
                for (int j = 2; j < i; j++) {
                    result = i % j;
                    if (result == 0) {
                        break;
                    }
                }
                if (result != 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
