package wordTree.threadMgmt;

import wordTree.myTree.MyTree;
import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.util.InputProcessor;

/**
 *
 * @author anirtek
 */
public class PopulateThread implements Runnable{
    
    private FileProcessor fp = null;
    private InputProcessor ip = null;
    private MyTree tree = null;
    private Results results = null;
    
    public PopulateThread(FileProcessor fpIn, InputProcessor ipIn, MyTree treeIn, Results resultsIn) {
        fp = fpIn;
        ip = ipIn;
        tree = treeIn;
        results = resultsIn;
    }

    public void run() {
        System.out.println("****" + Thread.currentThread().getName() + "****");
        String line;
        while ((line = fp.readLine()) != null) {
            String[] inputPass = ip.processInput(line);
            for (int i = 0; i < inputPass.length; i++) {
                String inputWord = inputPass[i];
                tree.insert(inputWord); // working
                System.out.println(inputWord);
            }
        }
    }

}
