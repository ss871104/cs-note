package data_structure;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public void displayTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("  {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    // Hash Method
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            // times 23 because it is a prime number, can get more random numbers
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void put(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            // if collision happens, use Separate Chaining to move the newNode to next (Linked list)
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    // get all keys in the hash table
    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public static void main(String[] args) {
        HashTable table = new HashTable();

        table.put("nails", 100);
        table.put("tile", 50);
        table.put("lumber", 80);
        table.put("paint", 20);
        table.put("bolts", 40);

        table.displayTable();

        System.out.println(table.get("nails"));
        System.out.println(table.get("tile"));
        System.out.println(table.get("lumber"));

        System.out.println(table.keys());

    }
}
