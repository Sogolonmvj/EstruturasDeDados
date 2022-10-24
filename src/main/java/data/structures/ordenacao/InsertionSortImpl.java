package data.structures.ordenacao;

import java.util.Arrays;

public class InsertionSortImpl<T extends Comparable<T>> implements Sortable<T> {
    @Override
    public T[] sort(T[] elements) {

        int size = elements.length;
        for (int index = 0; index < size; index++) {
            T key = elements[index];
            int secondIndex = index - 1;

            while(secondIndex >= 0 && elements[secondIndex].compareTo(key) > 0) {
                elements[secondIndex+1] = elements[secondIndex];
                secondIndex = secondIndex-1;
            }
            elements[secondIndex+1] = key;
        }

        return elements;
    }

    public static void main(String[] args) {
        InsertionSortImpl<Integer> insertionSort = new InsertionSortImpl<>();
        Integer[] array = {10, 30, 50, 20, 100, 90, 40};
        System.out.println(Arrays.toString(insertionSort.sort(array)));
    }
}
