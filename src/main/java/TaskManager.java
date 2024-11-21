import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    
    // Arrays to store the task information
    static String[] developers = new String[10];
    static String[] taskNames = new String[10];
    static int[] taskIDs = new int[10];
    static int[] taskDurations = new int[10];
    static String[] taskStatuses = new String[10];
    
    // Method to populate arrays with test data
    public static void populateTestData() {
        // Test Data
        developers[0] = "Mike Smith";
        taskNames[0] = "Create Login";
        taskIDs[0] = 1;
        taskDurations[0] = 5;
        taskStatuses[0] = "To Do";

        developers[1] = "Edward Harrison";
        taskNames[1] = "Create Add Features";
        taskIDs[1] = 2;
        taskDurations[1] = 8;
        taskStatuses[1] = "Doing";

        developers[2] = "Samantha Paulson";
        taskNames[2] = "Create Reports";
        taskIDs[2] = 3;
        taskDurations[2] = 2;
        taskStatuses[2] = "Done";

        developers[3] = "Glenda Oberholzer";
        taskNames[3] = "Add Arrays";
        taskIDs[3] = 4;
        taskDurations[3] = 11;
        taskStatuses[3] = "To Do";
    }

    // a. Display Developer, Task Name, and Task Duration for all tasks with status "Done"
    public static void displayDoneTasks() {
        System.out.println("Done Tasks:");
        for (int i = 0; i < developers.length; i++) {
            if (taskStatuses[i] != null && taskStatuses[i].equalsIgnoreCase("Done")) {
                System.out.println("Developer: " + developers[i] + ", Task Name: " + taskNames[i] + ", Duration: " + taskDurations[i]);
            }
        }
    }

    // b. Display Developer and Duration for task with longest duration
    public static void displayLongestTask() {
        int maxDuration = -1;
        String developer = "";
        for (int i = 0; i < taskDurations.length; i++) {
            if (taskDurations[i] > maxDuration) {
                maxDuration = taskDurations[i];
                developer = developers[i];
            }
        }
        System.out.println("Developer with longest task: " + developer + ", Duration: " + maxDuration);
    }

    // c. Search for a task by Task Name and display details
    public static void searchTaskByName(String taskName) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null && taskNames[i].equalsIgnoreCase(taskName)) {
                System.out.println("Task: " + taskNames[i] + ", Developer: " + developers[i] + ", Status: " + taskStatuses[i]);
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // d. Search for all tasks assigned to a developer and display Task Name and Status
    public static void searchTasksByDeveloper(String developerName) {
        boolean found = false;
        for (int i = 0; i < developers.length; i++) {
            if (developers[i] != null && developers[i].equalsIgnoreCase(developerName)) {
                System.out.println("Task: " + taskNames[i] + ", Status: " + taskStatuses[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found for this developer.");
        }
    }

    // e. Delete a task using Task Name
    public static void deleteTask(String taskName) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null && taskNames[i].equalsIgnoreCase(taskName)) {
                taskNames[i] = null;
                developers[i] = null;
                taskDurations[i] = 0;
                taskStatuses[i] = null;
                taskIDs[i] = 0;
                System.out.println("Task '" + taskName + "' successfully deleted.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // f. Display a report with full details of all tasks
    public static void displayReport() {
        System.out.println("Task Report:");
        for (int i = 0; i < developers.length; i++) {
            if (taskNames[i] != null) {
                System.out.println("Task ID: " + taskIDs[i] + ", Developer: " + developers[i] + ", Task: " + taskNames[i]
                        + ", Duration: " + taskDurations[i] + ", Status: " + taskStatuses[i]);
            }
        }
    }

    // Main method to test the application
    public static void main(String[] args) {
        // Populate the data
        populateTestData();

        // Display Done tasks
        displayDoneTasks();

        // Display the longest task
        displayLongestTask();

        // Search for a task by Task Name
        searchTaskByName("Create Login");

        // Search for tasks assigned to a developer
        searchTasksByDeveloper("Samantha Paulson");

        // Delete a task
        deleteTask("Create Reports");

        // Display the report
        displayReport();
    }
}
