package data.structures.listaLigada;

public interface ListaLigada<T> {

    void insertAtTheBeginning(T data);

    void insertAtTheEnd(T data);

    T removeFromTheBeginning();

    T removeFromTheEnd();

    void print();
}
