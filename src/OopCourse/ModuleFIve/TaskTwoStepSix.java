package OopCourse.ModuleFIve;

import java.util.Scanner;

class TaskTwoStepSix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String descr1 = scan.nextLine();
        String descr2 = scan.nextLine();
        String[] words1 = descr1.split(" +");
        String[] words2 = descr2.split(" +");
        SuperHero one = createHero(words1);
        SuperHero two = createHero(words2);
        fight(one, two);
    }

    static SuperHero createHero(String[] words) { //создание героя
        SuperHero result = null;
        if (Integer.parseInt(words[0]) == 1) {
            result = new GreenSuperHero();
        } else {
            result = new RedSuperHero();
        }
        for (int i = 1; i < words.length; i++) {
            int type = Integer.parseInt(words[i]);
            switch (type) {
                case 1:
                    result = new SuperPower(result);
                    break;
                case 2:
                    result = new SuperAgility(result);
                    break;
                case 3:
                    result = new SuperIntelligence(result);
                    break;
            }
        }
        return result;
    }

    static void fight(SuperHero one, SuperHero two) { //сражение
        if (one.getChanceToSurvive() > two.getChanceToSurvive()) {
            System.out.println(one.getDescription() + " победит " + two.getDescription());
        } else if (one.getChanceToSurvive() < two.getChanceToSurvive()) {
            System.out.println(two.getDescription() + " победит " + one.getDescription());
        } else {
            System.out.println("Силы " + one.getDescription() + " и " + two.getDescription() + " равны!");
        }
    }
}

abstract class SuperHero {
    String description = "";

    SuperHero() {
    }
    SuperHero(String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }

    abstract int getChanceToSurvive();
}

abstract class CondimentDecoratorHeroes extends SuperHero {
    //декораторы должны заново реализовать получение описания
    @Override
    abstract int getChanceToSurvive();

    @Override
    abstract String getDescription();
}

class GreenSuperHero extends SuperHero {
    SuperHero superHero;

    GreenSuperHero(){
        super("Green super-hero");
    }

    @Override
    int getChanceToSurvive() {
        return 10;
    }
}

class RedSuperHero extends SuperHero {
    SuperHero superHero;

    RedSuperHero(){
        super("Red super-hero");
    }

    @Override
    int getChanceToSurvive() {
        return 12;
    }
}

class SuperPower extends CondimentDecoratorHeroes {
    SuperHero superHero;

    SuperPower(SuperHero superHero) {
        this.description = "super Power";
        this.superHero = superHero;
    }

    @Override
    int getChanceToSurvive() {
        return 4 + superHero.getChanceToSurvive();
    }

    @Override
    String getDescription() {
        return superHero.getDescription() + ", super Power";
    }
}

class SuperAgility extends CondimentDecoratorHeroes {
    SuperHero superHero;

    SuperAgility(SuperHero superHero) {
        this.description = "super Agility";
        this.superHero = superHero;
    }

    @Override
    int getChanceToSurvive() {
        return 3 + superHero.getChanceToSurvive();
    }

    @Override
    String getDescription() {
        return superHero.getDescription() + ", super Agility";
    }
}

class SuperIntelligence extends CondimentDecoratorHeroes {
    SuperHero superHero;

    SuperIntelligence(SuperHero superHero) {
        this.description = "super Intelligence";
        this.superHero = superHero;
    }

    @Override
    int getChanceToSurvive() {
        return 7 + superHero.getChanceToSurvive();
    }

    @Override
    String getDescription() {
        return superHero.getDescription() + ", super Intelligence";
    }
}
