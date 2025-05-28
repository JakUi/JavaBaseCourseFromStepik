package BaseCourse.ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskOneStepSixteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        short day_number = scan.nextShort();
        String day = null;
        Boolean output = true;
        switch (day_number) {
            case 1:
                day = "Working day";
                break;
            case 2:
                day = "Working day";
                break;
            case 3:
                day = "Working day";
                break;
            case 4:
                day = "Working day";
                break;
            case 5:
                day = "Working day";
                break;
            case 6:
                day = "Saturday";
                break;
            case 7:
                day = "Sunday";
                break;
            default:
                System.out.println("ERROR");
                output = false;
        }
        if (output) {
            System.out.println(day);
        }
        scan.close();
    }
}
