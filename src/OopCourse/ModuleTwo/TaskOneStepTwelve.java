package OopCourse.ModuleTwo;

import java.util.Objects;
import java.util.Scanner;
import java.util.Locale;


public class TaskOneStepTwelve {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // Ввести количество элементов массива
        if (n < 0) {
            System.out.println("ERROR");
            return;
        }
        Purchase[] list = new Purchase[n]; // создать массив ссылочных переменных типа Purchase соответствующего размера.
        double discount = scan.nextDouble(); // ввести размер скидки в долях
        int minAmount = scan.nextInt(); // ввести минимальный объем покупки для получения скидки
        for (int i = 0; i < list.length; i++) {
            int classNumber = scan.nextInt();
            String commodity = scan.next();
            int price = scan.nextInt();
            int quantity = scan.nextInt();
            // номер класса, название товара, цена, количество. Номер класса может быть 1, 2 или 3:
            //  1 - класс Purchase; 2 - класс FixDiscountPurchase; 3 - класс FlowDiscountPurchase
            switch (classNumber) {
                case 1:
                    list[i] = new Purchase(new Commodity(commodity, price), quantity);
                    break;
                case 2:
                    list[i] = new FixDicsountPurchase(new Commodity(commodity, price), quantity);
                    FixDicsountPurchase.setDiscount(discount);
                    break;
                case 3:
                    list[i] = new FlowDiscountPurchase(new Commodity(commodity, price), quantity);
                    FlowDiscountPurchase.setDiscount(discount);
                    FlowDiscountPurchase.setMinAmount(minAmount);
                    break;
            }
        }
        // Вывести исходный массив покупок на консоль, используя метод toString().
        for (int j = 0; j < list.length; j++){
            System.out.println(list[j].toString());
        }

        // Найти покупку с максимальной стоимостью и вывести индекс этой покупки в массиве на консоль с новой строки.
        // Если покупок с такой стоимостью несколько, то выводится индекс первой их них (первый максимум).
        int maxCost = list[0].getCost();
        int index = 0;
        for (int k = 1; k < list.length; k++) {
            if (maxCost < list[k].getCost()) {
                maxCost = list[k].getCost();
                index = k;
            }
        }
        System.out.println(index);

        // Определить, являются ли все покупки равными. Вывести с новой строки "YES", если это так, и "NO", если нет.
        boolean isEqual = false;
        String result = "NO";
        // две покупки считаются равными, если совпадают товары (название и цена).
        for (int p = 0; p < list.length - 1; p++) {
            isEqual = list[p].equals(list[p + 1]);
            if (isEqual == false) {
                break;
            }
        }
        result = (isEqual == true)?"YES":"NO";
        System.out.println(result);
    }
}

class Commodity {
    //  Поля (приватные): название товара, цена в копейках.
    //  Конструкторы: без параметров, с двумя параметрами.
    //  Методы (все публичные).
    //  геттеры и сеттеры для всех полей.
    //  переопределенный метод toString(), который представляет объект как строку в csv - формате (значения полей отделяются точкой с запятой).  Например: Молоко;211
    private String name;
    private int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public void show() {
        System.out.println("Наименование товара: " + name);
        System.out.println("Цена товара: " + price);
    }

    public Commodity(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Commodity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ";" + price;
    }

    //    Доработайте класс Purchase: переопределите методы equals() и hashCode():
    //    две покупки считаются равными, если совпадают товары (название и цена).
    //    Подсказка: сначала переопределите эти методы в классе Commodity
    @Override
    public boolean equals(Object obj) {
        Commodity another = (Commodity) obj; //преобразование полученного объекта в товар
        // две покупки считаются равными, если совпадают товары (название и цена).
        if(!this.name.equals(another.name)) {
            return false;
        }
        return this.price == another.price;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode(); // хеш-код для названия товара
        int c = Integer.hashCode(price); // хеш-код для цены
        return 31*result+c;
    }
}

