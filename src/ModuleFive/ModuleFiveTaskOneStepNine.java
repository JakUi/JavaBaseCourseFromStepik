package ModuleFive;

import java.util.Arrays;
import java.util.Scanner;


class ModuleFiveTaskOneStepNine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input_string = new String(scan.nextLine());
        String changed_string = new String();
        changed_string = input_string.replace(";", ".,");
        System.out.println(changed_string);
    }
}
