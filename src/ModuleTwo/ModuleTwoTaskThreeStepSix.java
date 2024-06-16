package ModuleTwo;

import java.util.Scanner;

public class ModuleTwoTaskThreeStepSix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int width = scan.nextInt();;
        if (width <= 0)  {
            System.out.println("Error! Width must be in range 1-9");
            return;
        } else if (width >= 10) {
            System.out.println("Error! Width must be in range 1-9");
            return;
        }
        for (int i = width; i >= 1; i--){
            for (int k = i; k >=1; k--) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
