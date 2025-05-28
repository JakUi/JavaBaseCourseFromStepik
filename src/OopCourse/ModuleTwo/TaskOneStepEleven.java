package OopCourse.ModuleTwo;

import java.util.Scanner;

public class TaskOneStepEleven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String lastName;
        int firstGrade;
        int secondGrade;
        int testTime;
        int passingGrade = scan.nextInt();
        int timeLimit = scan.nextInt();
        int arraySize = scan.nextInt();
        Trial[] gruppa = new Trial[arraySize];
        for (int i = 0; i < arraySize; i++) {
            int trialTypeIndex = scan.nextInt();
            lastName = scan.next();
            firstGrade = scan.nextInt(); 
            secondGrade = scan.nextInt();
            if (trialTypeIndex == 1) {
                gruppa[i] = new Trial(lastName, firstGrade, secondGrade, passingGrade);
            }
            if (trialTypeIndex == 2) {
                gruppa[i] = new LightTrial(lastName, firstGrade, secondGrade);
            }
            if (trialTypeIndex == 3) {
                testTime = scan.nextInt();
                gruppa[i] = new StrongTrial(lastName, firstGrade, secondGrade, timeLimit, testTime);
            }
        }
        for (int j = 0; j < arraySize; j++) {
            System.out.println(gruppa[j].toString());
        }
        System.out.println();
        
        for (int k = 0; k < arraySize; k++){
            if (gruppa[k].isPassed()) {
                System.out.println(gruppa[k].toString());
            }
        }
    }
}

class Trial {
    static int passingGrade;
    String lastName;
    int firstGrade, secondGrade;
    public Trial() {
    }
    public Trial(String lastName, int firstGrade, int secondGrade, int passingGrade) {
        this.lastName = lastName;
        this.firstGrade = firstGrade;
        this.secondGrade = secondGrade;
        this.passingGrade = passingGrade;
    }
    public Trial(String lastName) {
        this.lastName = lastName;
        this.firstGrade = 0;
        this.secondGrade = 0;
    }
    public static int getPassingGrade() {
        return passingGrade;
    }
    public String getLastName() {
        return lastName;
    }
    public int getFirstGrade() {
        return firstGrade;
    }
    public int getSecondGrade() {
        return secondGrade;
    }
    public static void setPassingGrade(int passingGrade) {
        Trial.passingGrade = passingGrade;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstGrade(int firstGrade) {
        this.firstGrade = firstGrade;
    }
    public void setSecondGrade(int secondGrade) {
        this.secondGrade = secondGrade;
    }
    public boolean isPassed() {
        if (firstGrade >= passingGrade) {
            if (secondGrade >= passingGrade) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return lastName + ";" + firstGrade + ";" + secondGrade;
    }
}

class LightTrial extends Trial {
    public LightTrial(String lastName, int firstGrade, int secondGrade) {
        super(lastName, firstGrade, secondGrade, passingGrade);
    }
    public LightTrial(String lastName) {
        super(lastName);
    }
    public LightTrial(){
    }
    @Override
    public boolean isPassed() {  // here?!
        if ((firstGrade + secondGrade) >= passingGrade) {

            return true;
        }
        return false;
    }
}

class StrongTrial extends Trial {
    static int timeLimit;

    int testTime;
    public StrongTrial(String lastName, int firstGrade, int secondGrade, int timeLimit, int testTime) {
        super(lastName, firstGrade, secondGrade, passingGrade);
        this.timeLimit = timeLimit;
        this.testTime = testTime;
    }
    public StrongTrial(String lastName) {
        super(lastName);
    }
    public StrongTrial(){
    }
    @Override
    public boolean isPassed() {
        if (firstGrade >= passingGrade) {
            if (secondGrade >= passingGrade) {
                if (testTime <= timeLimit) {
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return lastName + ";" + firstGrade + ";" + secondGrade + ";" + testTime;
    }
}
