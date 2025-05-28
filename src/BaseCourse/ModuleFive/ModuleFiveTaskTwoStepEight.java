package BaseCourse.ModuleFive;


import java.util.Scanner;


class ModuleFiveTaskTwoStepEight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        String str = primer(a, b);
        System.out.println(str);
    }

    static String primer(int a, int b){
        String a_str = String.valueOf(a);
        String b_str = String.valueOf(b);
        int sum = a + b;
        StringBuilder output = new StringBuilder();
        output.append(a_str).append(" + ").append(b_str).append(" = ").append(sum);
        return output.toString();
    }
}
