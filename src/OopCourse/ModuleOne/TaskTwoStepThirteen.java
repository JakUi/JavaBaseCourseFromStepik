package OopCourse.ModuleOne;

import java.util.Scanner;

public class TaskTwoStepThirteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arraySize = scan.nextInt();
        if (arraySize < 0) {
            System.out.println("ERROR");
            return;
        }
        EmployeeModified[] employeesList = new EmployeeModified[arraySize];
        for (int i = 0; i < arraySize; i++){
            employeesList[i] = new EmployeeModified(scan.next(), scan.next(), scan.nextInt(), scan.nextInt());
        }
        for (int j = 0; j < arraySize; j++){
            employeesList[j].show();
        }
    }
}

class EmployeeModified {

    public EmployeeModified(){
    }
    public EmployeeModified(String surname,  String sex, int age, int salary) {
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        if (this.sex.equals("male") && this.age >= 67) {
            this.salary = 90000;
        } else if (this.sex.equals("female") && this.age >= 59) {
            this.salary = 90000;
        } else {
            this.salary = salary;
        }
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSex (String sex) {
        this.sex = sex;
    }
    public void setAge (int age) {
        this.age = age;
    }
    public void setPension (int salary) {
        this.salary = salary;
    }
    public String getSurname () {
        return surname;
    }
    public String getSex () {
        return sex;
    }
    public int getAge () {
        return age;
    }
    public int getPension () {
        return salary;
    }

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

    void changepension(double koef) {
        if (isPensioner(sex, age)) {
            salary = (int)(salary* 0.9);
        }
    }

    void show() {
        StringBuilder employeeData = new StringBuilder();
        employeeData.append(surname).append(";").append(sex).append(";").append(age).append(";").append(salary);
        System.out.println(employeeData);
    }
}
