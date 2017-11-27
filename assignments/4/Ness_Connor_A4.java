/*
Filename: Ness_Connor_A4.java
Author: Connor Ness
Date: November 26, 2017

This program takes a string input from the user and builds a binary tree from
each of the characters. Leaves represent each unique character. Each node of the
tree has a string containing its letter(s), and a weight representing the
frequency with which that character occurred in the user's input.

My interpretation of the assignment instructions led me to create my own,
"Custom" node class, as opposed to using the built-in Java library.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Ness_Connor_A4 {
    private static Scanner input = new Scanner(System.in);
    // We use an arraylist to contain the nodes
    private static ArrayList<CustNode> custNodes = new ArrayList<>();


    // The main function does most of the heavy lifting.
    public static void main(String[] args) {

        // We get the input from the user, and store as an array of characters
        System.out.println("Please input a string of characters: ");
        char[] chars = getStringInput().toCharArray();

        // for each element in the array, we create a leaf node
        for (char aChar : chars) {
            addLeaf(aChar);
        }

        // we then sort the arraylist of nodes and print it
        sortList(custNodes);
        printList(custNodes);

        // we prompt the user to press enter. any extra characters are ignored
        System.out.println("Ready to begin. Press enter to continue...");
        input.nextLine();

        // while the list has more than one element, we are reducing it
        while(custNodes.size() > 1) {
            // we're "popping" the first node in the list from the list
            CustNode x = custNodes.get(0);
            custNodes.remove(0);
            int i = 0;
            // we only want to combine the first node with another node of the
            // same size or larger, except when there are too few nodes
            while(x.getLevel() > custNodes.get(i).getLevel()
                    && i < custNodes.size() - 1) {
                i++;
            }
            // we pop that next node
            CustNode y = custNodes.get(i);
            custNodes.remove(i);

            // create a new node which will be the parent of the two we popped
            CustNode z;

            // to make sure that left and right orientation of nodes is
            // preserved in the tree, check if the first node's level, or number
            // of characters is greater than or equal to the second. If it is,
            // the first node is the left child and the second node is the right
            // Otherwise, the opposite is true.
            if(x.getLevel() >= y.getLevel()) {
                z = new CustNode(x.getLetters()+y.getLetters(), x.getLevel()+1);
                z.setLeftChild(x);
                z.setRightChild(y);
            }
            else {
                z = new CustNode(y.getLetters()+x.getLetters(), y.getLevel()+1);
                z.setLeftChild(y);
                z.setRightChild(x);
            }

            // set the weight of the new node equal to the sum of its children
            z.setWeight(x.getWeight()+y.getWeight());

            // set the new node as the old nodes' parent
            x.setParent(z);
            y.setParent(z);

            // show the user what we've done
            System.out.println("Combined node " + x.getLetters() +
                    " weight: " + x.getWeight() + " with node " + y.getLetters()
                    + " weight: " + y.getWeight() + " to produce node " +
                    z.getLetters() + " weight: " + z.getWeight());

            // add the new node to the arraylist, sort, and then print it again
            custNodes.add(z);
            sortList(custNodes);
            printList(custNodes);

            // for usability, catch if the length is 1
            if(custNodes.size() == 1) {
                break;
            }

            // ask the user to continue
            System.out.println("Ready for the next step. " +
                    "Press enter to continue...");
            input.nextLine();
        }

        // we're done. exit gracefully
        System.out.println("We are done.");
    }

    // printList just prints the list passed to it
    private static void printList(ArrayList<CustNode> list) {
        for (CustNode aList : list) {
            System.out.println(aList.toString());
        }
    }

    // sortList sorts the list first by weight, and then by the value of the
    // string (using bubblesort)
    private static void sortList(ArrayList<CustNode> list) {
        int minIndex;
        CustNode minCustNode;
        for(int scan = 0; scan < (list.size() - 1); scan++) {
            minIndex = scan;
            minCustNode = list.get(scan);

            for(int i = scan + 1; i < list.size(); i++) {
                if(list.get(i).getWeight() < minCustNode.getWeight()) {
                    minIndex = i;
                    minCustNode = list.get(i);
                }
                if(list.get(i).getWeight() == minCustNode.getWeight()) {
                    if (list.get(i).getLetters().hashCode() <
                            minCustNode.getLetters().hashCode()) {
                        minIndex = i;
                        minCustNode = list.get(i);
                    }
                }
            }

            list.set(minIndex, list.get(scan));
            list.set(scan, minCustNode);
        }
    }

    // addLeaf creates the bottom layer of nodes
    private static void addLeaf(char ch) {

        for(CustNode custNode : custNodes) {
            if(custNode.getLetters().toCharArray()[0] == ch) {
                custNode.setWeight(custNode.getWeight() + 1);
                return;
            }
        }
        custNodes.add(new CustNode(String.valueOf(ch), 0));
    }

//    getStringInput gets input from the console. It makes sure that the
//            input is not empty, then returns the string.
    private static String getStringInput() {
        String text = input.nextLine();
        if(text.isEmpty()) {
            System.out.println("Please enter non-empty input: ");
            text = getStringInput();
        }
        return text.toLowerCase();
    }
}
