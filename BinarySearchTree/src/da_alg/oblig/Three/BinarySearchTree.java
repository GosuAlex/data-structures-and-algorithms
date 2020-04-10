package da_alg.oblig.Three;

import java.util.ArrayList;

public class BinarySearchTree {

    private Node root;

    BinarySearchTree(int data) {
        root = new Node(data);
    }
    BinarySearchTree() {
        root = null;
    }

    ArrayList<Integer> readBST() {

        ArrayList<Integer> dataArray = new ArrayList<>();
        ArrayList<Node> nodeQueue = new ArrayList<>();
        ArrayList<Node> level = new ArrayList<>();

        nodeQueue.add(root);

        while(nodeQueue.size() > 0) {

            level.addAll(nodeQueue);
            nodeQueue.clear();

            for(Node item : level) {
                dataArray.add(item.data);

                if(item.left != null) {
                    nodeQueue.add(item.left);
                }
                if(item.right != null) {
                    nodeQueue.add(item.right);
                }
            }

            level.clear();
        }

        return dataArray;
    }

    int findMinNumber() {

        int minNumber = root.data;
        Node searchNode = root;

        while(searchNode.left != null) {
             searchNode = searchNode.left;
             minNumber = searchNode.data;
        }

        return minNumber;
    }

    int findMaxNumber() {

        int maxNumber = root.data;
        Node searchNode = root;

        while(searchNode.right != null) {
            searchNode = searchNode.right;
            maxNumber = searchNode.data;
        }

        return maxNumber;
    }

    boolean searchNumber(int searchNumber) {

        Node searchNode = root;

        while(searchNode.left != null || searchNode.right != null) {
            if(searchNode.data == searchNumber)
                return true;

            if(searchNode.data > searchNumber) {
                searchNode = searchNode.left;
            } else if (searchNode.data < searchNumber) {
                searchNode = searchNode.right;
            }
        }

        return searchNode.data == searchNumber;
    }

    // extra
    boolean binarySearch(int n) {

        // build array from tree

        /* this looks like depth first. No its not because  it adds left then right. If you have add as add first then you could do left always first and its correct depth
        while(nodeQueue.get(0) != null) {
            dataArray.add(nodeQueue.get(0).data);

            nodeQueue.add(nodeQueue.get(0).left);
            nodeQueue.add(nodeQueue.get(0).right);

            nodeQueue.remove(0);
        }
        */

        return false;
    }

    void insertNumber(int n) {
        if(root == null) {
            root = new Node(n);
            return;
        }

        Node searchNode = root;
        Node newNode = new Node(n);

        while(searchNode != null) {
            if(newNode.data < searchNode.data) { // new data is lesser: go left.
                if(searchNode.left != null) { // if position to the right already has a node placed: Use that node as search node.
                    searchNode = searchNode.left;
                } else {
                    searchNode.left = newNode; // place new node
                    break;
                }

            } else if(newNode.data > searchNode.data) { // new data is greater: go right.
                if(searchNode.right != null) { // if position to the right already has a node placed: Use that node as search node.
                    searchNode = searchNode.right;
                } else {
                    searchNode.right = newNode; // place new node
                    break;
                }
            }
        }

    }


}

class Node {

    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}