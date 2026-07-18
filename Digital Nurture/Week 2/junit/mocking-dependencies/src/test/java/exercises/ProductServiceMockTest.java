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
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ExternalService externalService;

    @InjectMocks
    private ProductService productService;

    @Test
    void testCreateProduct() {
        Product product = new Product("Laptop", 999.99, 10);
        when(productRepository.existsByName("Laptop")).thenReturn(false);
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.createProduct(product);

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testCreateProduct_duplicateName() {
        Product product = new Product("Laptop", 999.99, 10);
        when(productRepository.existsByName("Laptop")).thenReturn(true);

        assertThrows(RuntimeException.class, () -> productService.createProduct(product));
        verify(productRepository, never()).save(any());
    }

    @Test
    void testGetProductById_found() {
        Product product = new Product("Laptop", 999.99, 10);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(1L);

        assertEquals("Laptop", result.getName());
    }

    @Test
    void testGetProductById_notFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> productService.getProductById(1L));
    }

    @Test
    void testGetProductWithExternalData() {
        Product product = new Product("Laptop", 999.99, 10);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(externalService.fetchDataFromExternalAPI("/api/data")).thenReturn("External info");

        String result = productService.getProductWithExternalData(1L, "/api/data");

        assertTrue(result.contains("Laptop"));
        assertTrue(result.contains("External info"));
        verify(externalService, times(1)).fetchDataFromExternalAPI("/api/data");
    }

    @Test
    void testDeleteProduct_success() {
        when(productRepository.existsById(1L)).thenReturn(true);

        productService.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteProduct_notFound() {
        when(productRepository.existsById(1L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> productService.deleteProduct(1L));
    }
}
