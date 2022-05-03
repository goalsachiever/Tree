package com.company.BT;
import java.util.*;

class BinaryNode
{
    int value;
    BinaryNode left;
    BinaryNode right;
    public BinaryNode(int value)
    {
        this.value = value;
        left=null;
        right=null;
    }
    public BinaryNode()
    {

    }
}

public class BinaryTreeByLinkedList
{
    BinaryNode root;
    BinaryTreeByLinkedList()
    {
        root = null;
    }

    public void insert(int value)
    {
        BinaryNode newNode = new BinaryNode(value);
        if(root == null)
        {
            root = newNode;
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode curr = new BinaryNode();
        while (queue.isEmpty()==false)
        {
            curr = queue.remove();
            if(curr.left==null)
            {
                curr.left = newNode;
                break;
            }
            else if(curr.right==null)
            {
                curr.right = newNode;
                break;
            }
            else
            {
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
    }

    public void preorder(BinaryNode root)
    {
        if(root == null)
            return;
        System.out.println(root.value);
        preorder(root.left);
        preorder(root.right);
    }
    public void inorder(BinaryNode root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }
    public void postorder(BinaryNode root)
    {
        if(root == null)
        {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.value);
    }

    public void levelorder()
    {
        if(root == null)
            return;
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode curr = new BinaryNode();
        while (queue.isEmpty()==false)
        {
            curr = queue.remove();
            System.out.println(curr.value);
            if(curr.left != null)
            {
                queue.add(curr.left);
            }
            if(curr.right!=null)
            {
                queue.add(curr.right);
            }
        }
    }

    public  void search (int value)
    {
        BinaryNode newNode = new BinaryNode(value);
        Queue<BinaryNode> queue = new LinkedList<>();
        BinaryNode curr = new BinaryNode();
        while (queue.isEmpty()==false)
        {
            curr= queue.remove();
            if(curr.value== newNode.value)
            {
                System.out.println("search value is found");
                return;
            }
            else {
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

        }
        System.out.println("value not found");
    }

    public BinaryNode deepestNode()
    {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode curr = new BinaryNode();
        while (queue.isEmpty()==false)
        {
            curr=queue.remove();
            if(curr.left!=null)
            {
                queue.add(curr.left);
            }
            if(curr.right!=null)
            {
                queue.add(curr.right);
            }
        }
        return curr;
    }

    //Method to delete DeepestNode in Binary Tree
    public void deleteDeepestNode(BinaryNode node){
        Queue<BinaryNode>queue = new LinkedList<>();
        queue.add(root);
        BinaryNode currentNode = new BinaryNode();
        while (queue.isEmpty() == false){
            currentNode = queue.remove();
            if(currentNode == node){
                currentNode = null;
                return;
            }
            if(currentNode.left != null){
                if(currentNode.left == node){
                    currentNode.left = null;
                    return;
                }
                else {
                    queue.add(currentNode.left);
                }
            }
            if(currentNode.right != null){
                if(currentNode.right == node){
                    currentNode.right = null;
                    return;
                }
                else {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    //Delete Method to delete a node in Binary Tree using LevelOrder Traversal
    public void delete(int s){
        Queue<BinaryNode>queue = new LinkedList<>();
        queue.add(root);
        BinaryNode currentNode = new BinaryNode();
        while (queue.isEmpty() == false){
            currentNode = queue.remove();
            if(currentNode.value == s){
                currentNode.value = deepestNode().value;
                deleteDeepestNode(deepestNode());
                System.out.println("Value Deleted Successfully");
                return;
            }
            else{
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
        }
        System.out.println("Value is not present in the Binary Tree");
    }



}