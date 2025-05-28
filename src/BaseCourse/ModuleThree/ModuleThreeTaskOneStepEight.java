package BaseCourse.ModuleThree;

import java.util.Scanner;

class ModuleThreeTaskOneStepEight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int kol = simpleInRange(a, b);
        System.out.println(kol);
    }

    static boolean isSimple(int number) {
        if (number == 1) {
            return false;
        }
        else if (number <= 0) {
            return false;
        }
        for (int j = 2; j < number; j++) {
            if (number % j == 0) {
                return false;
            }
            else continue;
        }
        return true;
    }

    static int simpleInRange(int a, int b) {
        int quantity = 0;
        if (a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        for (int number_in_range = a; number_in_range <= b; number_in_range++) {
            if (isSimple(number_in_range) == true) quantity++;
        }
        return quantity;
    }
}
