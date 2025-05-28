package OopCourse.ModuleFour;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class TaskFourStepNine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int end = scan.nextInt();
        Range range = new Range(start, end);
        for (Integer item : range) {
            System.out.print(item + " ");
        }
    }
}

class Range implements Iterable<Integer>, Iterator<Integer> {
    //Разработать класс Range (диапазон) c двумя полями:
    //int start - начало диапазона;
    //int end - конец диапазона.
    
    int start;
    int end;
    private int count;

    Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        count = start;
        return this;
    }
    
    @Override
    public boolean hasNext() {
        return count <= end;
    }
    
    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return count++;
    }
}
