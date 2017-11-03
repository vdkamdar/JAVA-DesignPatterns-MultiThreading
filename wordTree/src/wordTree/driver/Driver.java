package wordTree.driver;

import java.util.ArrayList;
import wordTree.myTree.MyTree;
import wordTree.util.FileProcessor;
import wordTree.util.InputProcessor;

public class Driver {

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

        System.out.println("Input File: " + inputFile);
        System.out.println("Output File: " + outputFile);
        System.out.println("NUM_THREADS: " + NUM_THREADS);
        for (String word : wordsToDelete) {
            System.out.println(word);
        }
        System.out.println("Debug value: " + debugLevel);
        
        /**
         * Create FileProcessor instance.
         */
        FileProcessor fp = new FileProcessor(inputFile, outputFile);
        
        /**
         * Create InputProcessor instance.
         */
        InputProcessor fip = new InputProcessor();
        
        /**
         * Create MyTree instance and try to insert.
         */
        MyTree tree = new MyTree();
        fp.readLine(tree);
    }
}
