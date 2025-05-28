package BaseCourse.ModuleFour;

import java.util.Random;
import java.util.Scanner;


class ModuleFourTaskOneStepThirteen {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size = scan.nextInt();
        long seed = scan.nextLong();
        double average;
        double sum = 0;
        Random rand = new Random(seed); //Создаем объект класса Random
        double[] mas_double = new double[size];
        for(int i = 0; i < mas_double.length; i++){
            mas_double[i] = rand.nextDouble(0., 5.);
            System.out.printf("%.2f ",mas_double[i]);
        }
        for (double el:mas_double) {
            sum+=el;
        }
        average = sum / mas_double.length;
        for (int j = 0; j < mas_double.length; j++) {
            if (mas_double[j] > average) {
                mas_double[j] = average;
            }
        }
        System.out.println();
        System.out.printf("%.2f", average);
        System.out.println();
        for(int k = 0; k < mas_double.length; k++) {
            System.out.printf("%.2f ", mas_double[k]);
        }
        scan.close();
    }
}
