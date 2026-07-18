package exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerPostTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testCreateUser() {
        User user = new User("John", "john@example.com");
        when(userService.createUser(user)).thenReturn(user);

        var response = userController.createUser(user);

        assertEquals(201, response.getStatusCode().value());
        assertEquals("John", response.getBody().getName());
    }

    @Test
    void testCreateUser_invalidData() {
        User user = new User("", "");
        when(userService.createUser(user)).thenThrow(new RuntimeException("Invalid data"));

        assertThrows(RuntimeException.class, () -> userController.createUser(user));
    }
}
