package wordTree.util;

import wordTree.myTree.MyTree;

/**
 * @version 4.0
 * @author Aniruddha Tekade & Vidhi Kamdar Submitted on November 8th, 2017.
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
