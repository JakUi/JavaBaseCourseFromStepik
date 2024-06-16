package ModuleFive;

import java.util.Scanner;


class ModuleFiveTaskOneStepFourteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str = str.trim(); //удаляем пробелы в начале и в конце
        String[] words = str.split(" +"); //формируем массив слов без пробелов
        int max_length = words[0].length();
        String longest_word = words[0];
        for (String word:words) {
            if (max_length < word.length()) {
                longest_word = word;
                max_length = word.length();
            }
        }
        System.out.println(longest_word);
    }
}
