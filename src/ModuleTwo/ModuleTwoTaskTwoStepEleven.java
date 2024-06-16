package ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskTwoStepEleven {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int digit = scan.nextInt();
        int number;
        int counter = 0;
        number = scan.nextInt();
        do {
            if (number == 0){
                return;
            }
            else if (digit % number == 0) {
                counter++;
            }
            number = scan.nextInt();
        } while (number > 0);
        System.out.println(counter);
        scan.close();
    }
}
