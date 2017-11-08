package wordTree.driver;

import java.util.ArrayList;
import wordTree.myTree.MyTree;
import wordTree.store.Results;
import wordTree.threadMgmt.CreateWorkers;
import wordTree.util.FileProcessor;
import wordTree.util.InputProcessor;
import wordTree.util.MyLogger;

/**
 * @version 4.0
 * @author Aniruddha Tekade & Vidhi Kamdar Submitted on November 8th, 2017.
 */
public class Driver {

    /**
     * Driver code accepts minimum 6 number of inputs.
     * It also validates every single input including filename and debug level.
     * 
     * @param args
     * @throws Exception 
     */
    public static void main(String args[]) throws Exception {
        String inputFile = null;
        String outputFile = null;
        int NUM_THREADS = 0;
        ArrayList<String> wordsToDelete = new ArrayList<String>();
        int debugLevel = 0;
        try {
            if (args.length >= 5) {
                inputFile = args[0];
                outputFile = args[1];
                try {
                    NUM_THREADS = Integer.parseInt(args[2]);
                    if ((NUM_THREADS >= 1 && NUM_THREADS <= 3) && (NUM_THREADS == args.length - 4)) {
                        int wordCounter = NUM_THREADS;
                        int i = 3;
                        while (wordCounter != 0) {
                            wordsToDelete.add(args[i]);
                            i++;
                            wordCounter--;
                        }
                        if (args[args.length - 1].matches(".*[0-4].*")) {
                            debugLevel = Integer.parseInt(args[args.length - 1]);
                            MyLogger.setDebugValue(debugLevel);
                        } else {
                            throw new IllegalArgumentException("The argument " + args[args.length - 1] + " is invalid. Please enter debug level between 0 and 4.");
                        }
                    } else {
                        throw new RuntimeException("Expected number of threads in the range[1-3] and corresponding words to be deleted");
                    }
                } catch (NumberFormatException ex) {
                    System.err.println(ex);
                }
            } else {
                throw new Exception("Five arguments expected at minimum");
            }
        } catch (Exception ex) {
            System.err.println("Exception occurred");
            ex.printStackTrace();
            System.exit(1);
        }

        /**
         * Creating instance of the FileProcessor
         */
        FileProcessor fileProc = new FileProcessor(inputFile, outputFile);

        /**
         * Creating instance of the InputProcessor
         */
        InputProcessor inputProc = new InputProcessor();
        /**
         * Create an instance
         */
        MyTree tree = new MyTree();
        Results results = new Results(outputFile);
        CreateWorkers createWorkers = new CreateWorkers(fileProc, inputProc, tree, results, wordsToDelete);
        createWorkers.startPopulateWorkers(NUM_THREADS);
        createWorkers.startDeleteWorkers(NUM_THREADS);
        results.writeToScreen();
        results.writeSchedulesToFile(tree);
    }
}
