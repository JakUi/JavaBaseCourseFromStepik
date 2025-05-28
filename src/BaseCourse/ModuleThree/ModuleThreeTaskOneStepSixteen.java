package BaseCourse.ModuleThree;

import java.util.Scanner;

class ModuleThreeTaskOneStepSixteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        double z = scan.nextDouble();
        System.out.printf("%.2f %.2f\n", average(a, b), average(a, b, c));
        System.out.printf("%.2f %.2f\n", average(x, y),average(x, y, z));
    }
   // Есть 2 варианта решения: можно оставить все 4 метода (закомментирован код) или только 2 метода
    static double average(double x, double y) {
        return (x + y) / 2;
    }
    static double average(double x, double y, double z) {
        return (x + y + z) / 3;
    }
//    static double average(int a, int b) {
//
//        return ((double) a + (double) b) / 2;
//    }
//    static double average(int a, int b, int c) {
//        return ((double) a + (double) b + (double) c) / 3;
//    }
}
