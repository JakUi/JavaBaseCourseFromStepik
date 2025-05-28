package OopCourse.ModuleFour;

import java.util.Scanner;


public class TaskOneStepThirteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rawString = scan.next();
        String[] splittedString = rawString.split("#");
        float sum = 0;
        for(String i : splittedString) {
            try {
                float number = Float.valueOf(i);
                sum += number;
            }
            catch (NumberFormatException ex) {
            }
        }
        System.out.printf("%.1f%n", sum);
        scan.close();
    }
}