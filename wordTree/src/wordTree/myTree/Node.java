package wordTree.myTree;

import wordTree.util.MyLogger;

/**
 * @version 4.0
 * @author Aniruddha Tekade & Vidhi Kamdar Submitted on November 8th, 2017.
 */
public class Node {

    String word;
    int wordCount;
    int wordLength;
    Node left;
    Node right;

    /**
     * Public constructor of the class
     *
     * @param wordIn
     */
    public Node(String wordIn) {
        MyLogger.writeMessage("Constructor called - " + this.toString(), MyLogger.DebugLevel.CONSTRUCTOR);
        this.word = wordIn;
        this.wordCount = 1;
        this.left = null;
        this.right = null;
    }

    /**
     * Getter method for word in the node
     *
     * @return
     */
    public String getWord() {
        return word;
    }

    /**
     * Setter for storing wordCount in the tree nodes.
     *
     * @param countIn
     */
    public void setWordCount(int countIn) {
        this.wordCount = countIn;
    }

    /**
     * Getter for word count
     *
     * @return
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Geeter for left node of the root / present working node.
     *
     * @return
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Setter for left node of the root / present working node.
     *
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Getter for right node of the root / present working node.
     *
     * @return
     */
    public Node getRight() {
        return right;
    }

    /**
     * Setter for right node of the root / present working node.
     *
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Class : wordTree.myTree.Node"; //To change body of generated methods, choose Tools | Templates.
    }

}
