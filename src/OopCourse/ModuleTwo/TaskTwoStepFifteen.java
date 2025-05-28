package OopCourse.ModuleTwo;

import java.util.Scanner;


public class TaskTwoStepFifteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Ввести размер массива и создать массив домашних животных.
        int arraySize = scan.nextInt();
        Pet[] gruppa = new Pet[arraySize];
        // Заполнить массив объектами, считав их данные с консоли.
        for (int i = 0; i < arraySize; i++) {
            // В начале каждой строки стоит тип объекта: 1 - собака, 2 - кот.
            int type = scan.nextInt();
            // Далее для собаки следует порода, а для кота - окрас.
            // Затем идут данные, которые отделяются пробелами: кличка и возраст.
            if (type == 1) {
                gruppa[i] = new Dog(scan.next(), scan.nextInt(), scan.next());
            }
            if (type == 2) {
                gruppa[i] = new Cat(scan.next(), scan.nextInt(), scan.next());
            }
        }
        // Выведите список всех домашних животных в массиве. Для каждого животного должно быть выведено название класса,
        // затем пробел и кличка, далее двоеточие и издаваемый звук. Например: Dog Мухтар:Гав-гав!
        for (int j = 0; j < arraySize; j++){
            System.out.print(gruppa[j].getClass().getSimpleName() + " " + gruppa[j].getNickname() + ":");
            gruppa[j].getNoise();
        }
        System.out.println(); // Выведите пустую строку

        //Затем вывести список всех котов в массиве в csv-формате.
        for (int c = 0; c < arraySize; c++){
            if (gruppa[c] instanceof Cat) {
                Cat item = (Cat) gruppa[c]; //преобразование к типу подкласса
                System.out.println(item.toString());
            }
        }
    }
}

abstract class Pet { // Создайте абстрактный класс Pet.
    // Поля: кличка, возраст.
    // Определите конструкторы, геттеры и сеттеры.
    // Переопределите метод  toString() (должен выдавать все поля в csv-формате).
    String nickname;
    int age;

    Pet(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  nickname + ";" + age;
    }

    abstract void getNoise(); // Задайте абстрактный метод void getNoise();
}

class Dog extends Pet {
    String breed;

    Dog(String nickname, int age, String breed){
        super(nickname, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return nickname + ";" + age + ";" + breed;
    }

    @Override
    void getNoise() {
        System.out.println("Гав-гав!");
    }
}

class Cat extends Pet {
    String color;

    public Cat(String nickname, int age, String color) {
        super(nickname, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return nickname + ";" + age + ";" + color;
    }

    @Override
    void getNoise() {
        System.out.println("Мяу-мяу!");
    }
}
