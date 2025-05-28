package OopCourse.ModuleFIve;

import java.util.Scanner;
import java.util.ArrayList;

public class TaskOneStepSeven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        String text = scan.next();
        while (!"end".equals(text)) {
            logger = Logger.getInstance();
            logger.putError(text);
            text = scan.next();
        }
        System.out.println(logger.getErrors());
    }
}

class Logger {
    // Логгер - это класс, который будет записывать ошибки во внутреннюю строку методом putError() по принципу стека
    // (т.е. последняя ошибка будет в этой строке первой).
    // Метод getErrors() позволяет получить список ошибок в виде итоговой строки.
    private static Logger uniqueInstance; //ссылка на единственный экземпляр класса
    ArrayList<String> errorStack = new ArrayList<>();
    private Logger() { //приватный конструктор недоступен в других классах
    }
    public static Logger getInstance() {
        if (uniqueInstance == null) { //если экземпляр класса еще не создан
            uniqueInstance = new Logger(); //создаем объект класса
        }
        return uniqueInstance; //возвращаем ссылку на единственный объект
    }

    public void putError(String errorText){
        errorStack.add(errorText);
    }

    public String getErrors() {
        StringBuilder errorsLog = new StringBuilder();
        for (int i = errorStack.size() - 1; i >= 0; i--){
            errorsLog.append(errorStack.get(i));
            errorsLog.append(" ");
        }
        return errorsLog.toString(); // преобразуем StringBuilder в строку
    }
}
