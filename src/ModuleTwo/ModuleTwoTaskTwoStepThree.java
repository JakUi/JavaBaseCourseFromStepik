package ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskTwoStepThree {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int mark, counter = 0;
        int bad_mark = 3;
        int bad_marks_total = 0;
        while(counter < 10){
            mark = scan.nextInt();
            if (mark <= bad_mark) {
                bad_marks_total++;
            }
            counter++;
        }
        System.out.println(bad_marks_total);
    scan.close();
    }
}