class Purchase {
    private Commodity commodity;  //Поля (приватные): товар (поле класса Commodity), количество единиц товара (целое).
    private int number;

    public int getCost() {  // int getCost() - вычисляет стоимость покупки в копейках (цена * количество).
        return commodity.getPrice() * number;
    }

    public void show() {
        commodity.show();
        System.out.println("Количество: " + number);
        System.out.println("Стоимость покупки: " + getCost());
    }

    public Purchase(Commodity commodity, int number) {
        this.commodity = commodity;
        this.number = number;
    }

    public Purchase() {
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return getCommodity().getName() + ";"  + getCommodity().getPrice() +";" + number + ";" + getCost(); // для commodity вызывается toString()
    }

    // Доработайте класс Purchase: переопределите методы equals() и hashCode():
    // две покупки считаются равными, если совпадают товары (название и цена).
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;
//        return number == purchase.number && Objects.equals(commodity, purchase.commodity);
        return Objects.equals(commodity, purchase.commodity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commodity, number);
    }
}

class FixDicsountPurchase extends Purchase {
    // Разработать подкласс FixDiscountPurchase  для покупки товара с фиксированной скидкой от цены.
    // В этом классе имеется дополнительное статическое поле  discount типа double (размер скидки в долях).
    static double discount;

    public FixDicsountPurchase(Commodity commodity, int number) {
        super(commodity, number);

    }

    // Добавьте соответствующие конструкторы,  геттеры и сеттеры для этого поля
    public static double getDiscount() {
        return discount;
    }

    public static void setDiscount(double discount) {
        FixDicsountPurchase.discount = discount;
    }

    @Override
    public int getCost() {
        // метод getCost( ) - стоимость покупки со скидкой. Учтите, что размер скидки округляется в меньшую сторону.
        // Например, если скидка 0.1 (т.е. 10%)  для покупки стоимостью 422, то скидка 42 копейки.
        // Стоимость товара тогда 422 - 42 = 380 копеек.
        return  super.getCost() - (int)(super.getCost() * discount);
    }

    @Override
    public String toString() {
    // метод  toString( ): строка формируется из  названия товара, цены, количества, скидки и стоимости покупки. Например: Молоко;211;2;0.1;380
        return getCommodity().getName() + ";" + getCommodity().getPrice() + ";" + getNumber() + ";" + discount + ";" + getCost();
    }
}

    // Разработать второй подкласс от Purchase с названием FlowDiscountPurchase.
    // в котором скидка предоставляется в случае, если количество единиц товара не меньше некоторого заданного объема.
    // Дополнительные статические поля: discount (размер скидки), minAmount (заданный объем товара, с которого начинает действовать скидка)

class FlowDiscountPurchase extends Purchase {
    static double discount;
    static int minAmount = 1;

    public FlowDiscountPurchase(Commodity commodity, int number) {
        super(commodity, number);
    }

    public static void setDiscount(double discount) {
        FlowDiscountPurchase.discount = discount;
    }

    public static int getMinAmount() {
        return minAmount;
    }

    public static void setMinAmount(int minAmount) {
        FlowDiscountPurchase.minAmount = minAmount;
    }

    public static double getDiscount() {
        return discount;
    }

    @Override
    public int getCost() {
    // в котором скидка предоставляется в случае, если количество единиц товара не меньше некоторого заданного объема
        if (super.getNumber() >= minAmount ) {
            return  super.getCost() - (int)(super.getCost() * discount);
        }
        return super.getCost();
    }

    @Override
    public String toString() {
        // метод  toString( ): строка формируется из  названия товара, цены, количества, процента скидки,
        // порога действия скидки  и стоимости покупки. Например: Молоко;211;2;0.1;2;380
        return getCommodity().getName() + ";" + getCommodity().getPrice() + ";" + getNumber() + ";" + discount + ";"+ minAmount +";" + getCost();
    }
}
