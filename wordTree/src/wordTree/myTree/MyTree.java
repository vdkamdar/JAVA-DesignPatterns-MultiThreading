package wordTree.myTree;

/**
 *
 * @author anirtek
 */
public class MyTree {

    private Node root;

    public MyTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public synchronized void insert(String wordIn) {
        if (root == null) {
            this.root = new Node(wordIn);
        } else {
            Node node = searchNode(root, wordIn);
            if (node == null) {
                insertNode(root, wordIn);
            } else {
                node.setWordCount(node.getWordCount() + 1); //increases by 1 always
            }
        }
    }

    public void insertNode(Node node, String wordIn) {
        if (node.getWord().compareTo(wordIn) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(wordIn));
            } else {
                insertNode(node.getLeft(), wordIn);
            }
        } else if (node.getWord().compareTo(wordIn) < 0) {
            if (node.getRight() == null) {
                node.setRight(new Node(wordIn));
            } else {
                insertNode(node.getRight(), wordIn);
            }
        }
    }

    /**
     * @return Node - null if node not present, else returns the node
     */
    public Node searchNode(Node node, String wordIn) {
        if (node == null) {
            return node;
        } else if (node.getWord().compareTo(wordIn) == 0) {
            return node;
        } else if (node.getWord().compareTo(wordIn) > 0) {
            return searchNode(node.getLeft(), wordIn);
        } else {
            return searchNode(node.getRight(), wordIn);
        }
    }

    public synchronized void delete(String wordIn) {
        Node node = searchNode(root, wordIn);
        if (node != null && node.getWordCount() != 0) {
            node.setWordCount(node.getWordCount() - 1);
        }
    }

    public void printNodes(Node current_node /*ArrayList<String> outputFileResults*/) {
        if (root == null) {
            return;
        } else if (current_node != null) {
            printNodes(current_node.getLeft() /*, outputFileResults*/);

            if(current_node.getWordCount() >= 1)
            System.out.println(current_node.getWord());
//            outputFileResults.add(current_node.getWord());

            printNodes(current_node.getRight()/*, outputFileResults*/);
        }
    }
}
