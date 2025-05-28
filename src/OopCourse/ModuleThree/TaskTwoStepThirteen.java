package OopCourse.ModuleThree;

import java.util.Scanner;


public class TaskTwoStepThirteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Parking parking = new Parking((byte) 10);
        byte quantity = scan.nextByte();
        // Затем выведите на консоль “Приехали на парковку” и вызовите метод check() с аргументом – количеством машин.
        // Если места достаточно, то выведите “Припарковались”.
        // Если нет – то на консоли должно быть сообщение “Вся парковка занята. Свободных мест нет.”,
        // а затем: “Припарковались в другом месте”.
        // В любом случае последнее сообщение на консоли должно быть “Выходим из машин”.
        try {
            System.out.println("Приехали на парковку");
            parking.check(quantity);
            System.out.println("Припарковались");
        }
        catch (TooManyCarsException ex) {
            System.out.println("Вся парковка занята. Свободных мест нет.");
            System.out.println("Припарковались в другом месте");
        }
        finally {
            System.out.println("Выходим из машин");
        }
    }
}

class TooManyCarsException extends Exception {  // Создайте класс-исключение TooManyCarsException.
    // Предусмотрите конструктор без параметров, в котором вызывается конструктор суперкласса
    // со строковым аргументом “Вся парковка занята. Свободных мест нет.”
    TooManyCarsException(){
        super("Вся парковка занята. Свободных мест нет.");
    }
}

// Создайте класс Parking (парковка), который содержит поле maxQuantity типа byte.
class Parking {
    byte maxQuantity;

    Parking(byte maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    void check(byte quantity) throws TooManyCarsException{
        // Метод check() с параметром quantity типа byte. Этот метод не возвращает результата.
        // В нем сначала на консоль выводится “Ищем место для парковки”.
        // Затем, если параметр больше maxQuantity, то выбрасывается исключение TooManyCarsException.
        // В конце метода на консоль выводится: “Нашли место для парковки”.
        // Метод check() не обрабатывает исключений.
        System.out.println("Ищем место для парковки");
        if (quantity > maxQuantity) throw new TooManyCarsException();
        System.out.println("Нашли место для парковки");
    }
}


