package OopCourse.ModuleFour;

import java.util.Locale;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;


public class TaskFourStepTen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        int boxes = scan.nextInt();
        Garage garage = new Garage(boxes);
        int userDecision = 0;
        while (userDecision != 4){
            userDecision  = scan.nextInt(); // Затем пользователь вводит число
            // пользователь вводит 1, если он хочет поставить машину в гараж, 2 - если взять машину, 3 - вывести список машин в цикле for-each, 4 - закончить работу с программой.
            if (userDecision == 1) {
                // Если введено 1, то далее вводится марка, объем двигателя и номер бокса. В случае ошибки (неверный номер бокса или он занят),
                // осуществляется поиск первого свободного бокса и машина ставится туда. Если свободных боксов нет, то ничего не выполняется.
                Car car = new Car(scan.next(), scan.nextDouble());
                try {
                    int number = scan.nextInt();
                    garage.isFree(number);
                    garage.putCar(car, number);
                } catch (ErrorBoxException ex) {
                    // В случае ошибки (неверный номер бокса или он занят),
                    // осуществляется поиск первого свободного бокса и машина ставится туда. Если свободных боксов нет, то ничего не выполняется.
                    int freeboxNumber = garage.getFreeBoxnumber();
                    if (freeboxNumber != -1) garage.putCar(car, freeboxNumber);
                }
            }
            if (userDecision == 2) {
                // Если введено 2, то далее вводится номер бокса. На консоль выводятся данные полученной машины. Если номер неверен или бокс пустой, то выводится "ERROR".
                int number = scan.nextInt();
                if (number < 1 && number > boxes || garage.getCar(number) == null) {
                    System.out.println("ERROR");
                }
                if (number >= 1 && number <= boxes && garage.getCar(number) != null) {
                    System.out.println(garage.getCar(number));
                    garage.carsArray.set(number, null);
                }
            }
            if (userDecision == 3) {
                // Если введено 3, то список машин в гараже выводится с конца к началу циклом for-each.
                System.out.println("----------------");
                for (Car car : garage) {
                    System.out.println(car);
                }
                System.out.println("----------------");
            }
            if (userDecision >= 4) return;
        }
    }
}

class Car {
    String brand;
    Double volume;

    Car(String brand, Double volume) {
        this.brand = brand;
        this.volume = volume;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return brand + ";"  + volume;
    }
}

class ErrorBoxException extends Exception {
     // Опишите класс-исключение ErrorBoxException. Это исключение будет выбрасываться в случае неверного номера бокса в гараже.
     public ErrorBoxException() {
         super();
     }
}

class Garage implements Iterable<Car>, Iterator<Car> {

    ArrayList<Car> carsArray;
    int boxes;
    int count;
    // Опишите класс Garage, который инкапсулирует массив машин (объектов класса Car).
    // Т.е. он имеет поле, которое является ссылкой на обычный массив объектов Car.
    // При создании гаража в конструктор передается количество боксов в гараже, и конструктор создает массив нужного размера.

    Garage(int boxes) {
        this.boxes = boxes;
        this.carsArray = new ArrayList<>(boxes);
        for (int i = 1; i <= boxes + 1; i++) {
            carsArray.add(null);
        }
    }

    public ArrayList<Car> getCarsArray() {
        return carsArray;
    }

    public void setCarsArray(ArrayList<Car> carsArray) {
        this.carsArray = carsArray;
    }

    public int getBoxes() {
        return boxes;
    }

    public void setBoxes(int boxes) {
        this.boxes = boxes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    void putCar(Car unit, int i) {  // поставить машину в гараж в бокс i
        carsArray.set(i, unit);
    }

    Car getCar(int i) {  // взять машину из гаража из i-го бокса
        return carsArray.get(i);
    }

    boolean isFree(int number) throws ErrorBoxException { // проверяет, верный ли номер и свободен ли бокс
        if (number < 1 || number > boxes || carsArray.get(number) != null) throw new ErrorBoxException();
//        return carsArray.get(number) == null;
        return true;

    }

    int getFreeBoxnumber() { // возвращает номер первого свободного бокса от конца или -1, если нет свободных
        return carsArray.lastIndexOf(null);
    }

    @Override
    public Iterator<Car> iterator() {
        count = carsArray.size() - 1;
        return this;
    }

    @Override
    public boolean hasNext() {
        return count > 0;
    }

    @Override
    public Car next() {
        if (!hasNext()) throw new NoSuchElementException();
        return carsArray.get(count--);
    }
}
