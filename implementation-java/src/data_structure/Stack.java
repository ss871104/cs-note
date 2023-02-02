package data_structure;

public class Stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if (top == null) {
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;

        return temp;
    }

    public void displayStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void peek() {
        System.out.println("Top: " + top.value);
    }

    public void size() {
        System.out.println("Size: " + height);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.displayStack();
        stack.peek();
        stack.size();

        stack.pop();
        stack.displayStack();
        stack.peek();
        stack.size();
    }
}
