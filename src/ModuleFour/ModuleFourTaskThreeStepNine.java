package ModuleFour;

import java.util.Random;
import java.util.Scanner;

public class ModuleFourTaskThreeStepNine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int strings = scan.nextInt();
        int rows = scan.nextInt();
        int[][] array = new int[strings][rows];
        Random rand = new Random(scan.nextInt());
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rand.nextInt(-10, 11);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int c = 0; c < rows; c++){
            int sum_positives = 0;
            for (int b = 0; b < strings; b++){
                if (array[b][c] > 0){
                    sum_positives += array[b][c];
                }
            }
            System.out.print(sum_positives + " ");
        }
    }
}
