package OopCourse.ModuleTwo;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class TaskOneStepFifteen {
    public static void main(String[] args) {
        int carTypeIndex;
        String brand;
        String owner;
        double volume;
        int yearOfMade = 0;
        float capacity;
        int arraySize;
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        arraySize = scan.nextInt();
        Car[] gruppa = new Car[arraySize]; // Ввести количество элементов массива и создать массив ссылочных переменных типа Car соответствующего размера.
        for (int i = 0; i < arraySize; i++) {
            carTypeIndex = scan.nextInt();
            brand = scan.next();
            owner = scan.next();
            volume = scan.nextDouble();
            yearOfMade = scan.nextInt();
            if (carTypeIndex == 1) {
                gruppa[i] = new Car(brand, owner, volume, yearOfMade);
            } else if (carTypeIndex == 2) {
                capacity = scan.nextFloat();
                gruppa[i] =  new Truck(brand, owner, volume, yearOfMade, capacity);
            }
        }
        double weight = scan.nextDouble();
        for (int j = 0; j < arraySize; j++) { // Вывести массив на консоль с использованием метода toString( )
            System.out.println(gruppa[j].toString());
        }
        System.out.println();

        // Введите вес груза в отдельную переменную, и выведите список всех грузовиков, которые могут перевезти этот вес,
        // и при этом имеют возраст не старше 6 лет. Если подходящих автомобилей нет, выведите "NO".
        boolean truckFound = false;
        for (int k = 0; k < gruppa.length; k++) {
            if (gruppa[k] instanceof Truck) {
                Truck item = (Truck) gruppa[k]; //преобразование к типу подкласса
                if (item.ifCanCarry(weight) == true) {
                    int age = gruppa[k].getLife(gruppa[k].yearOfMade);
                    if (age <= 6) {
                        truckFound = true;
                        System.out.println(gruppa[k].toString());
                    }
                }
            }
        }
        if (truckFound == false) {
            System.out.println("NO");
        }
    }
}

class Car {
    String brand;
    String owner;
    double volume;
    int yearOfMade;
    static int yearNow;
    public Car(String brand, String owner, double volume, int yearOfMade) {
        this.brand = brand;
        this.owner = owner;
        this.volume = volume;
        this.yearOfMade = yearOfMade;
    }
    public Car(){
        brand = "";
        owner = "";
        volume = 0.0;
        yearOfMade = 0;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
    public void setyearOfMade(int yearOfMade) {
        this.yearOfMade = yearOfMade;
    }
    public static void setYearNow(int yearNow) {
        Car.yearNow = yearNow;
    }
    public static int getCurrentYear() {
        return Car.yearNow;
    }
    static {
        Calendar cal = Calendar.getInstance();
        yearNow = cal.get(Calendar.YEAR);
    }
    public int getLife(int yearOfMade) {
        int age = 0;
        age = Car.yearNow - yearOfMade;
        return age;
    }
    @Override
    public String toString() {
        return "Car{brand=" + "'" +brand + "'" + ", owner=" + "'" + owner + "'" + ", volume=" + volume + ", yearOfMade=" + yearOfMade + "}";
    }
}

class Truck extends Car {
    float capacity;
    public Truck(String brand, String owner, double volume, int yearOfMade, float capacity) {
        super(brand, owner, volume, yearOfMade);
        this.capacity = capacity;
    }

    public Truck(float capacity) {
        this.capacity = capacity;
    }

    public float getcapacity() {
        return capacity;
    }

    public void setcapacity(float capacity) {
        this.capacity = capacity;
    }

    public boolean ifCanCarry(double weight) { // возвращает true, если грузовик может перевести груз указанного веса.
        boolean canCarry = false;
        if (capacity >= weight) {
            canCarry = true;
        }
        return canCarry;
    }

    @Override
    public String toString() {
        return "Truck{" + "brand=" + "'" + brand + "', " + "owner=" + "'" + owner + "', " + "volume=" + volume + ", "
                + "yearOfMade=" + yearOfMade + ", " + "capacity=" + getcapacity() + "}";
    }
}