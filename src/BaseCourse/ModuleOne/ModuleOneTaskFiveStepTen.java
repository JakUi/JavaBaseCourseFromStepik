package BaseCourse.ModuleOne;

import java.util.Scanner;

class ModuleOneTaskFiveStepTen {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int FirstSalary;
        int SecondSalary;
        int ThirdSalary;
        FirstSalary = scan.nextInt();
        SecondSalary = scan.nextInt();
        ThirdSalary = scan.nextInt();
        int max = FirstSalary>SecondSalary?FirstSalary:SecondSalary;
        int max2 = max>ThirdSalary?max:ThirdSalary;
        int min = FirstSalary<SecondSalary?FirstSalary:SecondSalary;
        int min2 = min<ThirdSalary?min:ThirdSalary;
        System.out.println(max2 - min2);
        scan.close();
    }
}
