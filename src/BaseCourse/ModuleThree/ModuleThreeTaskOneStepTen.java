package BaseCourse.ModuleThree;

import java.util.Scanner;

class ModuleThreeTaskOneStepTen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int max = maxNumberDivider(a, b);
        System.out.println(max);
    }

    static int maxNumberDivider(int a, int b) {
        int max = 0, max_1 = 0, number = 0;
        for (int i = a; i <= b; i++){
            max_1 = dividerCount(i);
            if (max_1 > max) {
                max = max_1;
                number = i;
            }
        }
        return number;
    }

    static int dividerCount(int i) {
        int count = 0;
        for (int j = 1; j <= i; j ++) {
            if (i % j == 0) {
                count++;
            }
        }
        return count;
    }
}
