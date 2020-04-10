package da_alg.oblig.Three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree BST = new BinarySearchTree();
        Scanner console = new Scanner(System.in);

        // seed tree with default data
        List<Integer> arr = Arrays.asList(100,35,120,10,40,110,140,5,11,37,48,105,111,130,200);
        for(int item : arr) {
            BST.insertNumber(item);
        }

        System.out.println("BST tree contains:");

        ArrayList<Integer> A = BST.readBST();
        for(int item : A) {
            System.out.print(item + ", ");
        }
        System.out.println();

        System.out.print("The minimum number found in BST: ");
        System.out.println(BST.findMinNumber());

        System.out.print("The maximum number found in BST: ");
        System.out.println(BST.findMaxNumber());

        System.out.println("Input the number you want to check for in BST");
        int userInput = console.nextInt();
        System.out.print("Found number " + userInput + " in BST: ");
        System.out.println(BST.searchNumber(userInput));

        System.out.println();
        System.out.println("Exiting...");
    }
}
