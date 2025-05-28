package OopCourse.ModuleFour;


import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class TaskFourStepEight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[scan.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        ReverseArray reverse = new ReverseArray(array);
        for (Integer item : reverse) {
            System.out.print(item + " ");
        }
    }
}

class ReverseArray implements Iterable<Integer> {
    int[] array;

    ReverseArray(int[] array) {
        this.array = array;
        int count = array.length - 1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {
        private int count = array.length - 1;

        @Override
        public boolean hasNext() {
            return count >= 0;
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return array[count--];
        }
    }
}
