/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Product;
import java.util.InputMismatchException;
import java.util.Scanner;
import util.MyBSTree;

/**
 *
 * @author ADMIN
 */
public class MyProduct {

    //a list of products
    MyBSTree tree;

    public MyProduct() {
        tree = new MyBSTree();
    }

    //1.1 input and insert a new product to tree
    public void insert() {
        Product product = new Product();
        String code = null;
        String name = null;
        boolean check = true;

        System.out.println("Enter input information book. ");

        Scanner scanner = new Scanner(System.in);
        // code
        while ((code == null) || (code.trim().isEmpty())) {
            System.out.println("Input code: ");
            code = scanner.nextLine();
        }
        product.setCode(code);

        // name 
        while ((name == null) || (name.trim().isEmpty())) {
            System.out.println("Input name: ");
            name = scanner.nextLine();
        }
        product.setName(name);

        // quantity
        do {
            try {
                System.out.println("Input quantity:");
                product.setQuantity(scanner.nextInt());
                check = false;
            } catch (InputMismatchException e) {
                System.out.println("Quantity is number.Input quantity");
                check = true;
                scanner.nextLine();
            }
        } while (check);

        // saled 
        do {
            try {
                System.out.println("Input saled:");
                product.setSaled(scanner.nextInt());
                check = false;
            } catch (InputMismatchException e) {
                System.out.println("Saled is number.Input saled");
                check = true;
                scanner.nextLine();
            }
        } while (check);

        // price
        do {
            try {
                System.out.println("Input price:");
                product.setPrice(scanner.nextDouble());
                check = false;
                scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Price is number.Input price");
                check = true;
                scanner.nextLine();
            }

        } while (check);

        tree.insert(product);

    }

    //1.2 in-order traverse
    public void inOrder() {
        tree.inOrder();
    }

    //1.3 BFT a tree
    public void BFT() {
        tree.BFT();
    }

    //1.4 search a product by product code
    public void search() {
        String code;
        System.out.println("Enter product code to search:");
        Scanner input = new Scanner(System.in);
        code = input.nextLine();

        if (tree.search(code) != null) {
            System.out.println("Inforation of product code " + code);
            System.out.println(tree.search(code).info);
        } else {
            System.out.println("Product is not in system.");
        }
    }

    public void searchPrice() {
        double price = 0;
        boolean check = true;
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter product price to search:");

                price = input.nextDouble();
                check = false;
                input.nextLine();
            } catch (InputMismatchException ex) {
                System.out.println("Price is number.Input price");
                check = true;
                input.nextLine();
            }
        } while (check);
        System.out.println("Inforation of product price " + price);
        tree.searchInOrderPrice(price);

    }

    //1.5 delete a product by product code
    public void delete() {
        String code;
        System.out.println("Enter product code to delete:");
        Scanner input = new Scanner(System.in);
        code = input.nextLine();
        tree.delete(code);
        System.out.println("Product code " + code + " " + "has been deleted");

    }

    //1.6 simply balancing a tree
    public void balance() {
        tree.balance();
    }

    //1.7 count the number of products in the tree
    public int size() {
        return tree.count();
    }

    // print size products in the tree
    public void printSizeProducts() {
        System.out.println("Number of products " + size());
    }
}
