package wordTree.threadMgmt;

import java.util.logging.Level;
import java.util.logging.Logger;
import wordTree.myTree.MyTree;
import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.util.InputProcessor;

/**
 *
 * @author anirtek
 */
public class CreateWorkers {

    private FileProcessor fp = null;
    private InputProcessor ip = null;
    private MyTree tree = null;
    private Results results = null;

    public CreateWorkers(FileProcessor fpIn, InputProcessor ipIn, MyTree treeIn, Results resultsIn) {
        this.fp = fpIn;
        this.ip = ipIn;
        this.tree = treeIn;
        this.results = resultsIn;
    }

    public void startPopulateWorkers(int numberOfThreads) {
        for (int i = 0; i < numberOfThreads; i++) {
            Thread pThread = new Thread(new PopulateThread(fp, ip, tree, results), "pThread_"+i);
            pThread.start();
            try {
                pThread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CreateWorkers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void startDeleteWorkers() {

    }
}
