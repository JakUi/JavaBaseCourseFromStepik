package BaseCourse.ModuleOne;

import java.util.Scanner;


class ModuleOneTaskFiveStepFifteen {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        double x;
        double fx;
//        x = scan.nextDouble();
        x = 3.45;
        fx = Math.log(x + 7 * Math.sqrt(Math.pow(x, 4.0) + Math.PI));
        System.out.printf("%02.4f", fx);
        scan.close();
    }
}
