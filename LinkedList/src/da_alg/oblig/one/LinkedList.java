package da_alg.oblig.one;

import java.util.*;

public class LinkedList {

    private Node head = null;
    private Node tail = null;

    enum Position {
        BEFORE,
        EXACT,
        AFTER
    }


    public LinkedList() {

    }

    public int removeAtStart() {
        // if head pointer is pointing to nothing, exit -1.
        if(head == null)
            return -1;

        int value;

        if(head.next == null) {
            value = head.data;
            head = null;
            tail = null;
        } else {
            value = head.data;
            head = head.next;
        }

        return value;
    }

    public int addAtEnd(int data) {
        if(data < 0) // only positive signed numbers will be accepted
            return -1; // returns failed result

        Node newNode = new Node(data);
        newNode.next = null;

        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        return 1; // returns successful result
    }

    public int removeAtEnd() {
        if(head == null) {
            return -1;
        }

        int value;

        if(head.next == null) {
            value = head.data;
            head = null;
            tail = null;
        } else {
            Node nextToLastNode = head;
            while(nextToLastNode.next.next != null) {
                nextToLastNode = nextToLastNode.next;
            }

            value = tail.data;
            nextToLastNode.next = null;
            tail = nextToLastNode;
        }

        return value;
    }

    public int removeSpecificItem(int value, String position) {
        if(head == null)
            return -1;
        if(head.data == value) {
            removeAtStart();
            return 1;
        }
        if(tail.data == value) {
            removeAtEnd();
            return 1;
        }

        int foundOrNot = -1;
        Node searchNode = head;
        Node previousSearchNode = null;
        while(searchNode.next != null) {
            if(searchNode.next.data == value) {
                foundOrNot = 1;
                break;
                // notice that searchNode is the node before node with found value.
            }
            previousSearchNode = searchNode;
            searchNode = searchNode.next;
        }

        if(foundOrNot == -1)
            return foundOrNot;

        // before and after is not used, also make use of the ENUM probably
        if(position == "BEFORE") {
            previousSearchNode.next = searchNode.next;
        }
        if(position == "EXACT") {
            searchNode.next = searchNode.next.next;
        }
        if(position == "AFTER") {
            searchNode.next = searchNode.next.next.next;
        }

        return foundOrNot;
    }

    public int putAtSpecificPosition(int value, int searchValue, String position) {
        if(head == null)
            return -1;

        int foundOrNot = -1;
        Node searchNode = head;
        while(searchNode.next != null) {
            if(searchNode.next.data == searchValue) {
                foundOrNot = 1;
                break;
                // notice that searchNode is the node before node with found value.
            }
            searchNode = searchNode.next;
        }

        Node newNode = new Node(value);

        if(position == "BEFORE") {
            newNode.next = searchNode.next;
            searchNode.next = newNode;
        }
        if(position == "AFTER") {
            newNode.next = searchNode.next.next;
            searchNode.next.next = newNode;
        }

        return foundOrNot;
    }

    public int getListLength() {
        if(head == null)
            return -1;

        int count = 0;
        Node searchNode = head;
        while(searchNode != null) {
            searchNode = searchNode.next;
            count++;
        }

        return count;
    }

    public int getOccurrencesOfItemsWithValue(int value) {
        if(head == null)
            return -1;

        int count = 0;
        Node searchNode = head;
        while(searchNode != null) {
            if(searchNode.data == value) {
                count++;
            }
            searchNode = searchNode.next;
        }

        return count == 0 ? -1 : count;
    }

    public ArrayList<Integer> printList() {
        ArrayList<Integer> arr = new ArrayList();
        if(head == null)
            return arr;

        Node searchNode = head;
        while(searchNode.next != null) {
            arr.add(searchNode.data);
            searchNode = searchNode.next;
        }

        arr.add(searchNode.data);

        return arr;
    }

    public int deleteList() {
        if(head == null)
            return -1;

        int numberOfDeletedItems = getListLength();

        head = null;
        tail = null;

        return numberOfDeletedItems;
    }
}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}


