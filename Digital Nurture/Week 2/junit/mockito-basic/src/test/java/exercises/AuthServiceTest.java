package exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private EmployeeRepository repository;

    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthService(repository);
    }

    @Test
    void testAuthenticate_success() {
        boolean result = authService.authenticate("admin", "password123");
        assertTrue(result);
    }

    @Test
    void testAuthenticate_failure_wrongPassword() {
        boolean result = authService.authenticate("admin", "wrongpassword");
        assertFalse(result);
    }

    @Test
    void testAuthenticate_failure_wrongUsername() {
        boolean result = authService.authenticate("user", "password123");
        assertFalse(result);
    }

    @Test
    void testVoidMethod() {
        // Void methods don't return values, but we can verify they were called
        authService.voidMethod("test input");
        // No exception means success
    }

    @Test
    void testCalculateBonus() {
        assertEquals(5000, authService.calculateBonus(50000));
        assertEquals(10000, authService.calculateBonus(100000));
    }

    @Test
    void testCalculateBonus_negativeSalary() {
        assertThrows(IllegalArgumentException.class, () -> authService.calculateBonus(-1000));
    }

    @Test
    void testGetStatus() {
        assertEquals("OK", authService.getStatus(200));
        assertEquals("Not Found", authService.getStatus(404));
        assertEquals("Server Error", authService.getStatus(500));
        assertEquals("Unknown", authService.getStatus(999));
    }
}
