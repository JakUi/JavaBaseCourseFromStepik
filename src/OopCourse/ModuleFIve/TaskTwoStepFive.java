package OopCourse.ModuleFIve;

import java.util.Scanner;

public class TaskTwoStepFive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Message message = new Message(scan.nextLine());

        String type = scan.next();
        while (!"end".equals(type)) {
            switch (type) {
                case "Caps":
                    message = new CapitalLetters(message);
                    break;
                case "NoDigits":
                    message = new NoDigits(message);
                    break;
                case "NoExtraSpaces":
                    message = new NoExtraSpaces(message);
                    break;
            }
            type = scan.next();
        }

        System.out.println(message.getMessage());
    }
}

class Message {
    private String msg = "";

    Message() {
    }

    Message(String msg) {
        this.msg = msg;
    }

    String getMessage() {
        return msg;
    }
}

abstract class CondimentDecorator extends Message {
    //декораторы должны заново реализовать получение описания
    @Override
    abstract String getMessage();
}

class CapitalLetters extends CondimentDecorator { // сделать все буквы прописными (класс CapitalLetters);
    Message message;

    CapitalLetters(Message message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message.getMessage().toUpperCase();
    }
}

class NoExtraSpaces extends CondimentDecorator { // удалить все лишние пробелы в начале и в конце,
    // а также между словами оставить ровно один пробел (класс NoExtraSpaces);
    Message message;

    NoExtraSpaces(Message message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        String[] splittedMessage = message.getMessage().split("\\s+");
        StringBuilder noSpaceMessage = new StringBuilder();
        for (String msg:splittedMessage) {
            noSpaceMessage.append(msg.trim());
            noSpaceMessage.append(" ");
        }
        return noSpaceMessage.toString().trim();
    }
}

class NoDigits extends CondimentDecorator { // удалить все цифры в строке (класс NoDigits)
    Message message;

    NoDigits(Message message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message.getMessage().replaceAll("[0-9]","");
    }
}

