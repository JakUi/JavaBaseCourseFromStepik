package ModuleOne;

import java.util.Scanner;


class ModuleOneTaskFiveStepTwelve {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int rub;
        int kop;
        int discount;
        int sum_with_discount_in_kop;
        double to_pay_kop;
        double to_pay_rub;
        rub = scan.nextInt();
        kop = scan.nextInt();
//        rub = 57;
//        kop = 86;
//        discount = 15;
        discount = scan.nextInt();
        sum_with_discount_in_kop = (rub * 100 + kop) - (rub * 100 + kop) * discount / 100;
        to_pay_rub = sum_with_discount_in_kop / 100;
        to_pay_kop = sum_with_discount_in_kop % 100;
        System.out.printf("%02.0f руб. ", to_pay_rub);
        System.out.printf("%02.0f коп.", to_pay_kop);
        scan.close();
    }
}