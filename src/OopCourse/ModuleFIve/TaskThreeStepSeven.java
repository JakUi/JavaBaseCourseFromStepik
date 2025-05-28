package OopCourse.ModuleFIve;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskThreeStepSeven {
    public static void main(String[] args) {
        //  На газету подписались медведи Потап и Настасья, заяц Трусишка и волк Алекс.
        //  Каждый зверь любит читать в газете только про своих родственников (Медведь, Заяц и Волк – это классы).
        // создаём объект NewsPaperData
        NewsPaperData newspaper = new NewsPaperData();
        // сначала все звери подписались на газету и получили первый номер.
        BearReads bearReads1 = new BearReads(newspaper, "Потап");
        BearReads bearReads2 = new BearReads(newspaper, "Настасья");
        WolfReads wolfReads = new WolfReads(newspaper, "Алекс");
        HareReads hareReads = new HareReads(newspaper, "Трусишка");
        newspaper.newspaperNumberChanged(1);
        System.out.println();
        Scanner scan = new Scanner(System.in);
        String unsubscriber = scan.nextLine();
        switch (unsubscriber){
            case "Потап":
                bearReads1.unsubscribe();
                System.out.println("Потап не хочет получать газету");
                break;
            case "Настасья":
                bearReads2.unsubscribe();
                System.out.println("Настасья не хочет получать газету");
                break;
            case "Алекс":
                wolfReads.unsubscribe();
                System.out.println("Алекс не хочет получать газету");
                break;
            case "Трусишка":
                hareReads.unsubscribe();
                System.out.println("Трусишка не хочет получать газету");
                break;
        }
        System.out.println();
        newspaper.newspaperNumberChanged(2);
    }
}

interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

interface Observer {
    void update(int newspaperNumber); // изменения (пришёл новый номер газеты)
}

interface WhoReads {
    void display();
}

class NewsPaperData implements Subject {
    private ArrayList<Observer> observers;
    private int number;

    NewsPaperData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() { //оповещение наблюдателей
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update(number); //вызов у наблюдателя метода update
        }
    }

    //действия при изменении данных
    public void newspaperNumberChanged(int number) {
        this.number = number;
        notifyObservers(); //оповестить наблюдателей
    }
}

class BearReads implements Observer, WhoReads {
    private int newspaperNumber;
    private Subject newsPaperData;
    private String name;


    //в конструкторе регистрация у субъекта в качестве наблюдателя
    public BearReads(Subject newsPaperData, String name) {
        this.newsPaperData = newsPaperData; // запоминаем субъекта
        this.name = name;
        newsPaperData.registerObserver(this); // регистрируемся у него для получения оповещени
    }

    @Override
    public void display() {
        System.out.println(name + " читает про медведей в номере " + newspaperNumber);
    }

    @Override
    public void update(int newspaperNumber) {
        //обновляем данные в полях
        this.newspaperNumber = newspaperNumber;
        display();
    }

    void unsubscribe(){
        newsPaperData.removeObserver(this);
    }
}

class HareReads implements Observer, WhoReads {
    private int newspaperNumber;
    private Subject newsPaperData;
    private String name;


    //в конструкторе регистрация у субъекта в качестве наблюдателя
    public HareReads(Subject newsPaperData, String name) {
        this.newsPaperData = newsPaperData; // запоминаем субъекта
        this.name = name;
        newsPaperData.registerObserver(this); // регистрируемся у него для получения оповещений
    }

    @Override
    public void display() {
        System.out.println(name + " читает про зайцев в номере " + newspaperNumber);
    }

    @Override
    public void update(int newspaperNumber) {
        //обновляем данные в полях
        this.newspaperNumber = newspaperNumber;
        display();
    }

    void unsubscribe(){
        newsPaperData.removeObserver(this);
    }
}

class WolfReads implements Observer, WhoReads {
    private int newspaperNumber;
    private Subject newsPaperData;
    private String name;


    //в конструкторе регистрация у субъекта в качестве наблюдателя
    public WolfReads(Subject newsPaperData, String name) {
        this.newsPaperData = newsPaperData; // запоминаем субъекта
        this.name = name;
        newsPaperData.registerObserver(this); // регистрируемся у него для получения оповещений
    }

    @Override
    public void display() {
        System.out.println(name + " читает про волков в номере " + newspaperNumber);
    }

    @Override
    public void update(int newspaperNumber) {
        //обновляем данные в полях
        this.newspaperNumber = newspaperNumber;
        display();
    }

    void unsubscribe(){
        newsPaperData.removeObserver(this);
    }
}
