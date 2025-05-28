package OopCourse.ModuleOne;

import java.util.Scanner;

public class TaskFourStepEleven {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String name;
            String author;
            String publisher;
            int year;
            Book myBook = null;
            if (!scan.hasNextLine()) {
                myBook = new Book();
            } else {
                name = scan.nextLine();
                author = scan.nextLine();
                if (!scan.hasNextLine()) {
                    myBook = new Book(name, author);
                } else {
                    publisher = scan.nextLine();
                    if (!scan.hasNextInt()) {
                        myBook = new Book(name, author, publisher);
                    } else {
                        year = scan.nextInt();
                        myBook = new Book(name, author, publisher, year);
                    }
                }
            }
            System.out.println(myBook);
        }

//    Создайте класс Book: Название, Автор(ы), Издательство, Год издания.
//    Определите несколько конструкторов.
//    Если в конструктор не передается значение какого-то поля, то этому полю присваиваются значения по умолчанию.
//    Для строк это пустая строка: "", для чисел 0.
    private  static class Book {
        String name;
        String author;
        String publisher;
        int year;
        public Book(String name, String author, String publisher, int year) {
            this.name = name;
            this.author = author;
            this.publisher = publisher;
            this.year = year;
        }
        public Book(String name, String author) {
            this.name = name;
            this.author = author;
            this.publisher = "";
            this.year = 0;
        }
        public Book(String name, String author, String publisher) { // год издания не указан
            this.name = name;
            this.author = author;
            this.publisher = publisher;
            this.year = 0;
        }
        public Book(String name, String author, int year) { //издатель не указан
            this.name = name;
            this.author = author;
            this.publisher = "";
            this.year = year;
        }
        public Book() { // о книге вообще нет данных
            this.name = "";
            this.author = "";
            this.publisher = "";
            this.year = 0;
        }
        @Override
        public String toString() {
            return name + ";" + author + ";" + publisher + ";" + year;
        }
   }
}
