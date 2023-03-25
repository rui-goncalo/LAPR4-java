package utils;

public class Utils {

    /**
     * Stops a thread for the specified amount of seconds
     */
    public static void sleepSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stops a thread for the specified amount of milliseconds
     */
    public static void sleepMilliseconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}