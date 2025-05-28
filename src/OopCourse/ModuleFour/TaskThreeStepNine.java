package OopCourse.ModuleFour;

import java.util.Scanner;


public class TaskThreeStepNine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bufferSize = 11;
        Stack stack = new Stack(bufferSize);
        while(true) {
            String buffer = scan.nextLine();
            if ("Конец".equals(buffer)) break;
            String[] splitted = buffer.split(" ");
            String lastName = splitted[0];
            double averageMark = Double.parseDouble(splitted[1]);
            int age = Integer.parseInt(splitted[2]);
            StudentChanged studentChanged = new StudentChanged(lastName, averageMark, age);
            stack.push(studentChanged);
        }
        try {
            stack.print();
        }
        catch (stackException EX) {
            System.out.println(EX.getMessage());
        }
    }
}

class StudentChanged {
    String lastName;
    double averageMark;
    int age;

    StudentChanged(String lastName, double averageMark, int age){
        this.lastName = lastName;
        this.averageMark = averageMark;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(int averageMark) {
        this.averageMark = averageMark;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return lastName + ";" + averageMark + ";" + age;
    }
}

class stackException extends Exception {
    stackException(){
    }

    stackException(String message){
        super(message);
    }
}

class Stack<E> {
    int bufferSize;
    private E[] array;
    private int tail = -1;

    public Stack(int bufferSize) {
        this.bufferSize = bufferSize;
        array = (E[]) new Object[bufferSize];
        tail = -1;
    }

    public void push(E elem) { //занести любое значение в вершину стека
        if (tail == bufferSize - 1) {
            System.out.println("Стек заполнен!");
        } else {
            array[++tail] = elem; //запись в конец очереди
        }
    }

    public E pop() throws stackException{ // извлечь символ из вершины стека
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
