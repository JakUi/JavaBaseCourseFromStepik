package ModuleThree;

import java.util.Scanner;

class ModuleThreeTaskOneStepEleven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input_string = scan.nextLine();
        char string_number = input_string.charAt(0);
        char symbol = input_string.charAt(2);
        int number = Integer.parseInt(String.valueOf(string_number));
        printTriangle(number, symbol);
    }

    static void printTriangle(int number, char symbol) {
        int triangle_vertex = number % 2 == 0 ? 2: 1; // проверяем какая вершина будет у треугольника (если основание
                                                      // чётное - вершина из одного симола, иначе - из двух).
        int q_levels = (number + 1) / 2;
        int c = q_levels - 2;
        if (triangle_vertex == 2) {
            for (int i = triangle_vertex; i <=number; i+=2) {
                for (int k = 0; k <= c; k++){
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++){ // этот блок работает верно
                    System.out.print(symbol);
                }
                c--;
                System.out.println();
            }
        }
        else if (triangle_vertex == 1) {
            for (int i = triangle_vertex; i <=number; i+=2) {
                for (int k = 0; k <= c; k++){
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++){  // этот блок работает верно
                    System.out.print(symbol);
                }
                c--;
                System.out.println();
            }
        }
    }
}
