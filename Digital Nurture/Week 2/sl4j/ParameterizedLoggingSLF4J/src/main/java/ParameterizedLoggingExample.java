import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String name = "Mrinmayee";
        int age = 21;
        double salary = 50000.50;

        logger.info("User name is {}", name);
        logger.info("User age is {}", age);
        logger.info("User salary is {}", salary);

        logger.warn("User {} is {} years old", name, age);
        logger.error("Error occurred for user {}", name);
    }
}