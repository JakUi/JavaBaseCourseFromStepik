package OopCourse.ModuleFour;

import java.util.Scanner;


public class TaskOneStepTwelve {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder someString = new StringBuilder(scan.next());
        StringBuilder numberString = new StringBuilder(someString.length());
        int maxNumber = 0;
        boolean notNumber;
        boolean hasNumber = false;
        for (int i = 0; i < someString.length(); i++) {
            int asciiSym = someString.charAt(i);
            if ((asciiSym >= 49) & (asciiSym <=57 )) {
                    numberString.append(someString.charAt(i));
                    notNumber = false;
                    hasNumber = true;
                }
                else {
                    notNumber = true;
                }

            if (notNumber == false) {
                int number = Integer.parseInt(numberString.toString());
                if (number > maxNumber) {
                    maxNumber = number;
                }
            }
            else {
                numberString = new StringBuilder();
            }
        }
        if (hasNumber){
            System.out.println(maxNumber);
        }
        else {
            System.out.println(0);
        }
    }
}
