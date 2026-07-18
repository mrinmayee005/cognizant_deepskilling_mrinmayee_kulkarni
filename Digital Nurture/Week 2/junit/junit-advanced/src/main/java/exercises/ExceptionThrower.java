package exercises;

public class ExceptionThrower {
    public void throwCheckedException() throws Exception {
        throw new Exception("Checked exception occurred");
    }

    public void throwRuntimeException() {
        throw new RuntimeException("Runtime exception occurred");
    }

    public void throwIllegalArgumentException(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
    }

    public void throwArithmeticException(int a, int b) {
        int result = a / b;
    }

    public String riskyOperation(String input) {
        if (input == null) {
            throw new NullPointerException("Input is null");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input is empty");
        }
        return input.toUpperCase();
    }
}
