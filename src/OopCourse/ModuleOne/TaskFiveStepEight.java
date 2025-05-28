package OopCourse.ModuleOne;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Locale;

public class TaskFiveStepEight {
    public static void main(String[] args) {
        String brand;
        String owner;
        double volume;
        int yearOfMade = 0;
        int arraySize;
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        arraySize = scan.nextInt();
        Car[] gruppa = new Car[arraySize];
        for (int i = 0; i < arraySize; i++) {
            brand = scan.next();
            owner = scan.next();
            volume = scan.nextDouble();
            yearOfMade = scan.nextInt();
            gruppa[i] = new Car(brand, owner, volume, yearOfMade);
        }
        // Ввести порядковый номер  автомобиля (номер считается с 1) и объем  двигателя
        int carNumber = scan.nextInt();
        double newVolume = scan.nextDouble();
        gruppa[carNumber - 1].setVolume(newVolume); // Изменить данные об этом автомобиле в массиве, задав сеттером этот новый объем двигателя
        for (int j = 0; j < arraySize; j++) { // Вывести массив на консоль с использованием метода toString( )
            System.out.println(gruppa[j].toString());
        }
        System.out.println();

        int newestCarAge = gruppa[0].getLife(gruppa[0].yearOfMade);
        int index = 0;
        for (int k = 1; k < arraySize; k++) {
            int age = gruppa[k].getLife(gruppa[k].yearOfMade);
            if (newestCarAge > age) {
                newestCarAge = age;
                index = k;
            };
        }
        System.out.println(gruppa[index]);
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
        Calendar cal = Calendar.getInstance(); //не забыть импортировать класс java.util.Calendar!
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