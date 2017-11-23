public class Node {
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    private String letters;
    private int weight;

    public Node() {
        parent = null;
        leftChild = null;
        rightChild = null;
        letters = "";
        weight = 0;
    }

    public Node(String ltr) {
        parent = null;
        leftChild = null;
        rightChild = null;
        letters = ltr;
        weight = 1;
    }

    public int getWeight() {
        return weight;
    }

    public boolean hasChild(Node node) {
        return rightChild != null || leftChild != null;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }
}
