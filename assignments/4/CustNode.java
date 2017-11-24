public class CustNode {
    private CustNode parent;
    private CustNode leftChild;
    private CustNode rightChild;

    private String letters;
    private int weight;

    public CustNode() {
        parent = null;
        leftChild = null;
        rightChild = null;
        letters = "";
        weight = 0;
    }

    public CustNode(String ltr) {
        parent = null;
        leftChild = null;
        rightChild = null;
        letters = ltr;
        weight = 1;
    }

    public int getWeight() {
        return weight;
    }

    public boolean hasChild(CustNode custNode) {
        return rightChild != null || leftChild != null;
    }

    public void setParent(CustNode parent) {
        this.parent = parent;
    }

    public void setLeftChild(CustNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(CustNode rightChild) {
        this.rightChild = rightChild;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public String getLetters() {
        return letters;
    }

    public String toString() {
        return letters + " | " + weight;
    }
}

