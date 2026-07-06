public class TestDI {
    public static void main(String[] args) {

        // Create repository
        CustomerRepository repo = new CustomerRepositoryImpl();

        // Inject dependency
        CustomerService service = new CustomerService(repo);

        // Use service
        service.getCustomer(1);
        service.getCustomer(2);
    }
}