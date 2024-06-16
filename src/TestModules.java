import java.util.Scanner;

public class TestModules {
    public static void main(String[] args) {
//        int number;
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Введите номер дня недели: ");
//        number=scanner.nextInt();
//        switch(number){
//            case 1:
//                System.out.println("Понедельник");
//                break;
//            case 2:
//                System.out.println("Вторник");
//                break;
//            case 3:
//                System.out.println("Среда");
//                break;
//            case 4:
//                System.out.println("Четверг");
//                break;
//            case 5:
//                System.out.println("Пятница");
//                break;
//            case 6:
//                System.out.println("Суббота");
//                break;
//            case 7:
//                System.out.println("Воскресенье");
//                break;
//            default:
//                System.out.println("В неделе всего семь дней!");
//        }
        String result = String.format("Жили у бабуси %d веселых гуся", 2);
        System.out.println(result);
        double x = 3.1415;
        String out = String.format("x=%6.3f", x);
        System.out.println(out);
    }
}