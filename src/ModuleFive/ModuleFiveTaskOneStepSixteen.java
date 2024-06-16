package ModuleFive;

import java.util.Scanner;


class ModuleFiveTaskOneStepSixteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str = str.trim(); //удаляем пробелы в начале и в конце
        String[] words = str.split(" ");
        String with_capital = "";
        String result_string = "";
        for (String word:words) {
            with_capital = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            result_string += with_capital;
            result_string += " ";
        }
        result_string.trim();
        System.out.println(result_string);
    }
}
