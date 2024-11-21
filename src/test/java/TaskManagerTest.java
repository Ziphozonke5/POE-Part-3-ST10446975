import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TaskManagerTest {

    @BeforeAll
    public static void setUp() {
        // Populate test data before running tests
        TaskManager.populateTestData();
    }

    @Test
    public void testDisplayDoneTasks() {
        // Capture the output
        String expectedOutput = "Done Tasks:\nDeveloper: Samantha Paulson, Task Name: Create Reports, Duration: 2\n";
        assertEquals(expectedOutput.trim(), getOutput(TaskManager::displayDoneTasks).trim());
    }

    @Test
    public void testDisplayLongestTask() {
        // Capture the output
        String expectedOutput = "Developer with longest task: Glenda Oberholzer, Duration: 11";
        assertEquals(expectedOutput.trim(), getOutput(TaskManager::displayLongestTask).trim());
    }

    @Test
    public void testSearchTaskByName() {
        String expectedOutput = "Task: Create Login, Developer: Mike Smith, Status: To Do";
        assertEquals(expectedOutput.trim(), getOutput(() -> TaskManager.searchTaskByName("Create Login")).trim());
    }

    @Test
    public void testSearchTasksByDeveloper() {
        String expectedOutput = "Task: Create Reports, Status: Done\n";
        assertEquals(expectedOutput.trim(), getOutput(() -> TaskManager.searchTasksByDeveloper("Samantha Paulson")).trim());
    }

    @Test
    public void testDeleteTask() {
        TaskManager.deleteTask("Create Reports");
        assertEquals("Task not found.", getOutput(() -> TaskManager.searchTaskByName("Create Reports")).trim());
    }

    @Test
    public void testDisplayReport() {
        String expectedOutput = "Task Report:\n" +
                "Task ID: 1, Developer: Mike Smith, Task: Create Login, Duration: 5, Status: To Do\n" +
                "Task ID: 2, Developer: Edward Harrison, Task: Create Add Features, Duration: 8, Status: Doing\n" +
                "Task ID: 4, Developer: Glenda Oberholzer, Task: Add Arrays, Duration: 11, Status: To Do\n";
        assertEquals(expectedOutput.trim(), getOutput(TaskManager::displayReport).trim());
    }

    // Utility method to capture output from methods that print to console
    private String getOutput(Runnable method) {
        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));
        method.run();
        return outputStream.toString();
    }

    // Overloaded method to capture output from methods that return String
    private String getOutput(java.util.function.Consumer<String> method) {
        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));
        method.accept(null);
        return outputStream.toString();
    }
}
