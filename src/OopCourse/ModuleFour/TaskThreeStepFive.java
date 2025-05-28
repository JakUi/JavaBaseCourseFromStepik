package OopCourse.ModuleFour;


import java.util.ArrayList;
import java.util.Scanner;


public class TaskThreeStepFive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Student> adultStudents = new ArrayList<>();
        ArrayList<Student> youngStudents = new ArrayList<>();
        while(true) {
            String buffer = scan.nextLine();
            if ("end".equals(buffer)) break;
            String[] splitted = buffer.split(" ");
            String lastName = splitted[0];
            double averageMark = Double.parseDouble(splitted[1]);
            int age = Integer.parseInt(splitted[2]);
            Student student = new Student(lastName, averageMark, age);
            if (age >= 18) {
                adultStudents.add(student);
            }
            else {
                youngStudents.add(student);
            }
        }
        // Выведите списки студентов на консоль используя метод toString(), переопределенный для коллекций.
        if (youngStudents.isEmpty()) System.out.println("Пустой список");
        else {
            System.out.println(youngStudents.toString());
        }
        if (adultStudents.isEmpty()) System.out.println("Пустой список");
        else {
            System.out.println(adultStudents.toString());
        }
    }
}

class Student {

    String lastName;
    double averageMark;
    int age;

    Student(String lastName, double averageMark, int age){
        this.lastName = lastName;
        this.averageMark = averageMark;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(int averageMark) {
        this.averageMark = averageMark;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return lastName + ";" + averageMark + ";" + age;
    }
}
