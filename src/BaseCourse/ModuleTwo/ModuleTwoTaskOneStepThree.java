package BaseCourse.ModuleTwo;

import java.util.Scanner;


class ModuleTwoTaskOneStepThree {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        double x1;
        double y1;
        double x2;
        double y2;
        double distance_to_point_one;
        double distance_to_point_two;
        x1 = scan.nextDouble();
        y1 = scan.nextDouble();
        x2 = scan.nextDouble();
        y2 = scan.nextDouble();
//        x1 = 3.5;
//        y1 = -1.5;
//        x2 = 2;
//        y2 = 4.8;
        distance_to_point_one = Math.sqrt(Math.pow(x1,2) + Math.pow(y1, 2));
        distance_to_point_two = Math.sqrt(Math.pow(x2,2) + Math.pow(y2, 2));
        if (distance_to_point_one < distance_to_point_two){
            System.out.println("Первая точка ближе");
        }
        else if (distance_to_point_one > distance_to_point_two){
            System.out.println("Вторая точка ближе");
        }
        else{
            System.out.println("Точки на равных расстояниях");
        }
//        distance_to_point_x = dist
        System.out.printf("%02.4f", distance_to_point_one);
        scan.close();
    }
}
