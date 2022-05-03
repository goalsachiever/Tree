package com.company.BST;


public class Main {
    public static void main(String[] args) {
        BinarySearchTree m = new BinarySearchTree();

        m.insert(70);
        m.insert(50);
        m.insert(90);
        m.insert(30);
        m.insert(60);
        m.insert(80);
        m.insert(100);
        m.insert(20);
        m.insert(40);

        m.preOrderTraversal(m.root);
        System.out.println();

        m.inOrderTraversal(m.root);
        System.out.println();

        m.postOrderTraversal(m.root);
        System.out.println();

        m.levelOrderTraversal();
        System.out.println();

        m.search(80);
        m.search(8);

        m.delete(m.root, 70);
        m.levelOrderTraversal();



    }
}