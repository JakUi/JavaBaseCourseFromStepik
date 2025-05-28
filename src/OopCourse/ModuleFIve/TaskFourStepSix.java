package OopCourse.ModuleFIve;

import java.util.Scanner;

public class TaskFourStepSix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // В методе main() класса Main сначала вводится исходная строка текста и создается объект класса Message.
        // Затем вводится целое число и определяется способ редактирования:
        //
        //1 - удаление лишних пробелов;
        //2 - удаление всех цифр;
        //3 - преобразование в заглавные первых букв слов;
        //во всех остальных случаях строка остается без изменения.
        //После задания способа редактирования с помощью сеттера, вызывается метод print()
        String text = scan.nextLine();
        MessageStrategy message = new MessageStrategy(text);
        int actionIndex = scan.nextInt();
        switch (actionIndex) {
            case 1:
                message.setEditWay(new NoExtraSpacesStrategy());
                break;
            case 2:
                message.setEditWay(new NoDigitsStrategy());
                break;
            case 3:
                message.setEditWay(new CapsFirstLetters());
                break;
            default:
                message.setEditWay(new NoEditing());
                break;
        }
        message.print();
    }
}

// должен быть интеhфейс Editing с единственным методом String edit(String text).
interface Editing {
    String edit(String text);
}

class NoExtraSpacesStrategy implements Editing { // класс поведения, реализующий данный интерфейс Editing
    String text;

    @Override
    public String edit(String text) { // удаляет все лишние пробелы в начале и в конце текста, оставляя между словами ровно один пробел;
        String[] splittedText = text.split("\\s+");
        StringBuilder noSpaceText = new StringBuilder();
        for (String txt:splittedText) {
            noSpaceText.append(txt.trim());
            noSpaceText.append(" ");
        }
        return noSpaceText.toString().trim();
    }
}

class NoDigitsStrategy implements Editing { // класс поведения, реализующий данный интерфейс Editing

    @Override
    public String edit(String text) {
        return text.replaceAll("[0-9]","");
    }
}

class CapsFirstLetters implements Editing { // класс поведения, реализующий данный интерфейс Editing

    @Override
    public String edit(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i]) && (i == 0 || chars[i - 1] == ' ')) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        return new String(chars);
    }
}

class NoEditing implements Editing { // класс поведения, реализующий данный интерфейс Editing

    @Override
    public String edit(String text) {
        return text;
    }
}

abstract class TextMessage { // аналог класса Duck
    protected Editing editing; // переменная экземпляра Editing
    String text;

    public String performEditing() {
        return editing.edit(text);
    }
}

//Также создайте класс Message с полями: String text и Editing editWay. В конструктор передается строка text
class MessageStrategy extends TextMessage {

    MessageStrategy(String text){
        this.text = text; // теперь это поле родителя
    }

    public void setEditWay(Editing editWay) {
        this.editing = editWay; // используем унаследованное поле
    }

    void print(){
        String editedText = performEditing();
        System.out.println(editedText);
    }
}
