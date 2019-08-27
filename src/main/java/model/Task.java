package model;

public class Task {
    private String description;
    protected boolean isDone;
    private String date = "";


    public Task(String description) { // This is a constructor
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {

        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void tickIcon() {
        isDone = true;
    }

    public String getFormat() {
        return "x";
    }

    public String getDescription() {

        return description;
    }

    public String getDate() {
        return date;
    }
}
