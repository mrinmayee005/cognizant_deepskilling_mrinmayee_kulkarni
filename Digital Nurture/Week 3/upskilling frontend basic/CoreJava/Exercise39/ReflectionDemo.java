/**
 * Exercise 39: Reflection Demo
 * Objective: Use Java Reflection to inspect and invoke methods at runtime.
 * Compile: javac ReflectionDemo.java
 * Run: java ReflectionDemo
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Student {
    private String name;
    private int age;
    private double gpa;

    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.gpa = 0.0;
    }

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    public boolean isHonorRoll() {
        return gpa >= 3.5;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", gpa=" + gpa + "}";
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Java Reflection Demo ===\n");

        // Get the Class object
        Class<?> studentClass = Class.forName("Student");

        // 1. Inspect class information
        System.out.println("--- Class Information ---");
        System.out.println("Class Name: " + studentClass.getName());
        System.out.println("Simple Name: " + studentClass.getSimpleName());
        System.out.println("Superclass: " + studentClass.getSuperclass().getName());
        System.out.println("Modifiers: " + Modifier.toString(studentClass.getModifiers()));

        // 2. Inspect constructors
        System.out.println("\n--- Constructors ---");
        Constructor<?>[] constructors = studentClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("  " + constructor);
            Class<?>[] paramTypes = constructor.getParameterTypes();
            System.out.print("    Parameters: ");
            for (Class<?> param : paramTypes) {
                System.out.print(param.getSimpleName() + " ");
            }
            System.out.println();
        }

        // 3. Inspect fields
        System.out.println("\n--- Fields ---");
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("  " + Modifier.toString(field.getModifiers()) + " "
                    + field.getType().getSimpleName() + " " + field.getName());
        }

        // 4. Inspect methods
        System.out.println("\n--- Methods ---");
        Method[] methods = studentClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("  " + Modifier.toString(method.getModifiers()) + " "
                    + method.getReturnType().getSimpleName() + " " + method.getName()
                    + " " + java.util.Arrays.toString(method.getParameterTypes()));
        }

        // 5. Create an instance using reflection
        System.out.println("\n--- Creating Instance via Reflection ---");
        Constructor<?> constructor = studentClass.getConstructor(String.class, int.class, double.class);
        Object student = constructor.newInstance("Alice", 20, 3.8);
        System.out.println("Created: " + student);

        // 6. Invoke methods using reflection
        System.out.println("\n--- Invoking Methods via Reflection ---");
        Method getNameMethod = studentClass.getMethod("getName");
        String name = (String) getNameMethod.invoke(student);
        System.out.println("getName(): " + name);

        Method getAgeMethod = studentClass.getMethod("getAge");
        int age = (int) getAgeMethod.invoke(student);
        System.out.println("getAge(): " + age);

        Method isHonorRollMethod = studentClass.getMethod("isHonorRoll");
        boolean isHonor = (boolean) isHonorRollMethod.invoke(student);
        System.out.println("isHonorRoll(): " + isHonor);

        // 7. Modify private fields
        System.out.println("\n--- Modifying Private Fields ---");
        Field nameField = studentClass.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println("Before: " + nameField.get(student));
        nameField.set(student, "Bob");
        System.out.println("After:  " + nameField.get(student));

        Field gpaField = studentClass.getDeclaredField("gpa");
        gpaField.setAccessible(true);
        gpaField.set(student, 3.2);
        System.out.println("Updated GPA: " + gpaField.get(student));

        System.out.println("\nFinal state: " + student);

        // 8. Create instance with default constructor
        System.out.println("\n--- Default Constructor ---");
        Constructor<?> defaultConstructor = studentClass.getConstructor();
        Object defaultStudent = defaultConstructor.newInstance();
        System.out.println("Default student: " + defaultStudent);
    }
}
