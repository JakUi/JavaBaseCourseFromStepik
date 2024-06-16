package ModuleFive;


import java.util.Scanner;
import java.util.Arrays;


class ModuleFiveTaskTwoStepNine {
    public static void main(String[] args) {
        String data;
        Scanner scan = new Scanner(System.in);
        data = scan.nextLine();
        data = data.trim();
        StringBuilder dataAsString = new StringBuilder(data);
        StringBuilder charArray = new StringBuilder();
        int [] digits = new int[10];
        StringBuilder output = new StringBuilder();
        Arrays.sort(digits);
        for (int c = 0; c <= 9; c++) {
            digits[c] = c;
        }
        for (int k = 0; k < dataAsString.length(); k++) {
            // если символ строка - пропускаем его, если символ число - добавляем в массив
            int ind = Arrays.binarySearch(digits, Character.getNumericValue(dataAsString.charAt(k)));
            if (ind >= 0) {
                charArray.append(dataAsString.charAt(k));
            }
        }
        if (!charArray.isEmpty()) {
            output.append(charArray.charAt(0));
            int sum = Character.getNumericValue(charArray.charAt(0));
            for (int j = 1; j < charArray.length(); j++) {
                output.append("+");
                output.append(charArray.charAt(j));
                sum += Character.getNumericValue(charArray.charAt(j));
            }
            output.append("=").append(sum);
            System.out.println(output);
        }
        else {
            System.out.println("ERROR");
        }
    }
}
