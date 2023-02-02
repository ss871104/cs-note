package data_structure;

public class DoublyLinkedList {
    // Represent the head, tail and length of the single linked list
    private Node head;
    private Node tail;
    private int length;

    // A node class for doubly linked list
    class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // add a node to the end of the list --------------------------------------------------------------------------
    public void append(int value) {
        // Create a new node
        Node newNode = new Node(value);

        // if list is empty, head and tail points to newNode
        if (head == null) {
            head = tail = newNode;
        }
        else {
            // add newNode to the end of list. tail -> next set to newNode
            tail.next = newNode;
            // newNode -> previous set to tail
            newNode.prev = tail;
            // newNode becomes new tail
            tail = newNode;
            // tail's next point to null
            tail.next = null;
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
            head = tail = newNode;
        } else {
            // newNode will be added before head, newNode will point to head
            newNode.next = head;
            // origin head previous -> newNode
            head.prev = newNode;
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

        // temp is origin tail
        Node temp = tail;

        // Check if the list is empty after removing the last node
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            // origin tail previous -> new tail
            tail = tail.prev;
            // cut off temp
            tail.next = null;
            temp.prev = null;
        }
        // length decreases everytime node removed
        length--;

        return temp;
    }

    // removeFirst() will remove the node in the beginning of the list --------------------------------------------
    public Node removeFirst() {
        // Check if the list is empty
        if (length == 0)
            return null;
        // temp is to memory the head node that is removed
        Node temp = head;

        // Check if the list is empty after removing the last node
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            // the next node of head will become new head node
            head = head.next;
            // remove pointer of origin head
            head.prev = null;
            temp.next = null;
        }
        // length decreases everytime node removed
        length--;

        return temp;
    }

    // get the value of the node by index -----------------------------------------------------------------------
    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;

        Node temp = head;
        if (index < length/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
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
        Node before = get(index - 1);
        Node after = before.next;
        // newNode point to the origin node of the index (which is the next node of temp)
        newNode.prev = before;
        newNode.next = after;
        // temp point to newNode
        before.next = newNode;
        after.prev = newNode;
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
        // temp = the removed node
        Node temp = get(index);
        // the next node of temp node (removed node) point to the node before temp node
        temp.next.prev = temp.prev;
        // the node before temp node (removed node) point to the node after temp node
        temp.prev.next = temp.next;
        // the next node of temp (removed node) point to null
        temp.next = null;
        temp.prev = null;
        // length decreases everytime node removed
        length--;

        return temp;
    }

    // Displays all the nodes in the list ------------------------------------------------------------------------
    public void displayList() {
        // Node current will point to head
        Node current = head;
        if (current == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            // Print each node and then go to next.
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
        // create a DoublyLinkedList object
        DoublyLinkedList dll = new DoublyLinkedList();
        // Add nodes to the list
        dll.append(10);
        dll.append(20);
        dll.append(30);

        // Displays all the nodes present in the list
        dll.displayList();
        dll.getHead();
        dll.getTail();
        dll.getLength();

        // remove the node in the end of the list
        System.out.println("the last node '" + dll.removeLast().value + "' is removed");
        dll.displayList();

        // Add nodes to the head of the list
        dll.prepend(50);
        dll.displayList();

        // remove the node in the head of the list
        System.out.println("the first node '" + dll.removeFirst().value + "' is removed");
        dll.displayList();

        // get the node by index
        System.out.println("the value of index 1 in the list is: " + dll.get(1).value);

        // set the value of existing node to another value
        System.out.println(dll.set(1, 30) ? "update success" : "update fail");
        dll.displayList();

        // insert a node in the list
        System.out.println(dll.insert(1, 20) ? "insert success" : "insert fail");
        dll.displayList();

        // remove a node in the list
        System.out.println("the value if index 1 '" + dll.remove(1).value + "' is removed");
        dll.displayList();

    }
}
