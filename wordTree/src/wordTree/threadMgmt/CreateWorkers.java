package wordTree.threadMgmt;

import wordTree.myTree.MyTree;
import wordTree.store.Results;

/**
 *
 * @author anirtek
 */
public class CreateWorkers {
    private MyTree tree = null;
    private Results results = null;

    public CreateWorkers(MyTree treeIn, Results resultsIn) {
        this.tree = treeIn;
        this.results = resultsIn;
    }
    
    public void startPopulateWorkers(int numberOfThreads) {
        
        
    }
    
    public void startDeleteWorkers() {
        
    }
    
}
