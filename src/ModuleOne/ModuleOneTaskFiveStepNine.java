package ModuleOne;

import java.util.Scanner;

class ModuleOneTaskFiveStepNine {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int Rubley;
        int Kopeek;
        System.out.println("Введите сумму в рублях");
        Rubley = scan.nextInt();
        System.out.println("Введите сумму в копейках");
        Kopeek = scan.nextInt();
        System.out.println(Kopeek<100?Rubley+" р."+Kopeek+" к.":Rubley+Kopeek/100+" р."+Kopeek%100+" к.");
        scan.close();
    }
}
