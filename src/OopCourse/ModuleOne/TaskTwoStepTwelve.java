package OopCourse.ModuleOne;

import java.util.Scanner;

public class TaskTwoStepTwelve {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AbiturientModified[] list = new AbiturientModified[3];
        list[0] = new AbiturientModified();
        list[1] = new AbiturientModified("Петров", "Андрей", 90, 70, 80);
        list[2] = new AbiturientModified("Алексиевич", "Анна");
        list[0].setSurname(scan.next());
        list[2].setPhysics(scan.nextInt());
        list[2].setMath(scan.nextInt());
        list[2].setLang(scan.nextInt());
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                System.out.printf("%s : %.1f\n", list[i].getSurname(), list[i].average());
            }
        }
    }
}

class AbiturientModified {

    public AbiturientModified(){
    }
    public AbiturientModified(String surname, String name, int math, int physics, int lang) {
        this.surname = surname;
        this.name = name;
        this.math = math;
        this.physics = physics;
        this.lang = lang;
    }

    public AbiturientModified(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhysics (int physics) {
        this.physics = physics;
    }
    public void setMath (int math) {
        this.math = math;
    }
    public void setLang (int lang) {
        this.lang = lang;
    }
    public String getSurname () {
        return surname;
    }
    private String surname;
    private String name;
    private int math;
    private int physics;
    private int lang;

     public double average(){
        double averageGrade;
        double doubleMath = math;
        double doublePhysics = physics;
        double doubleLang = lang;
        averageGrade = (doubleMath + doublePhysics + doubleLang) / 3;
        return averageGrade;
    }
}