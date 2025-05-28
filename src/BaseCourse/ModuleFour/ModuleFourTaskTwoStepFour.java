package BaseCourse.ModuleFour;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class ModuleFourTaskTwoStepFour {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size = scan.nextInt();
        int seed = scan.nextInt();
        double min_element, max_element;
        Random rand = new Random(seed); //Создаем объект класса Random
        double[] massiv = new double[size];
        for(int i = 0; i < massiv.length; i++){
            massiv[i] = rand.nextDouble(0, 2);
        }
        double sorted_massiv[] = Arrays.copyOf(massiv, massiv.length);
        Arrays.sort(sorted_massiv);
        min_element = sorted_massiv[0];
        max_element = sorted_massiv[sorted_massiv.length - 1];
        double sum_min_max = min_element + max_element;
        System.out.println(Arrays.toString(massiv));
        System.out.println(sum_min_max);
        scan.close();
    }
}
