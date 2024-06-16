package ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskOneStepTen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number_one = scan.nextInt();
        int number_two = scan.nextInt();
        int number_three = scan.nextInt();
        int number_four = scan.nextInt();
        int number_five = scan.nextInt();
        int min = number_one;
        if (number_two < min) {
            min = number_two;
        }
        if (number_three < min) {
            min = number_three;
        }
        if (number_four < min) {
            min = number_four;
        }
        if (number_five < min) {
            min = number_five;
        }
        System.out.println(min);
    }
}
