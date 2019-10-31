/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Product;
import java.util.List;
import javax.swing.tree.TreeNode;

/**
 *
 * @author ADMIN
 */
public class MyBSTree {

    //a root of tree
    Node<Product> root;

    public MyBSTree() {
        root = null;
    }

    //visit a node of a tree -> output information of visited node
    public void visit(Node<Product> p) {
        if (p != null) {
            System.out.print(p.info + " ");
        }
    }

    //return true if tree is empty otherwise return false
    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    //inorder a tree
    public void inOrder() {
        inOrderTree(root);
    }

    public void inOrderTree(Node<Product> root) {
        if (root == null) {
            return;
        }
        inOrderTree(root.left);
        System.out.println(root.info + " ");
        inOrderTree(root.right);
    }

    //count number of products
    public int count() {
        return getfullCount(root);
    }

    public int getfullCount(Node<Product> root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        res += (getfullCount(root.left) + getfullCount(root.right));
        return res;
    }
    
    //breadth-first traverse a tree
    public void BFT() {
        throw new UnsupportedOperationException("Remove this line and implement your code here!");
    }

    //insert a new Product to a tree
    public void insert(Product product) {
        throw new UnsupportedOperationException("Remove this line and implement your code here!");
    }

    //balance a tree
    //step 1: traverse inorder tree and copy all item on tree to an arraylist
    //step 2: insert all items of list to a tree
    private void buildArray(List<Node<Product>> list, Node<Product> p) {
        throw new UnsupportedOperationException("Remove this line and implement your code here!");
    }

    //step 2:
    private void balance(List<Node<Product>> list, int f, int l) {
        throw new UnsupportedOperationException("Remove this line and implement your code here!");
    }

    public void balance() {
        throw new UnsupportedOperationException("Remove this line and implement your code here!");
    }

    //search a Node of tree by product code
    //return null if given code does not exists
    public Node<Product> search(String code) {
        throw new UnsupportedOperationException("Remove this line and implement your code here!");
    }

    //delete a node by a given product code
    public void delete(String code) {
        throw new UnsupportedOperationException("Remove this line and implement your code here!");
    }

}
