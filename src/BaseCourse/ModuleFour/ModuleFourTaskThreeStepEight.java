package BaseCourse.ModuleFour;

import java.util.Random;
import java.util.Scanner;

public class ModuleFourTaskThreeStepEight{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] array = new int[scan.nextInt()][scan.nextInt()];
        Random rand = new Random(scan.nextInt());
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rand.nextInt(-5, 5);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        int max = array[0][0];
        int counter = 0;
        for (int m = 0; m < array.length; m++){
            for (int l = 0; l < array[m].length; l++){
                if (max < array[m][l]) {
                    max = array[m][l];
                }
            }
        }
        for (int i1 = 0; i1 < array.length; i1++){
            for (int j1 = 0; j1 <array[i1].length; j1++){
                if (max == array[i1][j1]){
                    counter++;
                }
            }
        }
        System.out.println(max + " " + counter);
    }
}
