package data.structures.ordenacao;

public interface Sortable<T extends Comparable<T>> {

    T[] sort(T[] elements);
}
