package wordTree.util;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 19th, 2017.
 */
public class Logger {

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
      DEBUG_VALUE=2 [Print to stdout everytime a set of operations are performed]
      DEBUG_VALUE=1 [Print to stdout everytime an exception occurs and handles]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
     */
    public static enum DebugLevel {
        RELEASE,
        FROM_RESULTS,
        IN_RESULTS,
        IN_RUN,
        CONSTRUCTOR
    };

    private static DebugLevel debugLevel;

    public static void setDebugValue(int levelIn) {
        switch (levelIn) {
            case 4:
                debugLevel = DebugLevel.CONSTRUCTOR;
                break;
            case 3:
                debugLevel = DebugLevel.IN_RUN;
                break;
            case 2:
                debugLevel = DebugLevel.IN_RESULTS;
                break;
            case 1:
                debugLevel = DebugLevel.FROM_RESULTS;
                break;
            case 0:
                debugLevel = DebugLevel.RELEASE;
                break;
        }
    }

    public static void setDebugValue(DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage(String message, DebugLevel levelIn) {
        if (levelIn == debugLevel) {
            System.out.println(message);
        } 
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Debug Level is " + debugLevel;
    }
}
