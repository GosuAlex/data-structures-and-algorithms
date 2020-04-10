package da_alg.oblig.Two;

import java.util.ArrayList;

public class Main {

    static Node listOneHead;
    static Node listOneTail;

    static Node listTwoHead;
    static Node listTwoTail;


    public static void main(String[] args) {
        seedLists();
        System.out.println("List one contains :");
        printList(listOneHead);
        System.out.println("List two contains :");
        printList(listTwoHead);
        System.out.println();

        System.out.println("Combining lists into one, sorted in ASC order");
        ArrayList<Node> listNew = combineLists(listOneHead, listTwoHead);
        System.out.println();

        System.out.println("New list contains :");
        printList(listNew.get(0));
    }

    private static void printList(Node head) {
        Node searchNode = head;
        int i = 0;

        while(searchNode != null) {
            System.out.println(searchNode.data + " | Position in list: " + i++);
            searchNode = searchNode.next;
        }
    }

    private static ArrayList<Node> combineLists(Node headOfListOne, Node headOfListTwo) {
        Node newListTail;
        Node newListHead;
        Node searchNodeOne;
        Node searchNodeTwo;

        if(headOfListOne.data < headOfListTwo.data) {
            Node newNode = new Node(headOfListOne.data);
            newListTail = newNode;
            searchNodeOne = headOfListOne.next;
            searchNodeTwo = headOfListTwo;
        } else {
            Node newNode = new Node(headOfListTwo.data);
            newListTail = newNode;
            searchNodeOne = headOfListOne;
            searchNodeTwo = headOfListTwo.next;
        }
        newListHead = newListTail;

        while(searchNodeOne != null || searchNodeTwo != null) {
            Node newNode;

            if(searchNodeOne == null || (searchNodeTwo != null && searchNodeOne.data > searchNodeTwo.data)) {
                newNode = new Node(searchNodeTwo.data);
                searchNodeTwo = searchNodeTwo.next;
            } else {
                newNode = new Node(searchNodeOne.data);
                searchNodeOne = searchNodeOne.next;
            }

            newListTail.next = newNode;
            newListTail = newListTail.next;
        }

        ArrayList<Node> arr = new ArrayList<>();
        arr.add(newListHead);
        arr.add(newListTail);

        return arr;
    }

    private static void seedLists() {
        Node one = new Node(5);
        Node two = new Node(10);
        Node three = new Node(15);
        Node q = new Node(31);
        listOneHead = one;
        listOneHead.next = two;
        listOneHead.next.next = three;
        listOneHead.next.next.next = q;
        listOneTail = q;
        Node four = new Node(2);
        Node five = new Node(3);
        Node six = new Node(20);
        Node a = new Node(31);
        Node s = new Node(34);
        Node d = new Node(35);
        listTwoHead = four;
        listTwoHead.next = five;
        listTwoHead.next.next = six;
        listTwoHead.next.next.next = a;
        listTwoHead.next.next.next.next = s;
        listTwoHead.next.next.next.next.next = d;
        listTwoTail = d;
    }
}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}