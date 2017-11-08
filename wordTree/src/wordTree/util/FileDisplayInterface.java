package wordTree.util;

/**
 *
 * @author anirtek
 */
public class FileDisplayInterface {
    public FileDisplayInterface() {
        MyLogger.writeMessage("Constructor called - " + this.toString(), MyLogger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public String toString() {
        return "wordTree.util.FileDisplayInterface"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
