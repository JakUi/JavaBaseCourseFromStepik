package OopCourse.ModuleFIve;

import java.util.Scanner;


public class TaskFiveStepEight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //определяемся со стилем мебели - создаем фабрику
        String style = scan.nextLine();
        FurnitureFactory factory = null;
        switch (style) {
            case "Модерн" -> factory = new ModernFurnitureFactory();
            case "Арт - деко" -> factory = new ArtDecoFurnitureFactory();
            case "Викторианский" -> factory = new VictorianFurnitureFactory();
            default -> {
                System.out.println("ERROR");
                return;
            }
        }

        //дальнейший код магазина не зависит от выбранного стиля
        int summa = 0;
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();
        CoffeeTable table = factory.createCoffeeTable();

        System.out.println("1- " + chair.description() + " стоимость: " + chair.getCost());
        System.out.println("2- " + sofa.description() + " стоимость: " + sofa.getCost());
        System.out.println("3- " + table.description() + " стоимость: " + table.getCost());
        System.out.println("Ваш выбор:");

        Cycl:
        do {
            int number = scan.nextInt();
            switch (number) {
                case 1 -> summa += chair.getCost();
                case 2 -> summa += sofa.getCost();
                case 3 -> summa += table.getCost();
                default -> {
                    break Cycl;
                }
            }
        } while (true);
        System.out.println("Общая стоимость Вашей покупки = " + summa);
    }
}

interface Furniture {
    String description();
    int getCost();
}

interface Chair extends Furniture {
}

interface Sofa extends Furniture {
}

interface CoffeeTable extends Furniture {
}

interface FurnitureFactory { //Далее вы создаёте абстрактную фабрику — общий интерфейс, который содержит методы создания
                             // всех продуктов семейства (например, создатьКресло, создатьДиван и создатьСтолик)
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}

class ArtDecoFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new ChairArtDeco();
    }

    @Override
    public Sofa createSofa() {
        return new SofaArtDeco();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new CoffeeTableArtDeco();
    }
}

class ChairArtDeco implements Chair {

    @Override
    public String description() {
        return "Кресло в стиле Арт-деко";
    }

    @Override
    public int getCost() {
        return 50;
    }
}

class SofaArtDeco implements Sofa{
    @Override
    public String description() {
        return "Диван в стиле Арт-деко";
    }

    @Override
    public int getCost() {
        return 90;
    }
}

class CoffeeTableArtDeco implements CoffeeTable{
    @Override
    public String description() {
        return "Столик в стиле Арт-деко";
    }

    @Override
    public int getCost() {
        return 65;
    }
}

class ModernFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new ChairModern();
    }

    @Override
    public Sofa createSofa() {
        return new SofaModern();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new CoffeeTableModern();
    }
}

class ChairModern implements Chair {

    @Override
    public String description() {
        return "Кресло в стиле Модерн";
    }

    @Override
    public int getCost() {
        return 20;
    }
}

class SofaModern implements Sofa{
    @Override
    public String description() {
        return "Диван в стиле Модерн";
    }

    @Override
    public int getCost() {
        return 80;
    }
}

class CoffeeTableModern implements CoffeeTable{
    @Override
    public String description() {
        return "Столик в стиле Модерн";
    }

    @Override
    public int getCost() {
        return 10;
    }
}

class VictorianFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new ChairVictorian();
    }

    @Override
    public Sofa createSofa() {
        return new SofaVictorian();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new CoffeeTableVictorian();
    }
}

class ChairVictorian implements Chair {

    @Override
    public String description() {
        return "Кресло в викторианском стиле";
    }

    @Override
    public int getCost() {
        return 80;
    }
}

class SofaVictorian implements Sofa{
    @Override
    public String description() {
        return "Диван в викторианском стиле";
    }

    @Override
    public int getCost() {
        return 110;
    }
}

class CoffeeTableVictorian implements CoffeeTable{
    @Override
    public String description() {
        return "Столик в викторианском стиле";
    }

    @Override
    public int getCost() {
        return 70;
    }
}
