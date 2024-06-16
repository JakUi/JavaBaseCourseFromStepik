package ModuleFive;

import java.util.Scanner;


class ModuleFiveTaskOneStepFifteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String control_word = scan.nextLine();
        str = str.trim(); //удаляем пробелы в начале и в конце
        String[] words = str.split(" +");
        String result_string = "";
        for (String word:words){
            if (word.equals(control_word)) {
                continue;
            }
            else {
                result_string += word;
                result_string += " ";
            }
        }
        result_string = result_string.trim();
        System.out.println(result_string);
    }
}
