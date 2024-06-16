package ModuleFour;

import java.util.Random;
import java.util.Scanner;


class ModuleFourTaskOneStepFourteen {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size = scan.nextInt();
        int[] massiv = new int[size];
        int min, index = 0;
        for (int i = 0; i  < size; i++) {
            massiv[i] = scan.nextInt();
        }
        min = massiv[0];
        for (int j = 0; j < massiv.length; j++) {
            if (massiv[j] <= min) {
                min = massiv[j];
                index = j;
            }
        }
        massiv[index] = -1;
        for (int el:massiv) {
            System.out.print(el + " ");
        }
        scan.close();
    }
}
