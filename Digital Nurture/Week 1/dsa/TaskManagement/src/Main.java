public class Main {
    public static void main(String[] args) {

        TaskLinkedList list = new TaskLinkedList();

        list.addTask(new Task(1, "Design UI", "Pending"));
        list.addTask(new Task(2, "Write Code", "In Progress"));

        System.out.println("All Tasks:");
        list.displayAll();

        System.out.println("Search:");
        list.searchTask(1);

        System.out.println("Delete:");
        list.deleteTask(1);

        list.displayAll();
    }
}