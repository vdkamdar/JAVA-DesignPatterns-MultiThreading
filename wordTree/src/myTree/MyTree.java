package myTree;

/**
 *
 * @author anirtek
 */
public class MyTree {
    
    public Node root;
    
    public MyTree() {
        this.root = null;
    }
    
    public Node insertNodeSorted(Node root, String wordIn) {
        if (root == null) {
            root = new Node(wordIn);
            return root;
        } else if (root.getWordLength() >= wordIn.length()) {
            root.setLeft(insertNodeSorted(root.getLeft(), wordIn));
        } else /*if (root.data < node.data)*/ {
            root.setRight(insertNodeSorted(root.getRight(), wordIn));
        }
        return root;
    }
    
}
