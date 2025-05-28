package OopCourse.ModuleOne;

import java.util.Scanner;

public class TaskTwoStepFive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Employee person = new Employee();
        person.surname = scan.next();
        person.sex = scan.next();
        person.age = scan.nextInt();
        person.salary = scan.nextInt();
        person.changeSalary(person.koef);
        person.show();
    }

}

class Employee {

    String surname;
    String sex;
    int age;
    int salary;
    static double koef = 0.9;


    boolean isPensioner(String sex, int age) {
        boolean isPensioner = false;
        if (sex.equals("female")) {
            if (age >= 58) {
                isPensioner = true;
            }
        } else if (sex.equals("male")) {
            if (age >= 63) {
                isPensioner = true;
           }
        }
        return isPensioner;
    }

    void changeSalary(double koef) {
        if (isPensioner(sex, age)) {
            salary = (int)(salary * 0.9);
        }
    }

    void show() {
        StringBuilder employeeData = new StringBuilder();
        employeeData.append(surname).append(";").append(sex).append(";").append(age).append(";").append(salary);
        System.out.println(employeeData);
    }
}
