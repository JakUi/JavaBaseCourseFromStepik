package ModuleFour;

import java.util.Random;
import java.util.Scanner;


class ModuleFourTaskFourStepEight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] mas = new int[scan.nextInt()][scan.nextInt()];
        long seed = scan.nextLong();
        int ind = scan.nextInt();
        initArray(mas, seed);
        printArray(mas);
        System.out.println();
        mas = deleteRow(mas, ind);
        printArray(mas);
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

    public static int[][] deleteRow(int[][] mas, int ind){
        int massiv_without[][] = new int[mas.length - 1][mas[0].length];
        if (ind < 0 || ind > massiv_without.length) {
            return mas;
        }
        int row_index = 0;
        while (row_index != ind) {
            massiv_without[row_index] = mas[row_index];
            row_index++;
        }
        for (int i_after = row_index; i_after < massiv_without.length; i_after++) {
            massiv_without[i_after] = mas[i_after + 1];
        }

        return massiv_without;
    }
}
