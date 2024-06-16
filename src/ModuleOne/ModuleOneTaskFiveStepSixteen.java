package ModuleOne;

import java.util.Scanner;


class ModuleOneTaskFiveStepSixteen {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        double a;
        double z;
        double y;
//        a = scan.nextDouble();
        a = 4.78;
        z = 2 * Math.pow(Math.sin(3 * Math.PI - 2 * a), 2) * Math.pow(Math.cos(5 * Math.PI + 2 * a) , 2);
        y = 1.0 / 4.0 - (1.0 / 4.0) * Math.sin(5.0 / 2.0 * Math.PI - 8 * a);
        System.out.printf("%02.5f ", z);
        System.out.printf("%02.5f", y);
        scan.close();
    }
}
