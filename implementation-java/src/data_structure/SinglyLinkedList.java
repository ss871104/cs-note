package data_structure;

public class SinglyLinkedList {
    // Represent the head, tail and length of the single linked list
    private Node head;
    private Node tail;
    private int length;

    // Represent a node of the single linked list
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // append() will add a new node to the end of the list -------------------------------------------------------
    public void append(int value) {
        // Create a new node
        Node newNode = new Node(value);

        // Checks if the list is empty
        if (head == null) {
            // If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        } else {
            // newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            // newNode will become new tail of the list
            tail = newNode;
        }
        // length increases everytime node added
        length++;
    }

    // prepend() will add a new node to the beginning of the list ------------------------------------------------
    public void prepend(int value) {
        // Create a new node
        Node newNode = new Node(value);

        // Checks if the list is empty
        if (head == null) {
            // If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        } else {
            // newNode will be added before head, newNode will point to head
            newNode.next = head;
            // newNode will become new head
            head = newNode;
        }
        // length increases everytime node added
        length++;
    }

    // removeLast() will remove the node in the end of the list -------------------------------------------------
    public Node removeLast() {
        // Check if the list is empty
        if (length == 0)
            return null;

        // temp is to check the last node of the list, prev is the node before the last node
        Node temp = head;
        Node prev = head;

        // In order to let temp becomes the last node, check if the next node of temp is null
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        // If temp is the last node confirmed, set tail to prev and tail.next = null to make sure tail is the last node
        tail = prev;
        tail.next = null;
        // length decreases everytime node removed
        length--;

        // Check if the list is empty after removing the last node
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    // removeFirst() will remove the node in the beginning of the list --------------------------------------------
    public Node removeFirst() {
        // Check if the list is empty
        if (length == 0)
            return null;
        // temp is to memory the head node that is removed
        Node temp = head;
        // the next node of head will become new head node
        head = head.next;
        // remove pointer of origin head
        temp.next = null;
        // length decreases everytime node removed
        length--;

        // Check if the list is empty after removing the last node
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    // get the value of the node by index -----------------------------------------------------------------------
    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // set the value of the existing node by index --------------------------------------------------------------
    public boolean set(int index, int value) {
        // Find the node of the index
        Node temp = get(index);
        // Check if the index out of bound
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    // insert a node in the list ---------------------------------------------------------------------------------
    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        // Create a new node
        Node newNode = new Node(value);
        // Find the node before the index
        Node temp = get(index - 1);
        // newNode point to the origin node of the index (which is the next node of temp)
        newNode.next = temp.next;
        // temp point to newNode
        temp.next = newNode;
        // length increases everytime node added
        length++;

        return true;
    }

    // remove a node by index -----------------------------------------------------------------------------------
    public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }
        // prev = the node before the removed node
        Node prev = get(index - 1);
        // temp = the removed node
        Node temp = prev.next;
        // the next node of prev point to the next node of temp (removed node)
        prev.next = temp.next;
        // the next node of temp (removed node) point to null
        temp.next = null;
        // length decreases everytime node removed
        length--;

        return temp;
    }

    // reverse the list ---------------------------------------------------------------------------------------
    public void reverse() {
        if (length <= 1)
            return;

        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    // displayList() will display all the nodes present in the list ----------------------------------------------
    public void displayList() {
        // Node current will point to head
        Node current = head;

        if (current == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of single linked list: ");
        while (current != null) {
            // Prints each node by incrementing pointer
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }
    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }
    public void getLength() {
        System.out.println("Length: " + length);
    }

    public static void main(String[] args) {

        SinglyLinkedList sll = new SinglyLinkedList();

        // Add nodes to the end of the list
        sll.append(1);
        sll.append(2);
        sll.append(3);

        // Displays the nodes present in the list
        sll.displayList();
        sll.getHead();
        sll.getTail();
        sll.getLength();

        // remove the node in the end of the list
        System.out.println("the last node '" + sll.removeLast().value + "' is removed");
        sll.displayList();

        // Add nodes to the head of the list
        sll.prepend(5);
        sll.displayList();

        // remove the node in the head of the list
        System.out.println("the first node '" + sll.removeFirst().value + "' is removed");
        sll.displayList();

        // get the node by index
        System.out.println("the value of index 1 in the list is: " + sll.get(1).value);

        // set the value of existing node to another value
        System.out.println(sll.set(1, 3) ? "update success" : "update fail");
        sll.displayList();

        // insert a node in the list
        System.out.println(sll.insert(1, 2) ? "insert success" : "insert fail");
        sll.displayList();

        // remove a node in the list
        System.out.println("the value if index 1 '" + sll.remove(1).value + "' is removed");
        sll.displayList();

        sll.append(11);
        sll.append(12);
        sll.append(13);
        sll.append(14);
        sll.append(15);
        sll.append(16);
        sll.append(17);

        // reverse the list
        sll.reverse();
        sll.displayList();

    }
}
