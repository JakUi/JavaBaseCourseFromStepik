package BaseCourse.ModuleFive;

import java.util.Scanner;


class ModuleFiveTaskOneStepEleven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if (isGMailAddress(str)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean isGMailAddress(String str){
        String[] splitedByDomain = str.trim().split("@gmail.com");
        String[] splitedBySign = str.trim().split("@");
        boolean result;
        if(splitedByDomain.length == 1){
            if(splitedBySign.length == 2){
                result = true;
            }
            else {
                result = false;
            }
        }
        else {
            result = false;
        }
        return result;
    }
}
