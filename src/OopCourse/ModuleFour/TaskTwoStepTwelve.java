package OopCourse.ModuleFour;

import java.util.Locale;
import java.util.Scanner;


public class TaskTwoStepTwelve {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        // В классе Main введите данные двух собак, которые отделяются пробелами.
        Dog dog = new Dog(scan.next(), scan.next(), scan.next(), scan.nextDouble());
        Dog dogTwo = new Dog(scan.next(), scan.next(), scan.next(), scan.nextDouble());
        int compareParam = dog.compareTo(dogTwo);
        if (compareParam < 0) {
            System.out.println("Вторая собака больше");
        }
        else if (compareParam == 0) {
            System.out.println("Собаки одинакового размера");
        }
        else {
            System.out.println("Первая собака больше");
        }
        scan.close();
    }
}

class Dog {
    //    кличка и порода, ошейник
    String name;
    String breed;
    private Collar collar;

    // В классе Dog конструктор должен принимать все характеристики собаки: кличку, породу, цвет ошейника, размер ошейника.
    Dog(String name, String breed, String collarColor, double collarSize) {
        this.name = name;
        this.breed = breed;
        this.collar = new Collar(collarColor, collarSize);
    }

    private class Collar {
        private String collarColor;
        private double collarSize;

        public Collar(String collarColor, double collarSize){
            this.collarColor = collarColor;
            this.collarSize = collarSize;
        }
        public double getcollarSize() {
            return collarSize;
        }
    }

    public int compareTo(Dog dogTwo){  // который возвращает положительное число, если больше ошейник у собаки,
        // от имени которой он вызывается, отрицательное - если больше ошейник у собаки-параметра метода
        if (collar.collarSize > dogTwo.collar.collarSize){
            return 1;
        } else if (collar.collarSize < dogTwo.collar.collarSize) {
            return -1;
        }
        else {
            return 0; //возвращает ноль, если собаки одинакового размера
        }
    }
}
