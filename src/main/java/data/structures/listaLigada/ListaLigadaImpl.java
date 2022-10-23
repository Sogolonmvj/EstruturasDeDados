package data.structures.listaLigada;

public class ListaLigadaImpl<T> implements ListaLigada<T> {

    Node<T> head = null;
    Node<T> tail = null;

    @Override
    public void insertAtTheBeginning(T data) {
        Node<T> newNode = new Node<T>(data);

        newNode.next = head;
        head = newNode;
    }

    @Override
    public void insertAtTheEnd(T data) {
        Node<T> newNode = new Node<T>(data);

        if (head != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
    }

    @Override
    public T removeFromTheBeginning() {
        if (head == null) {
            throw new IllegalArgumentException("The list is empty!");
        }
        T temporary = head.data;
        head = head.next;
        return temporary;
    }

    @Override
    public T removeFromTheEnd() {
        if (head == null) {
            throw new IllegalArgumentException("The list is empty!");
        }
        Node<T> node = head;
        while(node.next.next != null) {
            node = node.next;
        }
        Node<T> temporary = node.next;
        node.next = null;
        return temporary.data;
    }

    @Override
    public void print() {
        Node<T> currentNode = head;

        if (currentNode == null) {
            System.out.println("Empty list");
            return;
        }

        while (currentNode != null) {
            System.out.print(currentNode.data);
            if (currentNode.next != null) {
                System.out.print(" -> ");
            }
            currentNode = currentNode.next;
        }

    }

    public static void main(String[] args) {
        ListaLigadaImpl<Object> linkedList = new ListaLigadaImpl<>();

        linkedList.insertAtTheEnd(1);
        linkedList.insertAtTheEnd(2);
        linkedList.insertAtTheBeginning(5);
        linkedList.insertAtTheBeginning(3);
        linkedList.insertAtTheBeginning(7);
        linkedList.insertAtTheEnd(3);
        linkedList.insertAtTheEnd(4);

        linkedList.removeFromTheBeginning();
        linkedList.removeFromTheBeginning();

        linkedList.removeFromTheEnd();
        linkedList.removeFromTheEnd();

        linkedList.print();
    }
}
