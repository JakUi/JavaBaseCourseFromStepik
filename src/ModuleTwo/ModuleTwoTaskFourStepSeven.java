package ModuleTwo;

import java.util.Scanner;

public class ModuleTwoTaskFourStepSeven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number_a = scan.nextInt();
        int number_b = scan.nextInt();
        int sum = 0;
        for (int i = number_a; i <= number_b; i++) {
            for (int j = 2; j <= i; j++) {
                if ( i % j == 0) {
                    sum+=j;
                    break;
                }
                else continue;
            }
        }
        System.out.println(sum);
        scan.close();
    }
}
