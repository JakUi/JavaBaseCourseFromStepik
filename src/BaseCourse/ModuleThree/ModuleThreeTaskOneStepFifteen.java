package BaseCourse.ModuleThree;

import java.util.Scanner;

class ModuleThreeTaskOneStepFifteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sides = scan.nextInt();
        double rectangle_side_a = scan.nextDouble();
        double square = 0;
        if (sides == 1) {
            square = figureSquare(rectangle_side_a);
        }
        else if (sides == 2) {
            double rectangle_side_b = scan.nextDouble();
            square = figureSquare(rectangle_side_a, rectangle_side_b);
        }
        System.out.printf("%.2f", square);
    }

    static double figureSquare(double rectangle_side_a) {
        return rectangle_side_a * rectangle_side_a;
    }
    static double figureSquare(double rectangle_side_a, double rectangle_side_b) {
        return rectangle_side_a * rectangle_side_b;
    }
}
