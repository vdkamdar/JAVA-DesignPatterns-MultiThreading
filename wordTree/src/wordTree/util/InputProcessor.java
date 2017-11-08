package wordTree.util;

import wordTree.myTree.MyTree;

/**
 *
 * @author anirtek
 */
public class InputProcessor {
    MyTree myTreeInstance = null;
    
    public String[] processInput(String inputLine) {
        String[] inputPass = inputLine.split("[^a-zA-Z0-9']+");
        return inputPass;        
    }
    
}
