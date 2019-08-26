public class Events extends Task {
    protected String day;
    protected String time;

    public Events(String description, String day, String time) {
        super(description);
        this.day = day;
        this.time = time;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + day + time + ")";
    }
}
