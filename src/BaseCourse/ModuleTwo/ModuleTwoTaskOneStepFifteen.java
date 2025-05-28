package BaseCourse.ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskOneStepFifteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String russian_day_name = scan.next();
        String english_day_name = null;
        Boolean output = true;
        switch (russian_day_name) {
            case "Понедельник":
                english_day_name = "Monday";
                break;
            case "понедельник":
                english_day_name = "Monday";
                break;
            case "Вторник":
                english_day_name = "Tuesday";
                break;
            case "вторник":
                english_day_name = "Tuesday";
                break;
            case "Среда":
                english_day_name = "Wednesday";
                break;
            case "среда":
                english_day_name = "Wednesday";
                break;
            case "Четверг":
                english_day_name = "Thursday";
                break;
            case "четверг":
                english_day_name = "Thursday";
                break;
            case "Пятница":
                english_day_name = "Friday";
                break;
            case "пятница":
                english_day_name = "Friday";
                break;
            case "Суббота":
                english_day_name = "Saturday";
                break;
            case "суббота":
                english_day_name = "Saturday";
                break;
            case "Воскресенье":
                english_day_name = "Sunday";
                break;
            case "воскресенье":
                english_day_name = "Sunday";
                break;
            default:
                System.out.println("ERROR");
                output = false;
        }
        if (output) {
            System.out.println(english_day_name);
        }
        scan.close();
    }
}
