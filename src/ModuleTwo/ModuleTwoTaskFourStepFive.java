package ModuleTwo;

import java.util.Scanner;

public class ModuleTwoTaskFourStepFive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number_a = scan.nextInt();
        int number_b = scan.nextInt();
        int number_a1 = number_a, number_b1 = number_b;
        int result = 0;
        if (number_a > number_b) {
            number_a1 = number_b;
            number_b1 = number_a;
        }
        BLOCK: for (int i = number_a1; i <= number_b1; i++) {
            for (int j = 2; j < i; j++) {
                result = i % j;
                if (result == 0) {
                    System.out.println(i);
                    break BLOCK;
                }
            }
        }
        if (result > 0) {
            System.out.println("NO");
        }
        scan.close();
    }
}
