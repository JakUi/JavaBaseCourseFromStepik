package BaseCourse.ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskTwoStepEight {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int digit;
        int sum = 0;
        digit = scan.nextInt();
        if (digit <= 0) {
            System.out.println("ERROR");
            return;
        }
        for(int counter = 1; counter <= digit; counter++) {
            if (digit % counter == 0) {
                sum += counter;
            }
        }
        System.out.println(sum);
        scan.close();
    }
}
