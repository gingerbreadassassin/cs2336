import java.util.Scanner;
import java.util.ArrayList;

public class Ness_Connor_A4 {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<CustNode> custNodes = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Please input a string of characters: ");
        char[] chars = getStringInput().toCharArray();

        for (char aChar : chars) {
            addLeaf(aChar);
        }

        sortList(custNodes);
        printList(custNodes);






    }


    private static void printList(ArrayList<CustNode> list) {
        for (CustNode aList : list) {
            System.out.println(aList.toString());
        }
    }


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
                    if (list.get(i).getLetters().compareTo(
                            minCustNode.getLetters()) < 0) {
                        minIndex = i;
                        minCustNode = list.get(i);
                    }
                }
            }

            list.set(minIndex, list.get(scan));
            list.set(scan, minCustNode);
        }
    }


    private static void addLeaf(char ch) {

        for(CustNode custNode : custNodes) {
            if(custNode.getLetters().toCharArray()[0] == ch) {
                custNode.setWeight(custNode.getWeight() + 1);
                return;
            }
        }
        custNodes.add(new CustNode(String.valueOf(ch)));
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
