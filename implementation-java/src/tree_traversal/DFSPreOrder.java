package tree_traversal;

import data_structure.BinarySearchTree;

public class DFSPreOrder {
    // please check DFSPreOrder function in BinarySearchTree.java

    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println(myBST.DFSPreOrder());
    }
}
