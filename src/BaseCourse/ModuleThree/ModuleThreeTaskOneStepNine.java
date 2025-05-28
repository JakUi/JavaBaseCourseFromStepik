package BaseCourse.ModuleThree;

import java.util.Scanner;

class ModuleThreeTaskOneStepNine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        printDivider(number);
    }

    static void printDivider(int number) {
        for (int i=1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
