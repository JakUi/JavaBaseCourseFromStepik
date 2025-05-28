package OopCourse.ModuleThree;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class TaskThreeStepFive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        int bufferSize = scan.nextInt();
        Stack stack = new Stack(bufferSize);
        while (true) {
            try {
                int command = scan.nextInt();
                // 1 - добавление в стек, 2 - удаление из стека, 3 - печать стека, 4 - очистка стека, 5 - выход из программы
                switch (command) {
                    case 1:
                        stack.push(scan.next().charAt(0));
                        break;
                    case 2:
                        try {
                            System.out.println("Извлечено: " + stack.pop());
                            break;
                        } catch (stackException ex) {
                            System.out.println(ex.getMessage());
                            break;
                        }
                    case 3:
                        try{
                            stack.print();
                            break;
                        }
                        catch (stackException ex) {
                            System.out.println(ex.getMessage());
                            break;
                        }
                    case 4:
                        stack.clear();
                        break;
                    case 5:
                        return;
                }
            } catch (
                    InputMismatchException ex) { // Если же пользователь некорректно вводит данные (например, вместо номера варианта вводит букву),
                // то выводится сообщение "Некорректный ввод данных" и программа завершается с кодом 0.
                System.out.println("Некорректный ввод данных");
                return;
            }
        }
        // . Если нужно добавить символ в стек, то затем пользователь вводит этот символ.
        // Этот код нужно дополнить обработкой исключительных ситуаций.
    }
}

class stackException extends Exception {
    stackException(){
    }

    stackException(String message){
        super(message);
    }
}

class Stack {
    int bufferSize;
    private char[] array;
    private int tail = -1;

    public Stack(int bufferSize) {
        this.bufferSize = bufferSize;
        array = new char[bufferSize];
        tail = -1;
    }

    public void push(char c) { //занести символ в вершину стека
        if (tail == bufferSize - 1) {
            System.out.println("Стек заполнен!");
        } else {
            array[++tail] = c; //запись в конец очереди
        }
    }

    public char pop() throws stackException{ // извлечь символ из вершины стека
        if (tail == -1) throw new stackException("Попытка извлечь из пустого стека!");
        return array[tail--];
    }

    public void print() throws stackException{ // распечатать содержимое стека, начиная от вершины. Элементы отделяются пробелами
        if (tail == -1) throw new stackException("Стек пуст");
        for(int i = tail; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void clear() { // очистка стека (стек становится пустым)
        tail = -1;
    }
}