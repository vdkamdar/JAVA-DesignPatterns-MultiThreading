package myTree;

/**
 *
 * @author anirtek
 */
public class Node {

    String word;
    int wordLength;
    Node left;
    Node right;
    
    public Node(String wordIn) {
        this.word = wordIn;
        this.wordLength = wordIn.length();
        this.left = null;
        this.right = null;
    }

    public String getWord() {
        return word;
    }

    public int getWordLength() {
        return wordLength;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
