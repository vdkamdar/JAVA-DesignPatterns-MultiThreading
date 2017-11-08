package wordTree.threadMgmt;

import java.util.ArrayList;
import wordTree.myTree.MyTree;
import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.util.InputProcessor;
import wordTree.util.MyLogger;

/**
 * @version 1.0
 * @author Aniruddha Tekade & Vidhi Kamdar Submitted on November 8th, 2017.
 */
public class DeleteThread implements Runnable {

    private FileProcessor fp = null;
    private InputProcessor ip = null;
    private MyTree tree = null;
    private Results results = null;
    private String wordToBeDeleted = null;

    DeleteThread(FileProcessor fpIn, InputProcessor ipIn, MyTree treeIn, Results resultsIn, String wordIn) {
        MyLogger.writeMessage("Constructor called - " + this.toString(), MyLogger.DebugLevel.CONSTRUCTOR);
        fp = fpIn;
        ip = ipIn;
        tree = treeIn;
        results = resultsIn;
        wordToBeDeleted = wordIn;
    }

    public void run() {
        MyLogger.writeMessage("Thread is running - " + this.toString(), MyLogger.DebugLevel.THREAD_RUN);
        tree.delete(wordToBeDeleted);
    }

    @Override
    public String toString() {
        return "Class : wordTree.threadMgmt.DeleteThread"; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
