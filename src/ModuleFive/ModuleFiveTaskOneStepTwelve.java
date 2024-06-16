package ModuleFive;

import java.util.Scanner;


class ModuleFiveTaskOneStepTwelve {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(checkAndReturnSub(str));
    }

    static String checkAndReturnSub(String str) {
        String[] mas = str.trim().split(".com$");
        return mas[0];
    }
}
