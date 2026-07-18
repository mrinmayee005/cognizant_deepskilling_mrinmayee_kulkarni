package exercises;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestPropertySource(properties = "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1")
public class ProductIntegrationTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ExternalService externalService;

    @Test
    void testCreateAndGetProduct() {
        Product product = new Product("Test Product", 29.99, 5);

        Product created = productService.createProduct(product);
        assertNotNull(created.getId());

        Product retrieved = productService.getProductById(created.getId());
        assertEquals("Test Product", retrieved.getName());
    }

    @Test
    void testGetProductWithExternalData_integration() {
        Product product = new Product("Integration Product", 49.99, 3);
        Product saved = productService.createProduct(product);

        when(externalService.fetchDataFromExternalAPI("/api/test")).thenReturn("Integration test data");

        String result = productService.getProductWithExternalData(saved.getId(), "/api/test");

        assertTrue(result.contains("Integration Product"));
        assertTrue(result.contains("Integration test data"));
    }
}
