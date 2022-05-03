package com.company;

import java.util.Scanner;

public class BinaryTreeByArray
{
    int[] binaryTree;
    int lastUsedIndex;
    public  BinaryTreeByArray(int size)
    {
        binaryTree = new int[size+1];
        lastUsedIndex = 0;
    }

    public  boolean isFull()
    {
        if(binaryTree.length-1 == lastUsedIndex)
        {
            return true;
        }
        return false;
    }

    public  void insert(int value)
    {
        if(isFull())
        {
            System.out.println("Value can't be inserted becox binary tree is full");
            return;
        }
        binaryTree[lastUsedIndex+1]=value;
        lastUsedIndex++;
        return;
    }
    public void levelOrder()
    {

        for (int i = 1; i <=lastUsedIndex ; i++)
        {
            System.out.println(binaryTree[i]+" ");
        }
    }
    public void preorder(int index)
    {
        if(index > lastUsedIndex)
        {
            return;
        }
        System.out.print(binaryTree[index]+" ");
        preorder(2*index);
        preorder(2*index+1);
    }
    public void inorder(int index)
    {
        if(index > lastUsedIndex)
        {
            return;
        }
        inorder(2*index);
        System.out.print(binaryTree[index]+" ");
        inorder(2*index+1);
    }
    public void postorder(int index)
    {
        if(index > lastUsedIndex)
        {
            return;
        }

        postorder(2*index);
        postorder(2*index+1);
        System.out.print(binaryTree[index]+" ");
    }

    public void delete(int value)
    {
        int i,c=-1;
        for (i = 1; i <= lastUsedIndex; i++)
        {
            if(binaryTree[i]==value)
                c=i;
        }
        if(c==-1)
        {
            System.out.println("could not found an elemnt");
            return;
        }
        binaryTree[c]=binaryTree[lastUsedIndex];
        lastUsedIndex--;
    }
}


class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinaryTreeByArray t1 = new BinaryTreeByArray(n);
        for (int i = 0; i < n; i++)
        {
            t1.insert(sc.nextInt());
        }
        t1.preorder(1);
        System.out.println();
        t1.inorder(1);
        System.out.println();
        t1.postorder(1);
        System.out.println();
        t1.levelOrder();
        System.out.println();
        t1.delete(1);
        t1.levelOrder();

    }
}
