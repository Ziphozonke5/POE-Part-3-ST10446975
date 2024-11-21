public class Task {
    private String name;
    private String developer;
    private String assignedTo;
    private String status;
    private int duration;
    private int priority;

    // Constructor, getters, and setters
    public Task(String name, String developer, String assignedTo, String status, int duration, int priority) {
        this.name = name;
        this.developer = developer;
        this.assignedTo = assignedTo;
        this.status = status;
        this.duration = duration;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public int getDuration() {
        return duration;
    }

    public int getPriority() {
        return priority;
    }
}