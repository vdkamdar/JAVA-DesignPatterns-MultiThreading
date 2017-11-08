package wordTree.store;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import wordTree.myTree.MyTree;
import wordTree.util.MyLogger;

/**
 *
 * @author anirtek
 */
public class Results {

    private String outputFile = "";
    public ArrayList<String> status;

    /**
     * Constructor of the Results class.
     *
     * @param tree
     * @param outputFileName
     */
    public Results( String outputFileName) {
        MyLogger.writeMessage("Constructor called - " + this.toString(), MyLogger.DebugLevel.CONSTRUCTOR);
        this.outputFile = outputFileName;
        status = new ArrayList();
    }

    /**
     * This method stores the output line into the local ArrayList.
     *
     * @param line
     */
    public void storeLine(String line) {
        status.add(line); //getting stored into the arrayList
    }

    /**
     * Navigates on the local output Array List and writes each line into the
     * respective output file.
     */
    public void writeSchedulesToFile(MyTree tree) {
        tree.printNodes(tree.getRoot(), this.status);
        for (int i = 0; i < status.size(); i++) {
            writeToFile(status.get(i));
        }
    }

    /**
     * Performs actual writing into the file specified.
     *
     * @param line
     */
    public void writeToFile(String line) {
        try {
            File outputFile = new File(this.outputFile);
            outputFile.createNewFile();
            PrintWriter pw = new PrintWriter(new FileWriter(outputFile, true));
            pw.println(line);
            pw.close();
        } catch (IOException ex) {

        }
    }

    @Override
    public String toString() {
        return "Class : wordTree.store.Results"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
