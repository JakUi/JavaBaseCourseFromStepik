package ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskTwoStepSeven {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int quantity, min, digit;
        int counter = 1;
        quantity = scan.nextInt();
        if (quantity <= 0) {
            System.out.println("ERROR");
            return;
        }
        digit = scan.nextInt();
        min = digit;
        for(; counter < quantity; counter++) {
            digit = scan.nextInt();
            if (min > digit) {
                min = digit;
            }
        }
        System.out.println(min);
        scan.close();
    }
}
