package data.structures.fila;

public class FilaImpl<T> implements Fila<T>{

    private final T[] queue;
    private int front;
    private int rear;
    private int shifter;

    public FilaImpl(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Queue can not have negative length!");
        }
        this.queue = (T[]) new Object[size];
        this.front = -1;
        this.shifter = 0;
        this.rear = -1;
    }

    @Override
    public void enqueue(T data) {
        if (front < 0 || rear < 0) {
            ++front;
        }
        if (isFull()) {
            throw new IllegalArgumentException("Not possible to insert new elements because the queue is full!");
        }
        queue[++rear] = data;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Not possible to remove elements from the queue because it is empty!");
        }
        T temporary = queue[front];
        shifter = front;

        shift();

        return temporary;
    }

    private void shift() {
        int index = 0;
        while (index < size() - 1) {
            queue[shifter] = queue[++shifter];
            index++;
        }
        if (rear < size()) {
            queue[rear] = null;
        }
        rear--;
    }

    @Override
    public T front() {
        if (isEmpty() || front < 0) {
            throw new IllegalArgumentException("The queue is empty!");
        }
        return queue[front];
    }

    @Override
    public int size() {
        return queue.length;
    }

    private int newSize() {
        int counter = 0;
        for (T element : queue) {
            if (element != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return size() <= 0;
    }

    @Override
    public boolean isFull() {
        return size() > 0 && rear == size();
    }

    private void display() {
        System.out.println("Queue: ");
        for (T t : queue) {
            if (t != null) {
                System.out.print(t + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FilaImpl<Object> queue = new FilaImpl<>(5);

//        queue.enqueue(1);
//        queue.enqueue(3);
//        queue.enqueue(5);
//        queue.enqueue(2);
//        queue.enqueue(4);

        queue.display();

        System.out.println("First element of the queue: " + queue.front());
        System.out.println("The length of the queue: " + queue.size());

        queue.dequeue();
        queue.dequeue();

        queue.display();

        System.out.println("First element of the queue: " + queue.front());
        System.out.println("The length of the queue: " + queue.newSize());
    }
}
