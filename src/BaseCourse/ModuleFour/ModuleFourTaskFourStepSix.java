package BaseCourse.ModuleFour;

import java.util.Random;
import java.util.Scanner;


class ModuleFourTaskFourStepSix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] mas = new int[scan.nextInt()][scan.nextInt()];
        long seed = scan.nextLong();
        initArray(mas, seed);
        printArray(mas);
        System.out.println();
        printMaxIndex(mas);
    }
    public static void initArray(int[][] mas, long seed){
        Random rand = new Random(seed);
        for(int i = 0; i < mas.length; i++){
            for(int j = 0; j < mas[i].length; j++){
                mas[i][j] = rand.nextInt(0, 11);
            }
        }
    }
    public static void printArray(int[][] mas){
        for(int c = 0; c < mas.length; c++){
            for(int r = 0; r < mas[c].length; r++){
                System.out.print(mas[c][r] + "\t");
            }
            System.out.println();
        }
    }

    public static int findMax(int[] ar){
        int max_element = ar[0];
        int max_element_index = 0;
        for (int a = 0; a < ar.length; a++){
            if (max_element < ar[a]) {
                max_element_index = a;
                max_element = ar[a];
            }
        }
        return max_element_index;
    }

    public static void printMaxIndex(int mas[][]){
        int max_element_index = 0;
        for(int[] row:mas){
            max_element_index = findMax(row);
            System.out.print(max_element_index + " ");
        }
    }
}
