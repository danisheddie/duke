package model;

public class Events extends Task {
    protected String day;

    public Events(String description, String day) {
        super(description);
        this.day = day;
    }

    @Override
    public String getDescription() {
        return "[E]" + "[" + getStatusIcon() + "] " + super.getDescription() + " (at: " + day + ")";
    }

    @Override
    public String getFormat() {
        return "E | " + isDone + " | " + super.getDescription() + " | " + day;
    }
}
