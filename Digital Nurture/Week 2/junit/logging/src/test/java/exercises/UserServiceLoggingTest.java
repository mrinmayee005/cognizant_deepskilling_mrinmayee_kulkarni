package exercises;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserServiceLoggingTest {
    @Test
    public void testValidateUser_success() {
        UserService service = new UserService();
        boolean result = service.validateUser("admin", "password123");
        assertTrue(result);
    }

    @Test
    public void testValidateUser_emptyUsername() {
        UserService service = new UserService();
        boolean result = service.validateUser("", "password123");
        assertFalse(result);
    }

    @Test
    public void testValidateUser_nullUsername() {
        UserService service = new UserService();
        boolean result = service.validateUser(null, "password123");
        assertFalse(result);
    }

    @Test
    public void testValidateUser_shortPassword() {
        UserService service = new UserService();
        boolean result = service.validateUser("admin", "short");
        assertFalse(result);
    }

    @Test
    public void testProcessRequest_success() {
        UserService service = new UserService();
        service.processRequest("user1", "read");
        // No exception means success
    }

    @Test(expected = IllegalStateException.class)
    public void testProcessRequest_deleteFails() {
        UserService service = new UserService();
        service.processRequest("user1", "delete");
    }
}
