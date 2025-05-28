package BaseCourse.ModuleFive;

import java.util.Scanner;
import java.util.Arrays;


class ModuleFiveTaskOneStepThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String first_string = new String(scan.nextLine());
        String second_string = new String(scan.nextLine());
        String third_string = new String(scan.nextLine());
        String mas[] = {first_string, second_string, third_string};
        Arrays.sort(mas);
        for (String str:mas){
            System.out.println(str);
        }
    }
}
