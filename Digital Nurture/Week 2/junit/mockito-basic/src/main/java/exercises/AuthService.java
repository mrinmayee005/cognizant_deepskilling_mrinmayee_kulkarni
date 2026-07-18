package exercises;

public class AuthService {
    private final EmployeeRepository repository;

    public AuthService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public boolean authenticate(String username, String password) {
        // Simplified authentication
        return "admin".equals(username) && "password123".equals(password);
    }

    public void voidMethod(String input) {
        // Method that performs an action but returns void
        System.out.println("Processing: " + input);
    }

    public int calculateBonus(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }
        return (int) (salary * 0.10);
    }

    public String getStatus(int code) {
        if (code == 200) return "OK";
        if (code == 404) return "Not Found";
        if (code == 500) return "Server Error";
        return "Unknown";
    }
}
