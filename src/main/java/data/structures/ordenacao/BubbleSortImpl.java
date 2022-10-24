package data.structures.ordenacao;

import java.util.Arrays;

public class BubbleSortImpl<T extends Comparable<T>> implements Sortable<T>{
    @Override
    public T[] sort(T[] elements) {

        int size = elements.length;
        for (int index = 0; index < size-1; index++) {
            for (int secondIndex = 0; secondIndex < size - index - 1; secondIndex++) {
                if (elements[secondIndex].compareTo(elements[secondIndex+1]) > 0) {
                    T temporary = elements[secondIndex];
                    elements[secondIndex] = elements[secondIndex+1];
                    elements[secondIndex+1] = temporary;
                }
            }
        }

        return elements;
    }

    public static void main(String[] args) {
        BubbleSortImpl<Integer> bubbleSort = new BubbleSortImpl<>();
        Integer[] elements = {10, 30, 50, 20, 100, 90, 40};
        System.out.println("Sorted array: " + Arrays.toString(bubbleSort.sort(elements)));
    }
}
