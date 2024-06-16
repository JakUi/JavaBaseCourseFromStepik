package ModuleFive;


import java.util.Scanner;


class ModuleFiveTaskTwoStepSeven {
    public static void main(String[] args) {
        String data;
        Scanner scan = new Scanner(System.in);
        data = scan.nextLine();
        data = data.trim();
        String[] words = data.split(" +"); //разделение на слова
        StringBuilder result = new StringBuilder();
        StringBuilder used_words = new StringBuilder();
        char last_symbol;
        result.append(words[0]);  // Первое слово не меняет позицию
        used_words.append(words[0]);
        last_symbol = result.charAt(result.length() - 1);
        for (int k = 0; k < words.length; k++) {
            for (String word:words) {
                if (word.charAt(0) == last_symbol) {
                    if (used_words.indexOf(word) < 0) {
                        result.append(" ").append(word);
                        used_words.append(word);
                        last_symbol = result.charAt(result.length() - 1);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
