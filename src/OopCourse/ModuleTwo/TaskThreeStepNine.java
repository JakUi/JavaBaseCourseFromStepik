package OopCourse.ModuleTwo;

import java.util.Locale;
import java.util.Scanner;


public class TaskThreeStepNine{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        // Введите размер массива и создайте массив транспортных средств.
        int arraySize = scan.nextInt();
        Transport[] vehicles = new Transport[arraySize];
        // Заполнить массив объектами, считав их данные с консоли.
        for (int i = 0; i < arraySize; i++) {
            // В начале каждой строки стоит тип объекта: 1 - грузовик, 2 - корабль
            int type = scan.nextInt();
            //  Затем идет грузоподъемность транспортного средства
            if (type == 1) {
                vehicles[i] = new Lorry(scan.nextDouble());
            }
            if (type == 2) {
                vehicles[i] = new Ship(scan.nextDouble());
            }
        }
        double weight = scan.nextDouble();
        // Для каждого транспортного средства проверьте, может ли оно перевезти этот груз. Если да – нагрузите его.
        for (int j = 0; j < arraySize; j++) {
            if (vehicles[j] instanceof Lorry) {
                Lorry item = (Lorry) vehicles[j]; //преобразование к типу подкласса
                if (item.canCarry(weight)) {
                    item.add(weight);
                }
                System.out.println(item.toString());
            }
            if (vehicles[j] instanceof Ship) {
                Ship item = (Ship) vehicles[j]; //преобразование к типу подкласса
                if (item.canCarry(weight)) {
                    item.add(weight);
                }
                System.out.println(item.toString());
            }
        }
    }
}

interface Transport {
    boolean canCarry(double weight); //проверяет, может ли объект перевезти заданный груз
    void add(double weight); //добавить груз
    double getTotalWeight(); //возвращает общий груз
}

//  Создайте классы Lorry (грузовик) и Ship (корабль), реализующие интерфейс Transport.
//  Метод toString() этих классов должен отражать название класса, грузоподъемность транспорта и вес нагруженного в данный момент.

class Lorry implements Transport {

    double weight;

    double liftingCapacity;
    double carrying = 0;

    Lorry(double liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(double liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    @Override
    public boolean canCarry(double weight) {
        return liftingCapacity >= weight ? true : false;
    }

    @Override
    public void add(double weight) {
        carrying += weight;
    }

    @Override
    public double getTotalWeight() {
        return carrying;
    }

    @Override
    public String toString() { // должен отражать название класса, грузоподъемность транспорта и вес нагруженного в данный момент.
        return "Lorry" + "{maxWeight=" + getLiftingCapacity() + ", totalWeight=" + getTotalWeight() + "}";
    }
}
class Ship implements Transport {

    double weight;

    double liftingCapacity;
    double carrying = 0;

//    Ship(double weight, double liftingCapacity) {
//        this.weight = weight;
//        this.liftingCapacity = liftingCapacity;
//    }
    Ship(double liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(double liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    @Override
    public boolean canCarry(double weight) {
        return liftingCapacity >= weight ? true : false;
    }

    @Override
    public void add(double weight) {
        carrying += weight;
    }

    @Override
    public double getTotalWeight() {
        return carrying;
    }

    @Override
    public String toString() { // должен отражать название класса, грузоподъемность транспорта и вес нагруженного в данный момент.
        return "Ship" + "{maxWeight=" + getLiftingCapacity() + ", totalWeight=" + getTotalWeight() + "}";
    }
}