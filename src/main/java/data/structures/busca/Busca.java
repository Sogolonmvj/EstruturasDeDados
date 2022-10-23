package data.structures.busca;

public interface Busca<T extends Comparable<T>> {

    int buscaSequencial(T[] elements);

    int buscaBinaria(T[] elements);

}
