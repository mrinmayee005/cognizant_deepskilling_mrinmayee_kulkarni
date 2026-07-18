package exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    private EmployeeService service;

    @BeforeEach
    void setUp() {
        service = new EmployeeService(repository);
    }

    @Test
    void testCreateEmployee() {
        Employee emp = new Employee(1L, "John", "Engineering", 50000);
        when(repository.save(emp)).thenReturn(emp);

        Employee result = service.createEmployee(emp);

        assertNotNull(result);
        assertEquals("John", result.getName());
        verify(repository, times(1)).save(emp);
    }

    @Test
    void testGetEmployeeById_found() {
        Employee emp = new Employee(1L, "John", "Engineering", 50000);
        when(repository.findById(1L)).thenReturn(Optional.of(emp));

        Employee result = service.getEmployeeById(1L);

        assertNotNull(result);
        assertEquals("John", result.getName());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGetEmployeeById_notFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.getEmployeeById(1L));
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "John", "Engineering", 50000),
                new Employee(2L, "Jane", "Marketing", 60000)
        );
        when(repository.findAll()).thenReturn(employees);

        List<Employee> result = service.getAllEmployees();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testDeleteEmployee_success() {
        when(repository.existsById(1L)).thenReturn(true);

        service.deleteEmployee(1L);

        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteEmployee_notFound() {
        when(repository.existsById(1L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> service.deleteEmployee(1L));
        verify(repository, never()).deleteById(anyLong());
    }

    @Test
    void testUpdateSalary() {
        Employee emp = new Employee(1L, "John", "Engineering", 50000);
        when(repository.findById(1L)).thenReturn(Optional.of(emp));
        when(repository.save(emp)).thenReturn(emp);

        Employee result = service.updateSalary(1L, 60000);

        assertEquals(60000, result.getSalary());
        verify(repository, times(1)).save(emp);
    }
}
