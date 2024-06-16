package ModuleTwo;

import java.util.Scanner;

public class ModuleTwoTaskFourStepSix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int sum = 0, quotient;
        if (number < 0) {
            System.out.println("ERROR");
        }
        for (int i = 2; i < number; i+=2) {
            quotient = number % i;
            if (quotient == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
        scan.close();
    }
}
