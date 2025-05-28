package OopCourse.ModuleTwo;

import java.util.Scanner;


public class TaskTwoStepSix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student.setBaseScholarship(scan.nextInt()); // Ввести базовый размер стипендии и задать его в классе Student
        int arraySize = scan.nextInt();
        Learner[] gruppa = new Learner[arraySize];
        // Заполнить массив учащихся объектами, считав их данные с консоли.
        for (int i = 0; i < arraySize; i++) {
            // Данные каждого учащегося вводятся с новой строки, вначале которого стоит тип объекта: 1 - школьник, 2 - студент.
            int type = scan.nextInt();
            // Затем идут данные, которые отделяются пробелами: фамилия, оценка 1, оценка 2.
            // Далее для школьника следует название школы и название класса, а для студента - название ВУЗа и группы.
            if (type == 1) {
                gruppa[i] = new Schoolboy(scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next());
            }
            if (type == 2) {
                gruppa[i] = new Student(scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next());
            }
        }
        // Выведите список всех учащихся и продолжительность каникул каждого
        for (int j = 0; j < arraySize; j++){
            System.out.println(gruppa[j] + " " + "каникулы: " + gruppa[j].vacations());
        }
        // С новой строки выведите средний балл успеваемости для всех учащихся в массиве (дробная часть этого значения должна иметь один знак).
        double totalAverageGrade = 0;
        for (int a = 0; a < arraySize; a++) {
            totalAverageGrade += gruppa[a].averageGrade();
        }
        double number = totalAverageGrade /  arraySize;
        System.out.printf("%.1f%n", number);

        // Выведите список студентов
        int scholarshipSum = 0;
        boolean anyStudens = false;
        for (int s = 0; s < arraySize; s++){
            if (gruppa[s] instanceof Student) {
                Student item = (Student) gruppa[s]; //преобразование к типу подкласса
                scholarshipSum += item.calculateScholarship();
                anyStudens = true;
                System.out.println(item.toString());
            }
        }
        if (anyStudens != false) {
            System.out.println(scholarshipSum);
        }
        if (anyStudens == false) {
            // Если в массиве нет студентов, то нужно напечатать "NO", и больше ничего не выводить.
            System.out.println("NO");
        }
    }
}

abstract class Learner { //    Создайте абстрактный класс Learner (Учащийся)
    String lastName;
    int grade1;
    int grade2;

    Learner(String lastName, int grade1, int grade2) {
        this.lastName = lastName;
        this.grade1 = grade1;
        this.grade2 = grade2;
    }
    Learner() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade1() {
        return grade1;
    }

    public void setGrade1(int grade1) {
        this.grade1 = grade1;
    }

    public int getGrade2() {
        return grade2;
    }

    public void setGrade2(int grade2) {
        this.grade2 = grade2;
    }

    public double averageGrade(){
        double average = (grade1 + grade2) / 2.; // метод для подсчета среднего балла
        return average;
    }

    abstract int vacations(); // абстрактный метод «каникулы», который возвращает общую продолжительность каникул в году.

}

class Schoolboy extends Learner {
    String school;
    String schoolClass;

    Schoolboy(String lastName, int grade1, int grade2, String school, String schoolClass){
        super(lastName, grade1, grade2);
        this.school = school;
        this.schoolClass = schoolClass;
    }

    Schoolboy(){
        super();
    }

    @Override
    int vacations() {
        return 124;
    }

    @Override
    public String toString() {
        return lastName + ";" + grade1 + ";" + grade2 + ";" + school + ";" + schoolClass;
    }
}
class Student extends Learner {
    String HIE;
    String group;
    static int  baseScholarship;  // статическое поле «базовый размер стипендии»

    Student(String lastName, int grade1, int grade2, String HIE, String group){
        super(lastName, grade1, grade2);
        this.HIE = HIE;
        this.group = group;
    }

    Student(){
        super();
    }

    public String getHIE() {
        return HIE;
    }

    public void setHIE(String HIE) {
        this.HIE = HIE;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public static int getBaseScholarship() {
        return baseScholarship;
    }

    public static void setBaseScholarship(int baseScholarship) {
        Student.baseScholarship = baseScholarship;
    }

    public int calculateScholarship(){
        if(averageGrade() >= 9){
            return (int)(baseScholarship * 1.6);
        }else if(averageGrade() >= 8){
            return (int)(baseScholarship * 1.4);
        }else if(averageGrade() >= 6){
            return (int)(baseScholarship * 1.2);
        }else if(averageGrade() >= 5){
            return baseScholarship;
        }else{
            return 0;
        }
    }

    @Override
    int vacations() {
        return 74;
    }

    @Override
    public String toString() {
        return lastName + ";" + grade1 + ";" + grade2 + ";" + HIE + ";" + group;
    }
}
