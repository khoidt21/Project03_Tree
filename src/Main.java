
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author ADMIN
 */
public class Main {
    
     
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //boolean mainLoop = true;
        MyProduct myProduct = new MyProduct();

        int choice = 0;
        do {
            System.out.println("Product List");
            System.out.println("1. Insert a new product");
            System.out.println("2. In-order traverse");
            System.out.println("3. Breadth first traverse");
            System.out.println("4. Search by a product code");
            System.out.println("5. Delete by a product code");
            System.out.println("6. Simple balancing");
            System.out.println("7. Count number of products");
            System.out.println("8. Search product the price is higher or equal to the price provided");
            System.out.println("9. Calculate show root of tree width height");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            try {
                choice = input.nextInt();
                if (choice < 1 || choice > 9) {
                    System.out.printf("You have not entered a number between 0 and 9. " + "Try again.\n");
                    System.out.printf("Enter your choice between 0 and 9 only: \n");
                    continue;
                }

                switch (choice) {

                    case 1:
                        // insert a new product
                        myProduct.insert();
                        break;
                    case 2:
                        // inOrder
                        myProduct.inOrder();
                        break;
                    case 3:
                        // breadth first traverse 
                        myProduct.BFT();
                        break;
                    case 4:
                        // search
                        myProduct.search();
                        break;
                    case 5:
                        // delete
                        myProduct.delete();
                        break;
                    case 6:
                        // simple balancung
                        myProduct.balance();
                        break;
                    case 7:
                        // count number of products
                        myProduct.printSizeProducts();
                        break;
                    case 8:
                        // search by price is higher or equal price provided
                        myProduct.searchPriceIsHigherOrEqualPriceProvided();
                        break;
                    case 9:
                        // show root width height
                        myProduct.calPrintTreeHeight();
                        break;
                    case 0:
                        System.out.println("Exiting Program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println(choice + " is not a valid Menu Option! Please Select Another.");

                }
            } catch (InputMismatchException ex) {
                System.out.println("You have entered choice is number. Try again.");
                break;
            }

        } while (choice != 0);

    
    }
}
