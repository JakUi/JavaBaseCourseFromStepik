package OopCourse.ModuleFour;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class TaskThreeStepFour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> positiveNumbersList = new ArrayList<>();
        ArrayList<Integer> negativeNumbersList = new ArrayList<>();
        String buffer = scan.nextLine();
        String[] splitted = buffer.split(" ");
        for (int index = 0; index < splitted.length - 1; index++){
            try {
//                System.out.println("'" + splitted[index] + "'");
                int number = Integer.parseInt(splitted[index]);
                if (number >= 0) { //если четное
                    positiveNumbersList.add(number); // происходит автоупаковка, добавляем в конец
                } else {
                    negativeNumbersList.add(number); // происходит автоупаковка, добавляем в конец
                }
            } catch (NumberFormatException ex) { // Если пользователь вводит строку, которую нельзя преобразовать к целому числу, то считать это число нулем и заносить в первый список!
                if (!"".equals(splitted[index])) positiveNumbersList.add(0);
            }
        }
        // Отсортировать эти списки по возрастанию и вывести на консоль, отделяя элементы пробелами
        // (сначала список неотрицательных, а затем с новой строки - список отрицательных).
        Collections.sort(positiveNumbersList);
        Collections.sort(negativeNumbersList);
        boolean arrayHasPositive = true;
        boolean arrayHasNegative = true;
        if (positiveNumbersList.isEmpty()) {
            arrayHasPositive = false;
        }
        if (negativeNumbersList.isEmpty()) {
            arrayHasNegative = false;
        }
        if (arrayHasPositive) {
            for (int i : positiveNumbersList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else {
            System.out.println("Пустой список");
        }
        if (arrayHasNegative) {
            for (int j : negativeNumbersList) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        else {
            System.out.println("Пустой список");
        }
        scan.close();
    }
}
