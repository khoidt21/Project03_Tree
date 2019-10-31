/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Product;
import java.util.List;

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
        throw new UnsupportedOperationException("Remove this line and implement your code here!");
    }
    
    //return true if tree is empty otherwise return false
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Remove this line and implement your code here!");
    }

    //inorder a tree
    public void inOrder() {
        throw new UnsupportedOperationException("Remove this line and implement your code here!");
    }

    //count number of products
    public int count() {
        throw new UnsupportedOperationException("Remove this line and implement your code here!");
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
