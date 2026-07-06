public class CustomerRepositoryImpl implements CustomerRepository {

    public String findCustomerById(int id) {
        // Dummy data
        if (id == 1) {
            return "Mrinmayee Kulkarni is our customer";
        } else {
            return "Customer Not Found try again";
        }
    }
}