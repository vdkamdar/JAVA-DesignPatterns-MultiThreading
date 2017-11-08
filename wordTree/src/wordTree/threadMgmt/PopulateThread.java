package wordTree.threadMgmt;

import wordTree.myTree.MyTree;
import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.util.InputProcessor;
import wordTree.util.MyLogger;

/**
 * @version 1.0
 * @author Aniruddha Tekade & Vidhi Kamdar Submitted on November 8th, 2017.
 */
public class PopulateThread implements Runnable {

    private FileProcessor fp = null;
    private InputProcessor ip = null;
    private MyTree tree = null;
    private Results results = null;

    /**
     * Public constructor.
     *
     * @param fpIn
     * @param ipIn
     * @param treeIn
     * @param resultsIn
     */
    public PopulateThread(FileProcessor fpIn, InputProcessor ipIn, MyTree treeIn, Results resultsIn) {
        MyLogger.writeMessage("Constructor called - " + this.toString(), MyLogger.DebugLevel.CONSTRUCTOR);
        fp = fpIn;
        ip = ipIn;
        tree = treeIn;
        results = resultsIn;
    }

    /**
     * Runs the thread and get the work done.
     */
    public void run() {
        MyLogger.writeMessage("Thread is running - " + this.toString(), MyLogger.DebugLevel.THREAD_RUN);
        String line;
        while ((line = fp.readLine()) != null) {
            String[] inputPass = ip.processInput(line);
            for (int i = 0; i < inputPass.length; i++) {
                String inputWord = inputPass[i];
                tree.insert(inputWord); // working
            }
        }
    }

    @Override
    public String toString() {
        return "Class : wordTree.threadMgmt.PopulateThread"; //To change body of generated methods, choose Tools | Templates.
    }

}
