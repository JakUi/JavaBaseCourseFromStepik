package ModuleTwo;

import java.util.Scanner;

public class ModuleTwoTaskThreeStepEleven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number_a = scan.nextInt();
        int number_b = scan.nextInt();
        int number_a1, number_b1;
        int max_sum_in_numbers = 0;
        int answer = 0;
        int i1, digit = 0;
        if (number_a > number_b) {
            number_b1 = number_a;
            number_a1 = number_b;
        } else {
            number_a1 = number_a;
            number_b1 = number_b;
        }
        for (int i = number_a1; i <= number_b1; i++) {
            i1 = i;
            int sum = 0;
            do {
                digit = Math.abs(i1 % 10); // получаем последнюю цифру
                sum += digit;
                i1 /= 10; // избавляемся от последней цифры в числе
            } while (i1 != 0);
            if (max_sum_in_numbers < sum) {
                max_sum_in_numbers = sum;
                answer = i;
            }
        }
        System.out.println(answer);
        System.out.close();
    }
}
