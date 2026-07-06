public class EmployeeManagement {

    Employee[] arr = new Employee[100]; // fixed size
    int count = 0;

    // Add Employee
    public void addEmployee(Employee e) {
        if (count < arr.length) {
            arr[count] = e;
            count++;
            System.out.println("Employee Added");
        } else {
            System.out.println("Array Full");
        }
    }

    // Search Employee
    public void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (arr[i].employeeId == id) {
                arr[i].display();
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    // Traverse Employees
    public void displayAll() {
        for (int i = 0; i < count; i++) {
            arr[i].display();
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (arr[i].employeeId == id) {

                // shift elements
                for (int j = i; j < count - 1; j++) {
                    arr[j] = arr[j + 1];
                }

                count--;
                System.out.println("Employee Deleted");
                return;
            }
        }
        System.out.println("Employee Not Found");
    }
}