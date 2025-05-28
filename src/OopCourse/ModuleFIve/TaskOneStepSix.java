package OopCourse.ModuleFIve;

import java.util.Scanner;

public class TaskOneStepSix {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        CelestialBody[] bodies = new CelestialBody[6];
        for (int i = 0; i < bodies.length; i++) {
            bodies[i] = initCelestialBody();
        }
        if (bodies[0] == bodies[3] && bodies[1] == bodies[2] && bodies[4] == bodies[5]) {
            System.out.println("Ok");
        } else {
            System.out.println("Error");
        }
    }
    static CelestialBody initCelestialBody(){
        // В классе Main создайте статический метод initCelestialBody().
        // Этот метод считывает строку с консоли и создает соответствующий объект класса Sun, Moon или Earth, ссылку на который возвращает в качестве результата своей работы.
        // Если введено другое слово – возвращается null.
        String bodyName = scan.next();
        CelestialBody body = null;
        if (bodyName.equals("Sun")){
            body = Sun.getInstance();
        } else if (bodyName.equals("Moon")) {
            body = Moon.getInstance();
        } else if (bodyName.equals("Earth")) {
            body = Earth.getInstance();
        }
        return body;
    }
}

interface CelestialBody {
};

class Sun implements CelestialBody {
    private static Sun uniqueInstance; //ссылка на единственный экземпляр класса
    private Sun() { //приватный конструктор недоступен в других классах
    }
    public static Sun getInstance() {
        if (uniqueInstance == null) { //если экземпляр класса еще не создан
            uniqueInstance = new Sun(); //создаем объект класса
        }
        return uniqueInstance; //возвращаем ссылку на единственный объект
    }
}

class Moon implements CelestialBody {
    private static Moon uniqueInstance; //ссылка на единственный экземпляр класса
    private Moon() { //приватный конструктор недоступен в других классах
    }
    public static Moon getInstance() {
        if (uniqueInstance == null) { //если экземпляр класса еще не создан
            uniqueInstance = new Moon(); //создаем объект класса
        }
        return uniqueInstance; //возвращаем ссылку на единственный объект
    }
}

class Earth implements CelestialBody {
    private static Earth uniqueInstance; //ссылка на единственный экземпляр класса
    private Earth() { //приватный конструктор недоступен в других классах
    }
    public static Earth getInstance() {
        if (uniqueInstance == null) { //если экземпляр класса еще не создан
            uniqueInstance = new Earth(); //создаем объект класса
        }
        return uniqueInstance; //возвращаем ссылку на единственный объект
    }
}
