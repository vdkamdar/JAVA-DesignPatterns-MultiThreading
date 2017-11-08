package wordTree.util;

import wordTree.myTree.MyTree;

/**
 *
 * @author anirtek
 */
public class InputProcessor {
    MyTree myTreeInstance = null;
    
    public InputProcessor(){
        MyLogger.writeMessage("Constructor called - " + this.toString(), MyLogger.DebugLevel.CONSTRUCTOR);
    }
    
    public String[] processInput(String inputLine) {
        String[] inputPass = inputLine.split("[^a-zA-Z0-9']+");
        return inputPass;        
    }

    @Override
    public String toString() {
        return "Class : wordTree.util.InputProcessor"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
