package OopCourse.ModuleTwo;

import java.util.Scanner;
import java.util.HashSet;


public class TaskOneStepSixteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arraySize = scan.nextInt();
        if (arraySize < 0) {
            System.out.println("ERROR");
            return;
        }
        int employeeType;
        String surname;
        String sex;
        int age;
        int salary;
        String status;
        String specialization;
        String gruppaString;
        char gruppa;
        HashSet<String> statusHashSet = new HashSet<String>();
        HashSet<String> specializationHashSet = new HashSet<String>();
        HashSet<String> gruppaHashSet = new HashSet<String>();
        statusHashSet.add("junior");
        statusHashSet.add("middle");
        statusHashSet.add("senior");
        specializationHashSet.add("frontend");
        specializationHashSet.add("backend");
        specializationHashSet.add("fullstack");
        specializationHashSet.add("mobile");
        gruppaHashSet.add("A");
        gruppaHashSet.add("B");
        gruppaHashSet.add("C");
        gruppaHashSet.add("D");
        gruppaHashSet.add("E");
        EmployeeModified[] employeesList = new EmployeeModified[arraySize];
        for (int i = 0; i < arraySize; i++) {
            employeeType = scan.nextInt();
            //  Первым числом идет тип сотрудника (1 - тип Employee, 2 - тип Programmer, 3 - тип Accountant).
            surname = scan.next();
            sex = scan.next();
            age = scan.nextInt();
            salary = scan.nextInt();
            if (employeeType == 1) {
                employeesList[i] = new EmployeeModified(surname, sex, age, salary);
            }
            if (employeeType == 2) {
                status = scan.next();
                if (statusHashSet.contains(status) == false) {
                    System.out.println(1);
                    return;
                }
                specialization = scan.next();
                if (specializationHashSet.contains(specialization) == false) {
                    return;
                }
                employeesList[i] = new Programmer(surname, sex, age, salary, status, specialization);
            }
            if (employeeType == 3) {
                gruppaString = scan.next();
                gruppa = gruppaString.charAt(0);
//                if (gruppaHashSet.contains(gruppa) == false) { // почему-то не работает)
//                    System.out.println("\n" + gruppa);
//                    return;
//                }
                employeesList[i] = new Accountant(surname, sex, age, salary, gruppa);
            }
        }
        // Выведите массив на консоль, каждый элемент с новой строки (используйте  метод show()).
        for (int j = 0; j < arraySize; j++) {
            employeesList[j].show();
        }
        // Рассчитайте общий фонд заработной платы на месяц (сумму зарплат всех сотрудников) и выведите ее с новой строки.
        int totalMonthlySalary = 0;
        for (int k = 0; k < arraySize; k++) {
            if (employeesList[k] instanceof EmployeeModified) {
                EmployeeModified item = (EmployeeModified) employeesList[k]; //преобразование к типу подкласса
                totalMonthlySalary += employeesList[k].getSalary();
            }
        }
        System.out.println(totalMonthlySalary);
        // Найдите сотрудника с самой большой зарплатой и выведите информацию о нем с новой строки методом show().
        // Если таких человек несколько, то выводим данные только первого из них (первый максимум).
        int theBiggestSalary = 0;
        int index = 0;
        if (employeesList[0] instanceof EmployeeModified) {
            EmployeeModified item = (EmployeeModified) employeesList[0]; //преобразование к типу подкласса
            theBiggestSalary = employeesList[0].getSalary();
        }
        for (int l = 1 ; l < arraySize; l++) {
            if (employeesList[l] instanceof EmployeeModified) {
                EmployeeModified item = (EmployeeModified) employeesList[l]; //преобразование к типу подкласса
                if (theBiggestSalary < employeesList[l].getSalary()) {
                    theBiggestSalary = employeesList[l].getSalary();
                    index = l;
                }
            }
        }
        employeesList[index].show();
        // Пропустите строку, а затем сформируйте команду программистов для frontend - разработки.
        // Выведите список сотрудников на консоль. Также используйте метод show(). Если нужных сотрудников нет, то выведите "NO".
        System.out.println();
        boolean haveFrontenders = false;
        for (int f = 0 ; f < arraySize; f++) {
            if (employeesList[f] instanceof Programmer) {
                Programmer item = (Programmer) employeesList[f]; //преобразование к типу подкласса
                if (item.getSpecialization().equals("frontend")) {
                    haveFrontenders = true;
                    item.show();
                }
            }
        }
        if (haveFrontenders == false) {
            System.out.println("NO");
        }
    }
}

class EmployeeModified {
    public EmployeeModified() {
        }

        public EmployeeModified(String surname, String sex, int age, int salary) {
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

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setPension(int salary) {
            this.salary = salary;
        }

        public String getSurname() {
            return surname;
        }

        public String getSex() {
            return sex;
        }

        public int getAge() {
            return age;
        }

        public int getPension() {
            return salary;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
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
                salary = (int) (salary * 0.9);
            }
        }

        void show() {
            StringBuilder employeeData = new StringBuilder();
            employeeData.append(surname).append(";").append(sex).append(";").append(age).append(";").append(salary);
            System.out.println(employeeData);
        }
    }
    class Programmer extends EmployeeModified {
        String status; // может принимать значения: junior, middle, senior.
        String specialization; // может принимать значения: frontend, backend, fullstack, mobile.

        public Programmer(String surname, String sex, int age, int salary, String status, String specialization) {
            super(surname, sex, age, salary);
            this.status = status;
            this.specialization = specialization;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSpecialization() {
            return specialization;
        }

        public void setSpecialization(String specialization) {
            this.specialization = specialization;
        }

        @Override
        void show() { // Переопределите метод show так, чтобы в конце строки стоял статус программиста
            StringBuilder employeeData = new StringBuilder();
            employeeData.append(surname).append(";").append(sex).append(";").append(age).append(";").append(salary).append(";").append(status);
            System.out.println(employeeData);
        }
    }

    class Accountant extends EmployeeModified {
        char gruppa;

        public Accountant(String surname, String sex, int age, int salary, char gruppa) {
            super(surname, sex, age, salary);
            this.gruppa = gruppa;
        }

        public char getGruppa() {
            return gruppa;
        }

        public void setGruppa(char gruppa) {
            this.gruppa = gruppa;
        }

        @Override
        void show() { // Переопределите метод show так, чтобы в конце строки стояла группа профстандарта
            StringBuilder employeeData = new StringBuilder();
            employeeData.append(surname).append(";").append(sex).append(";").append(age).append(";").append(salary).append(";").append(gruppa);
            System.out.println(employeeData);
        }
    }

