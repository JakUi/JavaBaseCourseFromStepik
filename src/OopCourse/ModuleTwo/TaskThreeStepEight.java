package OopCourse.ModuleTwo;
import java.util.Locale;

import java.util.Scanner;


public class TaskThreeStepEight{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        // Введите размер массива и создайте массив фигур, для которых можно подсчитать площадь.
        int arraySize = scan.nextInt();
        IShape[] figures = new IShape[arraySize];
        // Заполнить массив объектами, считав их данные с консоли.
        for (int i = 0; i < arraySize; i++) {
            // В начале каждой строки стоит тип объекта: 1 - прямоугольник, 2 - куб.
            int type = scan.nextInt();
            //  Затем идут длины сторон (для прямоугольника две стороны, для куба - одна). Все данные отделяются пробелами.
            if (type == 1) {
                figures[i] = new Rectangle(scan.nextDouble(), scan.nextDouble());
            }
            if (type == 2) {
                figures[i] = new Cube(scan.nextDouble());
            }
        }

//        Перебрав массив, распечатайте площади всех фигур, отделяя их пробелами. В конце этой строки тоже должен быть пробел.
//        Площади округляются до двух знаков после десятичной точки.
        for (int j = 0; j < arraySize; j++){
            System.out.printf("%.2f ", figures[j].computeSquare());

        }
        System.out.println(); // переведите курсор на новую строку
        // Еще раз переберите массив и найдите прямоугольник с максимальной площадью (если площади одинаковые, выбирается прямоугольник с меньшим индексом).
        // Выведите информацию о нем в формате: Прямоугольник сторона 1 = 3.45, сторона 2 = 2.67 Площадь = 9.21
        // Если же в массиве нет ни одного прямоугольника, то выведите слово ERROR.
        boolean hasRectangles = false;
        int maxRectangleSquareIndex = 0;
        double maxSquare = 0.0;
        if (figures[0] instanceof Rectangle) {
            hasRectangles = true;
            Rectangle item = (Rectangle) figures[0]; //преобразование к типу подкласса
            maxSquare = item.computeSquare();
            maxRectangleSquareIndex = 0;
        }
        for(int k = 1; k < arraySize; k++){
            if (figures[k] instanceof Rectangle) {
                hasRectangles = true;
                Rectangle item = (Rectangle) figures[k]; //преобразование к типу подкласса
                if (maxSquare < item.computeSquare()) {
                    maxSquare = item.computeSquare();
                    maxRectangleSquareIndex = k;
                }
            }
        }
        if (hasRectangles == false) {
            System.out.println("ERROR");
        } else if (hasRectangles == true) {
            Rectangle item = (Rectangle) figures[maxRectangleSquareIndex]; //преобразование к типу подкласса
            System.out.printf("Прямоугольник сторона 1 = " + item.getA() + ", сторона 2 = " + item.getB() + " Площадь = " + "%.2f%n", item.computeSquare());
        }
    }
}

interface IShape { // Опишите интерфейс IShape, содержащий метод double computeSquare().
    double computeSquare();
}

class Rectangle implements IShape { // Создайте класс Rectangle (прямоугольник), реализующий интерфейс IShape.
    double a;
    double b;
    Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double computeSquare() {
        double square = a * b;
        return square ;
    }
}

class Cube implements IShape {
    double c;
    Cube(double c){
        this.c = c;
    }
    @Override
    public double computeSquare() {
        double square = 6 * c * c;
        return square ;
    }
}
