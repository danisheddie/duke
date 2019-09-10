package model;

/**
 * You can control the interface of how each method of the task can be handles
 * This is a parent class for the sub-classes of Todo, Event and deadlines
 * This class contains the method of how each sub-classes can be implemented
 *
 * @author Danish
 * @version 0.1
 * @since 2019-08-14
 */

// Task contains the behavious to getStatusicon, tickIcon, getFormat, getDescription
public class Task {
    private String description;
    public boolean isDone;

    /**
     * This is the constructor to initialise description and whether the task is done
     * @param description
     */
    public Task(String description) { // This is a constructor
        this.description = description;
        this.isDone = false;
    }

    /**
     * The status icon whether it is completed or incomplete
     * The tick represents complete, the cross represents incomplete
     * @return status of the task
     */
    public String getStatusIcon() {
        return (isDone ? "✓" : "✘"); //return tick or X symbols
    }

    /**
     * To change the tatus of the task once it is done
     * @return status of the task
     */
    public void tickIcon() {
        isDone = true;
    }

    /**
     * This method is to get the proper format
     * @return format of the string
     */
    public String getFormat() {
        return "x";
    }

    /**
     * The method that will retrieve the description of the task
     * @return Description that describes the task
     */
    public String getDescription() {
        return description;
    }

//    public String getDate() {
//        return date;
//    }
}
