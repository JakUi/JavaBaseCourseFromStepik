package OopCourse.ModuleThree;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class TaskOneStepFourteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt(); // введите начальное значение генератора псевдослучайных чисел
        Random rand = new Random(index);
        int arraySize = rand.nextInt(-10, 11); // разыграйте случайное число от -10 до 10
        // Создайте массив соответствующего размера и заполните его последовательными десятичными цифрами, начиная с нуля
        try {
            int[] a = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                a[j] = j;
            }
            String str = Arrays.toString(a);
            System.out.println(str);
        }
        catch (Exception exc) {
            System.out.println("Неверный размер массива: " + arraySize);
        }
    }
}
