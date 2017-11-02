package wordTree.myTree;

/**
 *
 * @author anirtek
 */
public class Node {

    String word;
    int wordCount;
    Node left;
    Node right;
    
    public Node(String wordIn) {
        this.word = wordIn;
        this.wordCount = 1;
        this.left = null;
        this.right = null;
    }

    public String getWord() {
        return word;
    }

    public void setWordCount() {
        this.wordCount += 1;
    }
    
    public int getWordCount() {
        return wordCount;
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
