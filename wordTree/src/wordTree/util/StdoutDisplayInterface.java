package wordTree.util;

/**
 *
 * @author anirtek
 */
public class StdoutDisplayInterface {
    
    public StdoutDisplayInterface() {
        MyLogger.writeMessage("Constructor called - " + this.toString(), MyLogger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public String toString() {
        return "Class : wordTree.util.StdoutDisplayInterface"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
