package BaseCourse.ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskOneStepFive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int digit_one;
        int digit_two;
        int digit_three;
        int sum = 0;
        if(number<0) number=-number;
        if(number<100||number>999){
            System.out.println("ERROR");
            return;
        }
        digit_one = number / 100;
        digit_two = (number % 100) / 10;
        digit_three = (number % 100) % 10;
        if (digit_one % 2 > 0) sum += digit_one;
        if (digit_two % 2 > 0) sum += digit_two;
        if (digit_three % 2 > 0) sum += digit_three;
        if ((digit_one % 2 == 0) & (digit_two % 2 == 0) & (digit_three % 2 == 0)){
            System.out.println("NO");
        }
        else {
            System.out.println(sum);
        }
    }
}
