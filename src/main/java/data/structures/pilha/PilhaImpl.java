package data.structures.pilha;

public class PilhaImpl<T> implements Pilha<T>{

    private final T[] stack;
    private int position;

    public PilhaImpl(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stack can not have negative length!");
        }
        this.stack = (T[]) new Object[size];
        this.position = -1;
    }

    @Override
    public void push(T data) {
        if (isFull()) {
            throw new IllegalArgumentException("Not possible to add more elements in the stack because it is full!");
        }
        stack[++position] = data;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Not possible to remove elements because the stack is empty!");
        }
        return stack[position--];
    }

    @Override
    public T top() { // peek
        if (isEmpty()) {
            return null;
        }
        return stack[position];
    }

    @Override
    public int size() {
        return stack.length;
    }

    @Override
    public boolean isEmpty() {
        return position < 0;
    }

    @Override
    public boolean isFull() {
        return position == size() - 1;
    }
}
