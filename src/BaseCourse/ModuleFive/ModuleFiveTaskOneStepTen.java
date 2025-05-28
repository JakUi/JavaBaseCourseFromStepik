package BaseCourse.ModuleFive;

import java.util.Scanner;


class ModuleFiveTaskOneStepTen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] strMas;
        strMas = new String[3];
        String secret_word = "";
        for(int i = 0; i < 3; i++){
            strMas[i] = new String(scan.nextLine());
        }
        for(String el:strMas){
            secret_word = secret_word.concat(returnSecretWord(el));
        }
        System.out.println(secret_word);
    }

    static String returnSecretWord(String str) {
        String part_of_secret_word = new String(str.substring(str.indexOf(";") + 1, str.lastIndexOf(";")));
        return part_of_secret_word;
    }
}
