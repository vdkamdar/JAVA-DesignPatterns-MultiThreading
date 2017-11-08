package wordTree.util;

/**
 * @version 4.0
 * @author Aniruddha Tekade & Vidhi Kamdar Submitted on November 8th, 2017.
 */
public class MyLogger {

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime a thread's run() method is called]
      DEBUG_VALUE=2 [Print to stdout everytime an insertion is attempted]
      DEBUG_VALUE=1 [Print to stdout everytime a deletion is attempted]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. However, it doesn't affect what's get written to the output file." ]
     */
    public static enum DebugLevel {
        RELEASE,
        WORD_DELETION,
        WORD_INSERTION,
        THREAD_RUN,
        CONSTRUCTOR
    };

    private static DebugLevel debugLevel;

    public static void setDebugValue(int levelIn) {
        switch (levelIn) {
            case 4:
                debugLevel = DebugLevel.CONSTRUCTOR;
                break;
            case 3:
                debugLevel = DebugLevel.THREAD_RUN;
                break;
            case 2:
                debugLevel = DebugLevel.WORD_INSERTION;
                break;
            case 1:
                debugLevel = DebugLevel.WORD_DELETION;
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
