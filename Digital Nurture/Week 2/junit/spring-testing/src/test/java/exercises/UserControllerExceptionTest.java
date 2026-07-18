package exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerExceptionTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetUserById_notFound() {
        when(userService.getUserById(1L)).thenThrow(new RuntimeException("User not found"));

        assertThrows(RuntimeException.class, () -> userController.getUserById(1L));
    }

    @Test
    void testDeleteUser_notFound() {
        doThrow(new RuntimeException("User not found")).when(userService).deleteUser(1L);

        assertThrows(RuntimeException.class, () -> userController.deleteUser(1L));
    }
}
