import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {

    private static final Logger logger =
            LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {

        logger.debug("This is a DEBUG message");
        logger.info("This is an INFO message");
        logger.warn("This is a WARNING message");
        logger.error("This is an ERROR message");
    }
}