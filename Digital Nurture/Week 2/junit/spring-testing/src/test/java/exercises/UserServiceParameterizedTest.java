package exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceParameterizedTest {

    @Mock
    private UserRepository userRepository;

    @ParameterizedTest
    @ValueSource(strings = {"john@example.com", "jane@example.com", "bob@example.com"})
    void testCreateUser_validEmails(String email) {
        User user = new User("Test User", email);
        when(userRepository.existsByEmail(email)).thenReturn(false);
        when(userRepository.save(user)).thenReturn(user);

        UserService service = new UserService(userRepository);
        User result = service.createUser(user);

        assertNotNull(result);
        verify(userRepository, times(1)).save(user);
    }

    @ParameterizedTest
    @CsvSource({
            "John, john@example.com",
            "Jane, jane@example.com",
            "Bob, bob@example.com"
    })
    void testCreateUser_multipleUsers(String name, String email) {
        User user = new User(name, email);
        when(userRepository.existsByEmail(email)).thenReturn(false);
        when(userRepository.save(user)).thenReturn(user);

        UserService service = new UserService(userRepository);
        User result = service.createUser(user);

        assertEquals(name, result.getName());
        assertEquals(email, result.getEmail());
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L, 4L, 5L})
    void testGetUserById_found(Long id) {
        User user = new User("User" + id, "user" + id + "@example.com");
        when(userRepository.findById(id)).thenReturn(java.util.Optional.of(user));

        UserService service = new UserService(userRepository);
        User result = service.getUserById(id);

        assertNotNull(result);
        assertEquals("User" + id, result.getName());
    }
}
