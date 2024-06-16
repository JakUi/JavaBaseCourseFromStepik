package ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskTwoStepFour {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int start, finish, start_1, finish_1;
        double result = 0;
        start = scan.nextInt();
        finish = scan.nextInt();
        if (start > finish) {
            start_1 = finish;
            finish_1 = start;
        }
        else {
            start_1 = start;
            finish_1 = finish;
        }
        int counter_in_range = start_1;
        result = start_1;
        while(counter_in_range < finish_1){
            counter_in_range++;
            result = result * counter_in_range;
        }
        System.out.println(result);
        scan.close();
    }
}
