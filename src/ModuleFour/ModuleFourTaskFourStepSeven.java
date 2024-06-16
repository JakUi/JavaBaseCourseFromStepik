package ModuleFour;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class ModuleFourTaskFourStepSeven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] ar = new int[scan.nextInt()];
        long seed = scan.nextLong();
        init(ar, seed);
        print(ar);
        int[] b = reduceAfterMax(ar);
        print(b);
    }
    public static void init(int[] mas, long seed){
        Random rand = new Random(seed);
        for(int i = 0; i < mas.length; i++){
            mas[i] = rand.nextInt(-3, 6);
        }
    }
    public static void print(int[] ar){
        for (int el:ar){
            System.out.print(el + " ");
        }
        System.out.println();
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

    public static int[] reduceAfterMax(int[] ar){
        int border_index = findMax(ar);
        int changed_array[] = Arrays.copyOfRange(ar, 0, border_index + 1);
        return changed_array;
    }
}
