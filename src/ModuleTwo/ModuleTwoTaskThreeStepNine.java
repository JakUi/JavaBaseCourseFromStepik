package ModuleTwo;

import java.util.Scanner;

public class ModuleTwoTaskThreeStepNine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        if (height <= 0)  {
            System.out.println("ERROR");
            return;
        }
        for (int k = 0; k < (height + 1) / 2; k ++) {
            for (int i = 0; i < k; i++){
                System.out.print(" ");
            }
            for (int j = height - (k * 2); j > 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
