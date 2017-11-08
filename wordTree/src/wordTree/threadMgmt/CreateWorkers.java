package wordTree.threadMgmt;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import wordTree.myTree.MyTree;
import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.util.InputProcessor;
import wordTree.util.MyLogger;

/**
 *
 * @author anirtek
 */
public class CreateWorkers {

    private FileProcessor fp = null;
    private InputProcessor ip = null;
    private MyTree tree = null;
    private Results results = null;
    private ArrayList<String> wordsToDelete = null;

    public CreateWorkers(FileProcessor fpIn, InputProcessor ipIn, MyTree treeIn, Results resultsIn, ArrayList<String> wordsToDeleteIn) {
        MyLogger.writeMessage("Constructor called - " + this.toString(), MyLogger.DebugLevel.CONSTRUCTOR);
        this.fp = fpIn;
        this.ip = ipIn;
        this.tree = treeIn;
        this.results = resultsIn;
        this.wordsToDelete = wordsToDeleteIn;
    }

    public void startPopulateWorkers(int numberOfThreads) {
        for (int i = 0; i < numberOfThreads; i++) {
            Thread pCreateThread = new Thread(new PopulateThread(fp, ip, tree, results), "pCreateThread_"+i);
            pCreateThread.start();
            try {
                pCreateThread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CreateWorkers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void startDeleteWorkers(int numberOfThreads) {
        for (int i = 0; i < numberOfThreads; i++) {
            Thread pDeleteThread = new Thread(new DeleteThread(fp, ip, tree, results, wordsToDelete.get(i)), "pDeleteThread_"+i);
            pDeleteThread.start();
            try {
                pDeleteThread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CreateWorkers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return "Class : wordTree.threadMgmt.CreateWorkers"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
