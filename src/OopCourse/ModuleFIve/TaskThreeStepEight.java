package OopCourse.ModuleFIve;

import java.beans.PropertyChangeEvent;
import java.util.Scanner;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TaskThreeStepEight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Informator informator1 = new Informator("МЧС");
        Informator informator2 = new Informator("Налоговая инспекция");
        Institution one = new Institution("ГГУ им. Ф. Скорины");
        Institution two = new Institution("БГУ");
        informator1.addListener(one);
        informator1.addListener(two);
        informator2.addListener(one);
        informator2.addListener(two);
        String data = scan.nextLine();
        while (!"end".equals(data)) {
            String[] words = data.split(";");
            int informatorNumber = Integer.parseInt(words[0]);
            if (informatorNumber == 1) {
                informator1.setText(words[1]);
            } else {
                informator2.setText(words[1]);
            }
            data = scan.nextLine();
        }
    }
}

class Data {
    private String data;
    String msg = "";

    public Data(String msg) {
        this.msg = msg;
    }

    public Data() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

// Создайте класс Informator, который будет рассылать некоторое сообщение всем подписанным на него наблюдателям (слушателям).
class Informator{
    private String name; // приватное поле name (название организации-информатора)
    private PropertyChangeSupport support; //переменная обеспечивает работу с наблюдателями
    private Data data;

    Informator(String name) {
        this.name = name;
        support = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void setText(String message){ // принимает строку и обеспечивает рассылку этой строки всем наблюдателям
        // с указанием своего имени (источника сообщения).
        // firePropertyChange(). Он принимает три параметра: тип изменений, предыдущие данные и новые данные.
        String msg = " received information from " + name + ":" + "\n" + message;
        Data newData = new Data(msg);
        support.firePropertyChange("newMessage:", this.data, newData);
    }

}

//Также создайте класс Institution с приватным полем name, объект которого является наблюдателем и выводит на
// консоль полученную от информатора строку с указанием источника информации и своего имени.
class Institution implements PropertyChangeListener {
    private String name;
    private Data data;

    Institution(String name){
        this.name = name;
    }

    void display() {
        System.out.println(name +data.getMsg());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) { //вызывается при изменении данных у субъекта
        Data newData = (Data) evt.getNewValue(); //извлекаем новые данные
        data = newData; //фиксируем
        display(); //выводим на экран
    }
}
