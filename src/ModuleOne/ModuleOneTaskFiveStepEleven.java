package ModuleOne;

import java.util.Scanner;


class ModuleOneTaskFiveStepEleven {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int number;
        int hours;
        int minutes;
        int seconds;
//        number = scan.nextInt();
        number = 456789123;
        hours = number / 3600;
        minutes = (number % 3600) / 60;
        seconds = (number % 3600) % 60;
        System.out.println(hours);
        System.out.println(minutes);
        System.out.println(seconds);
        scan.close();
    }
}
