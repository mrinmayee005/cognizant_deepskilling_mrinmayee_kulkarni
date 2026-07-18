package exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean validateUser(String username, String password) {
        logger.info("Validating user: {}", username);

        if (username == null || username.isEmpty()) {
            logger.warn("Validation failed: username is null or empty");
            return false;
        }

        if (password == null || password.length() < 8) {
            logger.warn("Validation failed: password too short for user {}", username);
            return false;
        }

        logger.info("User {} validated successfully", username);
        return true;
    }

    public void processRequest(String userId, String action) {
        logger.info("Processing request: user={}, action={}", userId, action);
        try {
            // Simulate processing
            if ("delete".equals(action)) {
                throw new IllegalStateException("Cannot delete while processing");
            }
            logger.info("Request processed successfully for user {}", userId);
        } catch (IllegalStateException e) {
            logger.error("Error processing request for user {}: {}", userId, e.getMessage(), e);
            throw e;
        }
    }
}
