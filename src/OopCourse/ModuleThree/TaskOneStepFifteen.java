package OopCourse.ModuleThree;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskOneStepFifteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt(); // введите начальное значение генератора псевдослучайных чисел
        Random rand = new Random(index);
        int arraySize = rand.nextInt(1, 11); // разыграйте случайное число от 1 до 10
        int[] a = new int[arraySize]; // Создайте массив целых чисел соответствующего размера и заполните его нулями.
        // Затем пользователь трижды вводит индекс в массиве и значение элемента. Нужно записать значение по заданному индексу в массив.
        for (int c = 0; c < 3; c++) {
            int arrayElementIndex = scan.nextInt();
            int arrayElementValue = scan.nextInt();
            // Поскольку пользователь не знает размер массива, он может указать неверный индекс.
            // В этом случае в массив ничего не записывается, пользователю выводится сообщение: “Индекс не попал в массив”,
            // а программа продолжает свою работу.
            try {
                a[arrayElementIndex] = arrayElementValue;
            }
            catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println("Индекс не попал в массив");
            }
        }
        String str = Arrays.toString(a);
        System.out.println(str);
    }
}
