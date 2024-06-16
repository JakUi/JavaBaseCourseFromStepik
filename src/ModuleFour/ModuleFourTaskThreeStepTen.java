package ModuleFour;

import java.util.Random;
import java.util.Scanner;

public class ModuleFourTaskThreeStepTen {
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
        // В каждой строке найти первый отрицательный элемент и вывести индекс соответствующего столбца или слово "NO", если он отсутствует.
        for (int b = 0; b < strings; b++){
            boolean has_negatives = false;
            for (int c = 0; c < rows; c++){
                if (array[b][c] < 0){ // ищем отрицательный элемент
                    System.out.println(c);
                    has_negatives = true;
                    break;
                }
            }
            if (has_negatives == false) {
                System.out.println("NO");
            }
        }
    }
}
