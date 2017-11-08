package wordTree.store;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import wordTree.myTree.MyTree;
import wordTree.util.FileDisplayInterface;
import wordTree.util.MyLogger;
import wordTree.util.StdoutDisplayInterface;

/**
 * @version 4.0
 * @author Aniruddha Tekade & Vidhi Kamdar Submitted on November 8th, 2017.
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private String outputFile = "";
    public ArrayList<String> status;
    /**
     * Constructor of the Results class.
     *
     * @param tree
     * @param outputFileName
     */
    public Results(String outputFileName) {
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
        tree.printCounts(status);
        for (int i = 0; i < status.size(); i++) {
            writeToFile(status.get(i));
        }
    }
    int debugLevel = 5;
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

    /**
     * Overriden method for writing the output to screen.
     */
    @Override
    public void writeToScreen() {
        MyLogger.writeMessage(outputFile, MyLogger.DebugLevel.RELEASE);
    }

}
