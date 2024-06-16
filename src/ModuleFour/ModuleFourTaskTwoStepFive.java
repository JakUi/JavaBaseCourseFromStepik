package ModuleFour;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class ModuleFourTaskTwoStepFive {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size = scan.nextInt();
        int seed = scan.nextInt();
        Random rand = new Random(seed); //Создаем объект класса Random
        int[] massiv = new int[size];
        for(int i = 0; i < massiv.length; i++){
            massiv[i] = rand.nextInt(10, 21);
        }
        int first_index = scan.nextInt();
        int secon_index = scan.nextInt();
        System.out.println(Arrays.toString(massiv));
        Arrays.sort(massiv, first_index, secon_index + 1);
        System.out.println(Arrays.toString(massiv));
        scan.close();
    }
}
