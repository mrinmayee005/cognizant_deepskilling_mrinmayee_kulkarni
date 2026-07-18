package exercises;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        User user = new User("John", "john@example.com");
        User saved = entityManager.persistAndFlush(user);

        assertNotNull(saved.getId());
        assertEquals("John", saved.getName());
    }

    @Test
    void testFindByEmail() {
        User user = new User("John", "john@example.com");
        entityManager.persistAndFlush(user);

        Optional<User> found = userRepository.findByEmail("john@example.com");

        assertTrue(found.isPresent());
        assertEquals("John", found.get().getName());
    }

    @Test
    void testExistsByEmail() {
        User user = new User("John", "john@example.com");
        entityManager.persistAndFlush(user);

        assertTrue(userRepository.existsByEmail("john@example.com"));
        assertFalse(userRepository.existsByEmail("jane@example.com"));
    }

    @Test
    void testFindByNameContaining() {
        entityManager.persistAndFlush(new User("John Doe", "john@example.com"));
        entityManager.persistAndFlush(new User("Jane Doe", "jane@example.com"));
        entityManager.persistAndFlush(new User("Bob Smith", "bob@example.com"));

        var results = userRepository.findByNameContaining("Doe");
        assertEquals(2, results.size());
    }

    @Test
    void testSearchByKeyword() {
        entityManager.persistAndFlush(new User("John Doe", "john@example.com"));
        entityManager.persistAndFlush(new User("Jane Smith", "jane@test.com"));

        var results = userRepository.searchByKeyword("john");
        assertEquals(1, results.size());
        assertEquals("John Doe", results.get(0).getName());
    }
}
