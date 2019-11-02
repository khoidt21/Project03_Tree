/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Product;
import java.util.ArrayList;
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
            System.out.print(p.info + "\n");
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

    public void searchInOrderPrice(double price) {
        inOrderTreeSearchPrice(root, price);
    }
    public void inOrderTreeSearchPrice(Node<Product> root, double price) {
        if (root == null) {
            return;
        }
        inOrderTree(root.left);
        if (root.info.getPrice() >= price) {
            System.out.println(root.info + " ");
        }
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
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node<Product> p;
        while (!q.isEmpty()) {
            p = (Node<Product>) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            visit(p);
        }
    }

    //insert a new Product to a tree
    public void insert(Product product) {
        if (root == null) {
            root = new Node(product);
            return;
        }
        Node<Product> f, p;
        p = root;
        f = null;
        while (p != null) {
            if (p.info.getCode().compareTo(product.getCode()) == 0) {
                System.out.println(" The key " + product.getCode() + " already exists, no insertion");
                return;
            }
            f = p;
            if (product.getCode().compareTo(p.info.getCode()) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (product.getCode().compareTo(f.info.getCode()) < 0) {
            f.left = new Node(product);
        } else {
            f.right = new Node(product);
        }
    }

    //balance a tree
    //step 1: traverse inorder tree and copy all item on tree to an arraylist
    //step 2: insert all items of list to a tree
    private void buildArray(List<Node<Product>> list, Node<Product> p) {
        if (p == null) {
            return;
        }
        buildArray(list, p.left);
        list.add(p);
        buildArray(list, p.right);
    }

    //step 2:
    private void balance(List<Node<Product>> list, int f, int l) {
        if (f > l) {
            return;
        }
        int mid = (f + l) / 2;
        Node<Product> p = list.get(mid);
        insert(p.info);
        balance(list, f, mid - 1);
        balance(list, mid + 1, l);
    }

    public void balance() {
        List<Node<Product>> list = new ArrayList<>();
        buildArray(list, root);
        MyBSTree tree = new MyBSTree();
        tree.balance(list, 0, list.size() - 1);
        root = tree.root;
    }

    //search a Node of tree by product code
    //return null if given code does not exists
    public Node<Product> search(String code) {
        if (isEmpty()) {
            return null;
        }
        Node<Product> p = root;
        while (p != null) {
            if (p.info.getCode().equalsIgnoreCase(code)) {
                break;
            }
            if (p.info.getCode().compareToIgnoreCase(code) < 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return p;
    }

    //delete a node by a given product code
    public void delete(String code) {
        root = deleteRec(root, code);
    }

    Node deleteRec(Node<Product> root, String key) {
        if (root == null) {
            return root;
        }
        if (key.compareTo(root.info.getCode()) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo(root.info.getCode()) < 0) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.info = minValue(root.right);
            root.right = deleteRec(root.right, root.info.getCode());
        }
        return root;
    }

    Product minValue(Node<Product> root) {
        Product minv = root.info;
        while (root.left != null) {
            minv = root.left.info;
            root = root.left;
        }
        return minv;
    }

}
