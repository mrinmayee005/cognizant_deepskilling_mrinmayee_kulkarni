public class TaskLinkedList {

    // Node class
    class Node {
        Task data;
        Node next;

        Node(Task data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // Add Task
    public void addTask(Task t) {
        Node newNode = new Node(t);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task Added");
    }

    // Search Task
    public void searchTask(int id) {
        Node temp = head;

        while (temp != null) {
            if (temp.data.taskId == id) {
                temp.data.display();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task Not Found");
    }

    // Traverse Tasks
    public void displayAll() {
        Node temp = head;

        while (temp != null) {
            temp.data.display();
            temp = temp.next;
        }
    }

    // Delete Task
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        // if first node
        if (head.data.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted");
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.data.taskId == id) {
                temp.next = temp.next.next;
                System.out.println("Task Deleted");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }
}