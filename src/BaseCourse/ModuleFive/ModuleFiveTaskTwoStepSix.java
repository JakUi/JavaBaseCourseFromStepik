package BaseCourse.ModuleFive;

import java.util.Scanner;


class ModuleFiveTaskTwoStepSix {
    public static void main(String[] args) {
        String data;
        Scanner scan = new Scanner(System.in);
        data = scan.nextLine();
        data = data.trim();//удаление пробелов в начале и в конце
        String[] words = data.split(" +"); //разделение на слова
        // собрать из слов строку с одним пробелом между
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words[i].length(); j++){
                if (words[i].charAt(j) == 'z'){
                    words[i] = "ERROR";
                }
            }
        }
        StringBuilder sb = new StringBuilder(words[0]);
        for(int k = 1; k < words.length; k++) {
            sb.append(" ").append(words[k]);
        }
        System.out.println(sb);
    }
}
