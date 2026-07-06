public class Logger {

   
    private static Logger instance;

    // Constructor
    private Logger() {
        System.out.println("Logger instance created");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String msg) {
        System.out.println("Log: " + msg);
    }
}