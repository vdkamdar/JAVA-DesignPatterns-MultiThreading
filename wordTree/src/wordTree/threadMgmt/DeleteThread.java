package wordTree.threadMgmt;

import java.util.ArrayList;
import wordTree.myTree.MyTree;
import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.util.InputProcessor;

/**
 *
 * @author anirtek
 */
public class DeleteThread implements Runnable{
    private FileProcessor fp = null;
    private InputProcessor ip = null;
    private MyTree tree = null;
    private Results results = null;
    private String wordToBeDeleted = null;

    DeleteThread(FileProcessor fpIn, InputProcessor ipIn, MyTree treeIn, Results resultsIn, String wordIn) {
        fp = fpIn; 
        ip = ipIn;
        tree = treeIn;
        results = resultsIn;
        wordToBeDeleted = wordIn;
    }
    
    public void run() {
        System.out.println("****" + Thread.currentThread().getName() + "****");
        tree.delete(wordToBeDeleted);
    }
    
}
