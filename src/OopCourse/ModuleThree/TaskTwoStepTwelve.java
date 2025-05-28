package OopCourse.ModuleThree;

import java.util.Scanner;


public class TaskTwoStepTwelve {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        Cook cook = new Cook();
        // вызовите последовательно методы turnOvenOn() и bake()
        cook.turnOvenOn();
        try {
            cook.bake(product);
            System.out.println("Блюдо готово");
        }
        catch (BakingException ex) {
            System.out.println("Блюдо полностью испортилось: " + ex.getMessage());
        }
        finally {
            cook.turnOvenOff();
        }
    }
}

class BakingException extends Exception { // Создайте класс-исключение BakingException.
    BakingException(String message){
        super(message); // Предусмотрите конструктор этого класса, в который передается сообщение о причине неудачи с выпечкой.
    }
}

class Cook {
    void turnOvenOn(){ // метод turnOvenOn() – выводит на консоль сообщение “Включаю плиту”
        System.out.println("Включаю плиту");
    }
    void turnOvenOff(){ // метод turnOvenOn() – выводит на консоль сообщение “Выключаю плиту”
        System.out.println("Выключаю плиту");
    }

    void bake(String Product) throws BakingException {
        System.out.println("Готовлю блюдо");
        if (Product.equals("Прогорклое масло")) throw new BakingException(Product);
        if (Product.equals("Низкосортная мука")) throw new BakingException(Product);
        System.out.println("Конец приготовления блюда");
    }
}
