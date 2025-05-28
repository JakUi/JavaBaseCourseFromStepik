package BaseCourse.ModuleThree;

import java.util.Scanner;

class ModuleThreeTaskOneStepSeven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int number = scan.nextInt();
            System.out.print(isSimple(number) + " ");
        }
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
}
