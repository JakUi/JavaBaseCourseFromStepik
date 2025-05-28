package OopCourse.ModuleThree;

import java.util.Scanner;
import java.util.Locale;


public class TaskTwoStepFourteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        Luggage luggage = new Luggage(10);
        double weight = scan.nextDouble();
        // Введите вес багажа с консоли. Выведите на консоль “Надо пройти регистрацию на рейс”.
        // Далее вызовите метод checkLuggage() c параметром, который ввел пользователь.
        // Если выполнение метода прошло успешно, выведите на консоль “Доплата за вес не нужна”.
        // Если нет – то выведите “Превышение веса багажа”, используя подходящий метод.
        // Затем выведите “Нужно оплатить превышение веса по тарифу”
        // В любом случае (как при удачном, так и при неудачном завершении метода checkLuggage()) выведите на консоль “Регистрация пройдена”.
        try {
            System.out.println("Надо пройти регистрацию на рейс");
            luggage.checkLuggage(weight);
            System.out.println("Доплата за вес не нужна");
        }
        catch (HeavyLuggageException ex) {
            System.out.println("Превышение веса багажа");
            System.out.println("Нужно оплатить превышение веса по тарифу");
        }
        finally {
            System.out.println("Регистрация пройдена");
        }
    }
}

class HeavyLuggageException extends Exception {  //Создайте класс-исключение HeavyLuggageException.
    // Предусмотрите конструктор без параметров, в котором вызывается конструктор суперкласса со строковым аргументом “Превышение веса багажа”
    HeavyLuggageException(){
        super("Превышение веса багажа");
    }
}

class Luggage {
    // приватную финализированную переменную maxWeight (максимальный вес) типа double.
    private final double maxWeight;

    Luggage(double maxWeight) {
        this.maxWeight = maxWeight;
    }
    // Метод void checkLuggage (double weight); В этом методе сначала выводится на консоль сообщение “Взвесим багаж”.
    // Затем анализируется параметр. Если он больше maxWeight, то выбрасывается исключение HeavyLuggageException.
    // В конце метода выводится на консоль “Допустимый вес багажа”.
    // Метод checkLuggage() исключений не обрабатывает.
    void checkLuggage(double weight)  throws HeavyLuggageException {
        System.out.println("Взвесим багаж");
        if (weight > maxWeight) throw new HeavyLuggageException();
        System.out.println("Допустимый вес багажа");
    }
}