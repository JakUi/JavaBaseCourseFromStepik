package OopCourse.ModuleOne;

import java.util.Scanner;

public class TaskFourStepTwelve {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        if (size < 0) {
            System.out.println("ERROR");
            return;
        }
        ChangedBusinessTrip[] gruppa = new ChangedBusinessTrip[size];
        for (int i = 0; i < gruppa.length - 1; i++) {
            String surname = scan.next();
            int days = scan.nextInt();
            int transportSpents = scan.nextInt();
            gruppa[i] = new ChangedBusinessTrip(surname, days, transportSpents);
//            gruppa[i].printTotal();
        }
        gruppa[size - 1] = new ChangedBusinessTrip(gruppa[0]); //использование конструктора клонирования
        scan.skip("\n");
        gruppa[0].setSurname(scan.next()); // Изменить фамилию в командировке с индексом 0, считав данные с консоли.
        //  Вывести список всех командировок в csv-формате. Затем вывести пустую строку
        for (int j = 0; j < gruppa.length; j++) {
            System.out.println(gruppa[j].toString());
        }
        System.out.println();
        int bTripIndex = scan.nextInt(); //Ввести с консоли индекс командировки (корректность не проверяем)
        // Вывести в csv - формате все командировки, которые считаются равными элементу массива с этим индексом (включая и сам этот элемент).
        // Вы ввели с консоли индекс командировки. Потом взяли элемент из списка с этим индексом trips[index].
        // Перебираете весь массив, и как только находите командировку, равную trips[index] - выводите ее.
        // Проверка на равенство, естественно, через equals().
        for (int k = 0; k < gruppa.length; k++) {
            if (gruppa[k].equals(gruppa[bTripIndex])) {
                System.out.println("yes");
                System.out.println(gruppa[k].toString());
            }
        }
    }
}

class ChangedBusinessTrip {
//    Сделайте все поля приватными согласно принципу инкапсуляции. А методы сделайте публичными.
    private final static int DAILY = 25;
    private String surname;
    private int transportsSpents;
    private int days;

    public void prin() {
        System.out.println(surname + " " + transportsSpents);
    }
    public ChangedBusinessTrip(String surname, int days, int transportsSpents) {
        this.surname = surname;
        this.days = days;
        this.transportsSpents = transportsSpents;
    }
    public ChangedBusinessTrip(String surname, int transportsSpents) {
        this.surname = surname;
        this.transportsSpents = transportsSpents;
        this.days = 0; // В случае отсутствия дней, их значение должно быть 0
    }
    public ChangedBusinessTrip(String surname) {
        this.surname = surname;
        this.transportsSpents = 0; // Если транспортные расходы не указаны, значение по умолчанию 0
        this.days = 0; // Дни тоже по умолчанию 0
    }

    public String getSurname() {
        return surname;
    }

    public int getTransportsSpents() {
        return transportsSpents;
    }

    public int getDays() {
        return days;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTransportsSpents(int transportsSpents) {
        this.transportsSpents = transportsSpents;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public ChangedBusinessTrip(ChangedBusinessTrip trip) {  // Создайте четвертый конструктор клонирования.
        this.surname = trip.surname;
        this.days = trip.days;
        this.transportsSpents = trip.transportsSpents;
    }

    public int getTotal() {
        return transportsSpents + days * DAILY;
    }

    public void printTotal() {
        int totalSpent = getTotal();
        System.out.println(totalSpent);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ChangedBusinessTrip another = (ChangedBusinessTrip) obj;
        return this.getTotal() == another.getTotal();
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(getTotal());
    }
    @Override
    public String toString() {
        return surname + ";" + days + ";" + transportsSpents + ";" + getTotal();
    }
}
