package data_structure;

public class RecursiveBinarySearchTree {
    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null)
            return new Node(value);

        if (value < currentNode.value)
            currentNode.left = rInsert(currentNode.left, value);
        else if (value > currentNode.value)
            currentNode.right = rInsert(currentNode.right, value);

        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null)
            root = new Node(value);

        rInsert(root, value);
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null)
            return false;

        if (currentNode.value == value)
            return true;

        if (value < currentNode.value)
            return rContains(currentNode.left, value);
        else
            return rContains(currentNode.right, value);
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private Node rDelete(Node currentNode, int value) {
        if (currentNode == null)
            return null;

        if (value < currentNode.value)
            currentNode.left = rDelete(currentNode.left, value);
        else if (value > currentNode.value)
            currentNode.right = rDelete(currentNode.right, value);
        else {
            // if the deleting node has no node both on the left and on the right
            if (currentNode.left == null && currentNode.right == null)
                return null;
            // if the deleting node has a node on the right but no node on the left
            else if (currentNode.left == null)
                currentNode = currentNode.right;
            // if the deleting node has a node on the left but no node on the right
            else if (currentNode.right == null)
                currentNode =currentNode.left;
            // if the deleting node has nodes both on the right and on the left
            else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = rDelete(currentNode.right, subTreeMin);
            }
        }

        return currentNode;
    }

    public void rDelete(int value) {
        rDelete(root, value);
    }

    private int minValue(Node currentNode) {
        while (currentNode.left != null)
            currentNode = currentNode.left;

        return currentNode.value;
    }

    public static void main(String[] args) {
        RecursiveBinarySearchTree rBST = new RecursiveBinarySearchTree();

        rBST.rInsert(2);
        rBST.rInsert(1);
        rBST.rInsert(3);

        System.out.println("Root: " + rBST.root.value);
        System.out.println("Root -> Left: " + rBST.root.left.value);
        System.out.println("Root -> Right: " + rBST.root.right.value);

        System.out.println(rBST.rContains(3));
        System.out.println(rBST.rContains(4));

        rBST.rDelete(2);

        System.out.println("Root: " + rBST.root.value);
        System.out.println("Root -> Left: " + rBST.root.left.value);
        System.out.println("Root -> Right: " + rBST.root.right); // null
    }
}
