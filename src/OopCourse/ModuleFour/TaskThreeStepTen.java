package OopCourse.ModuleFour;

import java.util.Scanner;


public class TaskThreeStepTen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MySet<Purchase> set = new MySet<>(3);
        String buffer = scan.nextLine();
        while (!"end".equals(buffer)) {
            String[] parts = buffer.split(" "); //разделяем на слова
            set.add(new Purchase(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            buffer = scan.nextLine();
        }
        set.print();
    }
}

class Purchase {
    public String productName;
    public int productPrice;
    public int productQuantity;

    Purchase(String productName, int productPrice, int productQuantity){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return productName + ";" + productPrice + ";" + productQuantity;
    }

    @Override
    public int hashCode() {
        int result = productName.hashCode();
        int c = Integer.hashCode(productPrice);
        return 31 * result + c;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Сравнение с самим собой
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Проверка на null и соответствие классу
        }
        Purchase another = (Purchase) obj; // Безопасное приведение типа
        return this.productName.equals(another.productName) && this.productPrice == another.productPrice;
    }
}

class MySet<E> {
    private E[] set;
    private int k; //индекс свободной ячейки

    MySet(){
        set = (E[]) new Object[10];
        k = 0;
    }

    MySet(int n){
        set = (E[]) new Object[n];
        k = 0;
    }

    public void add(E elem) {
        boolean elementInSet = false;
        for (int i = 0; i < set.length; i++){
            if (elem.equals(set[i])) {
                elementInSet = true;
            }
        }
        if (!elementInSet) {
            if (k >= set.length) { // нет места
                E[] tmp = (E[]) new Object[set.length / 2 + set.length + 1]; //создаем новый массив и приводим к типу E[]
                for (int i = 0; i < set.length; i++) { //переписываем из исходного массива в новый
                    tmp[i] = set[i];
                }
                set = tmp; //считаем новый массив текущим
            }
            set[k] = elem;
            k++; //записываем элемент и увеличиваем k в любом случае
        }
    }

    void print() { // вывод элементов коллекции на консоль. Вывод должен быть в том же порядке, в котором элементы добавлялись в множество.
        for (int j = 0; j < k; j++) {
            System.out.println(set[j]);
        }
    }
}
