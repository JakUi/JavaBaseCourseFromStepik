package ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskTwoStepTwelve {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int digit = Math.abs(scan.nextInt());
        System.out.println(digit);
        int quantity = 0;
        int sum = 0;
        do {
            sum += digit % 10;
            quantity++;
            digit = digit/10;
        } while (digit > 0);
        System.out.print(quantity+" "+sum);
        scan.close();
    }
}
