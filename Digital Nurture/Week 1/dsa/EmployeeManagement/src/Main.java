public class Main {
    public static void main(String[] args) {

        EmployeeManagement em = new EmployeeManagement();

        em.addEmployee(new Employee(1, "A", "Manager", 50000));
        em.addEmployee(new Employee(2, "B", "Developer", 40000));

        System.out.println("All Employees:");
        em.displayAll();

        System.out.println("Search:");
        em.searchEmployee(1);

        System.out.println("Delete:");
        em.deleteEmployee(1);

        em.displayAll();
    }
}