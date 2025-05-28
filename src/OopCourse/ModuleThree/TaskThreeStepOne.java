package OopCourse.ModuleThree;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class TaskThreeStepOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        // Если пользователь вводит неверно размер массива, то программа должна добиться от него корректного ввода.
        // Для этого она выводит сообщение "Введите положительный размер массива!"
        // или "Размер массива должен быть целым числом!" (в зависимости от ошибки) и опять ожидает ввода этого числа.
        // До тех пор, пока оно не будет введено правильно!
        while (true) {
            try {
                int arraySize = scan.nextInt();
                int[] array = new int[arraySize];
                for (int i = 0; i < arraySize; i++) {
                    try {
                        array[i] = scan.nextInt();
                    } catch (InputMismatchException exEl) {
                        array[i] = 0;
                        scan.next(); //очистка буфера
                    }
                }
                // Затем с новой строки входных данных считывается индекс в массиве и выводится соответствующий элемент массива
                while (true) {
                    try {
                        int index = scan.nextInt();
                        System.out.println("Извлечено из массива: " + array[index]);
//                        break;
                    } catch (IndexOutOfBoundsException exIn) {
                        System.out.println("Неверный индекс!");
                    } catch (InputMismatchException exIn) {
                        System.out.println("Неверный индекс!");
                        scan.next(); //очистка буфера
                    }
                    finally {
                        break;
                    }
                }
                System.out.println(Arrays.toString(array));
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Размер массива должен быть целым числом!");
                scan.next(); //очистка буфера
            } catch (NegativeArraySizeException ex) {
                System.out.println("Введите положительный размер массива!");
            }
        }
    }
}
