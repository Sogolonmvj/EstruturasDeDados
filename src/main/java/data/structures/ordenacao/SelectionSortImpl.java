package data.structures.ordenacao;

import java.util.Arrays;

public class SelectionSortImpl<T extends Comparable<T>> implements Sortable<T>{

    @Override
    public T[] sort(T[] elements) {
        int size = elements.length;

        for (int index = 0; index < size-1; index++) {
            int smallest = index;

            for (int secondIndex = index+1; secondIndex < size; secondIndex++) {
                if (elements[secondIndex].compareTo(elements[smallest]) < 0) {
                    smallest = secondIndex;
                }
                T temporary = elements[smallest];
                elements[smallest] = elements[index];
                elements[index] = temporary;
            }
        }
        
        return elements;
    }

    public static void main(String[] args) {
        SelectionSortImpl<Integer> selectionSort = new SelectionSortImpl<>();
        Integer[] elements = {10, 30, 50, 20, 100, 90, 40};
        System.out.println("Sorted array: " + Arrays.toString(selectionSort.sort(elements)));
    }
}
