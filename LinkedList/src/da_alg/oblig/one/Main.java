package da_alg.oblig.one;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        boolean greenLight = true;
        // Console console = System.console();
        Scanner console = new Scanner(System.in);

        System.out.println("Welcome to LinkedList console program.");
        System.out.println("Press a number to continue.");

        while (greenLight) {

            System.out.println();
            System.out.println("0: end program");
            System.out.println("1: remove item at start of list");
            System.out.println("2: add item at end of list");
            System.out.println("3: remove item at end of list ");
            System.out.println("4: remove item with given value");
            System.out.println("5: add item after an item with given value");
            System.out.println("6: add item before an item with given value");
            System.out.println("7: get list length");
            System.out.println("8: get the count of occurrences items with given value");
            System.out.println("9: print list");
            System.out.println("10: delete list");
            System.out.println();

            int userInput = console.nextInt();
            int valueInput;
            int searchValue;
            int result;

            switch (userInput) {
                case 0:
                    greenLight = false;
                    System.out.println("Exiting...");
                    break;
                case 1:
                    result = ls.removeAtStart();
                    if(result == -1) {
                        System.out.println("LinkedList is empty !");
                    } else {
                        System.out.println("First item was removed. It had the value : " + result);
                    }
                    break;
                case 2:
                    System.out.println("Enter value to input :");
                    valueInput = console.nextInt();
                    result = ls.addAtEnd(valueInput);
                    if(result == -1) {
                        System.out.println("Could not input given value !");
                    } else {
                        System.out.println("Success");
                    }
                    break;
                case 3:
                    result = ls.removeAtEnd();
                    if(result == -1) {
                        System.out.println("LinkedList is empty !");
                    } else {
                        System.out.println("Last item was removed. It had the value : " + result);
                    }
                    break;
                case 4:
                    System.out.println("Enter value to find and remove :");
                    int valueRemove = console.nextInt();
                    result = ls.removeSpecificItem(valueRemove, "EXACT");
                    if(result == -1) {
                        System.out.println("Could not find an item with that value !");
                    } else {
                        System.out.println("An item was removed with the value : " + valueRemove);
                    }
                    break;
                case 5:
                    System.out.println("Enter value to input in the new item :");
                    valueInput = console.nextInt();
                    System.out.println("New item will be put after an item with value you can enter now: ");
                    searchValue = console.nextInt();
                    result = ls.putAtSpecificPosition(valueInput, searchValue, "AFTER");
                    if(result == -1) {
                        System.out.println("Could not find an item with that value !");
                    } else {
                        System.out.println("An item was put with the value : " + valueInput);
                    }
                    break;
                case 6:
                    System.out.println("Enter value to input in the new item :");
                    valueInput = console.nextInt();
                    System.out.println("New item will be put before an item with value you can enter now: ");
                    searchValue = console.nextInt();
                    result = ls.putAtSpecificPosition(valueInput, searchValue, "BEFORE");
                    if(result == -1) {
                        System.out.println("Could not find an item with that value !");
                    } else {
                        System.out.println("An item was put with the value : " + valueInput);
                    }
                    break;
                case 7:
                    result = ls.getListLength();
                    if(result == -1) {
                        System.out.println("Error: maybe linkedList is empty...");
                    } else {
                        System.out.println("LinkedList length : " + result);
                    }
                    break;
                case 8:
                    System.out.println("Enter value to search for :");
                    valueInput = console.nextInt();
                    result = ls.getOccurrencesOfItemsWithValue(valueInput);
                    if(result == -1) {
                        System.out.println("Could not find an item with that value !");
                    } else {
                        System.out.println("Occurrences of items with value found : " + result);
                    }
                    break;
                case 9:
                    ArrayList<Integer> arr = ls.printList();
                    System.out.println("List contains :");
                    for (int value : arr) {
                        System.out.println(value);
                    }
                    break;
                case 10:
                    result = ls.deleteList();
                    if(result == -1) {
                        System.out.println("Error: maybe linkedList is empty...");
                    } else {
                        System.out.println("All items in linkedList was deleted. Number of item deleted : " + result);
                    }
                    break;
                default:
                    System.out.println("Could not find a number between 0-10 from input.");
                    break;
            }
        }

        System.exit(0);
    }
}
