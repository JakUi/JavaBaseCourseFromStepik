package OopCourse.ModuleFIve;

import java.util.Scanner;


public class TaskFiveStepFive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        Dialog dialog = null;
        if ("Windows".equals(type)) {
            dialog = new WindowsDialog();
        } else if ("Html".equals(type)) {
            dialog = new HtmlDialog();
        } else {
            System.out.println("ERROR");
            return;
        }
        dialog.renderWindow();
    }
}

abstract class Dialog {
    Button renderWindow(){
        Button button = createButton();
        button.render();
        return button;
    }

    public abstract Button createButton();
}

class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}

abstract class Button {
    String windowType;

    public String getWindowType() {
        return windowType;
    }

    public void setWindowType(String windowType) {
        this.windowType = windowType;
    }

    public void render(){
        System.out.println("Рисуем окно диалога\n" + "Отрисовали кнопку в стиле " + windowType +" с надписью OK");
    }
}

class WindowsButton extends Button {
    public WindowsButton(){
        setWindowType("Windows");
    }

}

class HtmlButton extends Button {
    public HtmlButton(){
        setWindowType("Html");
    }
}
