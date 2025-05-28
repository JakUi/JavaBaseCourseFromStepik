package BaseCourse.ModuleFour;

import java.util.Random;
import java.util.Scanner;


class ModuleFourTaskOneStepFifteen {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size = scan.nextInt();
        int seed = scan.nextInt();
        int last_negative_index = 0, max_element_index = 0;
        int last_negative_element = 0;
        Random rand = new Random(seed); //Создаем объект класса Random
        int[] massiv = new int[size];
        for(int i = 0; i < massiv.length; i++){
            massiv[i] = rand.nextInt(-5, 16);
        }
        for (int el:massiv){
            System.out.print(el + " ");
        }
        System.out.println();
//        Поменять местами первый максимальный и последний отрицательный элементы. Если отрицательных элементов нет в массиве, то он должен остаться без изменения.
        int max_element = massiv[0];
        for (int j = 1; j < massiv.length; j++) { // ищем первый максимальный элемент
            if (massiv[j] > max_element) {
                max_element = massiv[j];
                max_element_index = j;
            }
            if (massiv[j] < 0) {
                last_negative_element = massiv[j];
                last_negative_index = j;
                last_negative_element = massiv[j];
            }
        }
        if (last_negative_element != 0) {
            massiv[max_element_index] = last_negative_element;
            massiv[last_negative_index] = max_element;
        }
        for (int el_1:massiv) {
            System.out.print(el_1 + " ");
        }
        System.out.println();
        scan.close();
    }
}
