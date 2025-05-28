package BaseCourse.ModuleTwo;

import java.util.Scanner;

public class ModuleTwoTaskThreeStepSeven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int width = scan.nextInt();
        if (width <= 0)  {
            System.out.println("ERROR");
            return;
        } else if (height <= 0) {
            System.out.println("ERROR");
            return;
        }
        for (int k = 1; k <= width; k++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 1; i < height - 1; i++){
            System.out.print("*");
            for (int j = 2; j < width; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        if (height > 1){
            for (int k = 1; k <= width; k++) {
                System.out.print("*");
            }
        }
    }
}
