package exercises;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductControllerMockTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    void testCreateProduct() {
        Product product = new Product("Laptop", 999.99, 10);
        when(productService.createProduct(product)).thenReturn(product);

        var response = productController.createProduct(product);

        assertEquals(201, response.getStatusCode().value());
        assertEquals("Laptop", response.getBody().getName());
        verify(productService, times(1)).createProduct(product);
    }

    @Test
    void testGetProductById() {
        Product product = new Product("Laptop", 999.99, 10);
        when(productService.getProductById(1L)).thenReturn(product);

        var response = productController.getProductById(1L);

        assertEquals(200, response.getStatusCode().value());
        assertEquals("Laptop", response.getBody().getName());
        verify(productService, times(1)).getProductById(1L);
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productService).deleteProduct(1L);

        var response = productController.deleteProduct(1L);

        assertEquals(204, response.getStatusCode().value());
        verify(productService, times(1)).deleteProduct(1L);
    }
}
