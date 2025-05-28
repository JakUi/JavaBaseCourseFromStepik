package BaseCourse.ModuleFour;

import java.util.Scanner;
import java.util.Random;


class ModuleFourTaskOneStepTwelve {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size = scan.nextInt();
        int first_number = scan.nextInt();
        int sum = 0;
        double proizvedenie = 1;
        Random random = new Random();
        int mas_integer[] = new int[size];
        Random rand = new Random(first_number);
        for(int i = 0; i < mas_integer.length; i++){
            mas_integer[i] = rand.nextInt(-5, 6);
            System.out.print(mas_integer[i] + " ");
        }
        for (int el:mas_integer) {
            if (el > 0) {
                sum+=el;
            }
            else if (el < 0) {
                proizvedenie*=el;
            }
        }
        System.out.println();
        System.out.println(sum + " " + proizvedenie);
        scan.close();
    }
}
