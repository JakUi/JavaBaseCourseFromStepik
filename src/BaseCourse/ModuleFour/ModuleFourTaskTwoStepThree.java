package BaseCourse.ModuleFour;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


class ModuleFourTaskTwoStepThree {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size = scan.nextInt();
        int seed = scan.nextInt();
        int control_element = scan.nextInt();
        Random rand = new Random(seed); //Создаем объект класса Random
        int[] massiv = new int[size];
        for(int i = 0; i < massiv.length; i++){
            massiv[i] = rand.nextInt(2, 16);
        }
        Arrays.sort(massiv);
        System.out.println(Arrays.toString(massiv));
        int ind = Arrays.binarySearch(massiv, control_element);
        if (ind < 0) {
            System.out.println("ERROR");
        }
        else {
            int[] slice_of_massiv = Arrays.copyOfRange(massiv, 0, ind + 1);
            System.out.println(Arrays.toString(slice_of_massiv));
        }
        scan.close();
    }
}
