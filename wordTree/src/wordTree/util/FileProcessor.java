package wordTree.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import wordTree.myTree.MyTree;

/**
 * @version 3.0
 * @author Aniruddha Tekade & Vidhi Kamdar : Submitted on October 19th, 2017.
 */
public class FileProcessor {

    private String inputFileName = "", outputFileName = "";

    /**
     * Parameterized constructor of the class that sets the different filename
     * received from the command line to the local fileName variables.
     *
     * @param inputFileIn
     * @param outputFileIn
     */
    public FileProcessor(String inputFileIn, String outputFileIn) {
        Logger.writeMessage("Constructor called - " + this.toString(), Logger.DebugLevel.CONSTRUCTOR);
        if (inputFileIn == null) {
            System.err.println("Input File name is null!");
            System.exit(0);
        } else {
            this.inputFileName = inputFileIn;
        }
        if (outputFileIn == null) {
            System.err.println("Output File name is null!");
            System.exit(0);
        } else {
            this.outputFileName = outputFileIn;
        }
    }

    /**
     * This method performs the reading operation on the input line and
     * separates the b_number and the courseName facilitating the the easy node
     * creation in the TreeBuilder class.
     *
     * @param sf
     */
    public void readLine(MyTree tree) {
        try (BufferedReader lineIn = new BufferedReader(new FileReader(inputFileName))) {
            try {
                for (String line; (line = lineIn.readLine()) != null;) {
                    try {
                        String [] inputPass = line.split("[^a-zA-Z0-9']+");
                        for (int i = 0; i < inputPass.length; i++) {
                            tree.insert(inputPass[i]);
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println(ex);
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex);
            } finally {
                lineIn.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Additional method to write to any file if required.
     *
     * @param outputLine
     */
    public void writeLine(String outputLine) {
        try {
            File outputFile = new File(outputFileName);
            outputFile.createNewFile();
            try (PrintWriter pw = new PrintWriter(new FileWriter(outputFile, true))) {
                pw.println(outputLine);
            }
        } catch (IOException ex) {
            Logger.writeMessage(ex.getMessage(), Logger.DebugLevel.RELEASE);
        }
    }

    @Override
    public String toString() {
        return "FileProcessor";
    }

}
