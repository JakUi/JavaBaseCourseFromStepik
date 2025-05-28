package OopCourse.ModuleOne;

import java.util.Scanner;

public class TaskTwoStepSix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Abiturient person = new Abiturient();
        person.surname = scan.next();
        person.name = scan.next();
        person.math = scan.nextInt();
        person.physics = scan.nextInt();
        person.lang = scan.nextInt();
        System.out.printf("%.1f\n", person.average());
        person.print();
    }
}

class Abiturient {
    static String surname;
    static String name;
    static int math;
    static int physics;
    static int lang;

    static double average(){
        double averageGrade;
        double doubleMath = math;
        double doublePhysics = physics;
        double doubleLang = lang;
        averageGrade = (doubleMath + doublePhysics + doubleLang) / 3;
        return averageGrade;
    }
    public void print(){
        StringBuilder studentInfo = new StringBuilder();
        studentInfo.append(surname + " " + name + " ").append("математика = " + math + " ");
        studentInfo.append("физика = " + physics + " ").append("язык = " + lang + " ").append("средний балл = ");
        System.out.print(studentInfo);
        System.out.printf("%.1f\n", average());
    }
}
