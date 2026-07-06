public class MVCPatternDemo {
    public static void main(String[] args) {

        // Create Model
        Student model = new Student();
        model.setName("Mrinmayee");
        model.setId(101);
        model.setGrade("A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(model, view);

        // Display initial data
        controller.updateView();

        System.out.println("-----------");

        // Update data using controller
        controller.setStudentName("Riya");
        controller.setStudentGrade("A+");

        // Display updated data
        controller.updateView();
    }
}