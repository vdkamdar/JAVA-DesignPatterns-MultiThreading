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

    public Node(String wordIn) {
        MyLogger.writeMessage("Constructor called - " + this.toString(), MyLogger.DebugLevel.CONSTRUCTOR);
        this.word = wordIn;
        this.wordCount = 1;
        this.left = null;
        this.right = null;
    }

    public String getWord() {
        return word;
    }

    public void setWordCount(int countIn) {
        this.wordCount = countIn;
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

    @Override
    public String toString() {
        return "Class : wordTree.myTree.Node"; //To change body of generated methods, choose Tools | Templates.
    }

}
