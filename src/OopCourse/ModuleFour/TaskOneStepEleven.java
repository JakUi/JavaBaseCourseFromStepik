package OopCourse.ModuleFour;

import java.util.Scanner;


public class TaskOneStepEleven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expression;
        expression = scan.nextLine();
        String operand = "\\u002B"; // \u002B - это знак + в unicode (далее аналогично вместо знаков используются символы !!!!
        if (expression.contains("+")) {
            operand = "\\u002B";
            String[] numbers = expression.split(operand);
            try {
                int total = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
                System.out.println(expression + "=" + total);
            }
            catch (Exception ex) {
                System.out.println("Error");
            }
        }
        else if (expression.contains("-")) {
            operand = "\\u002d";
            String[] numbers = expression.split(operand);
            try {
                int total = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
                System.out.println(expression + "=" + total);
            }
            catch (Exception ex) {
                System.out.println("Error");
            }
        }
        else if (expression.contains("*")) {
            operand = "\\u002a";
            String[] numbers = expression.split(operand);
            try {
                int total = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
                System.out.println(expression + "=" + total);
            }
            catch (Exception ex) {
                System.out.println("Error");
            }
        }
        else if (expression.contains("/")) {
            operand = "\\u002f";
            String[] numbers = expression.split(operand);
            try {
                int total = Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1]);
                System.out.println(expression + "=" + total);
            }
            catch (Exception ex) {
                System.out.println("Error");
            }
        }
        else if (expression.contains("%")) {
            operand = "\\u0025";
            String[] numbers = expression.split(operand);
            try {
                int total = Integer.parseInt(numbers[0]) % Integer.parseInt(numbers[1]);
                System.out.println(expression + "=" + total);
            }
            catch (Exception ex) {
                System.out.println("Error");
            }
        }
        else {
            System.out.println("Error");
        }
    }
}

