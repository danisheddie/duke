package model;

public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String getDescription() {
        return "[D]" + "[" + getStatusIcon() + "] " + super.getDescription() + " (by: " + by + ")";
    }

    public String getFormat() {
        return "D | " + isDone + " | " + super.getDescription() + by;
    }
}
