package data_structure;

public class Queue {
    private  Node first;
    private  Node last;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        length++;
    }

    public Node dequeue() {
        if (first == null) {
            return null;
        }

        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }

        length--;

        return temp;
    }

    public  void displayQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void peek() {
        System.out.println("First: " + first.value);
    }

    public void getLast() {
        System.out.println("Last: " + last.value);
    }

    public void size() {
        System.out.println("Size: " + length);
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.displayQueue();
        queue.peek();
        queue.getLast();
        queue.size();

        queue.dequeue();

        queue.displayQueue();
        queue.peek();
        queue.getLast();
        queue.size();
    }
}
