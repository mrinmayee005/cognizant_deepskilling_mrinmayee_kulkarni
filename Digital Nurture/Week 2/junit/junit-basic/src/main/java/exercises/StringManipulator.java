package exercises;

public class StringManipulator {
    public String reverseString(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public String toUpperCase(String input) {
        if (input == null) {
            return null;
        }
        return input.toUpperCase();
    }

    public boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public String concat(String a, String b) {
        if (a == null) a = "";
        if (b == null) b = "";
        return a + b;
    }
}
