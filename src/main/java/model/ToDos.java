package model;

public class ToDos extends Task {
    public ToDos(String description) {
        super(description);
    }

    @Override
    public String getDescription() {
        return "[T]" + "[" + getStatusIcon() + "] " + super.getDescription();
    }

    public String getFormat() {
        return "T | " + isDone + " | " + super.getDescription();
    }
}
