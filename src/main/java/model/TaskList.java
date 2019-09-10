package model;

import java.util.ArrayList;

/**
 * The TaskList class keep a state of all the added task in the @param tasksList.
 *
 * @author Danish
 * @version 0.1
 * @since 2019-08-14
 */

public class TaskList {
    private ArrayList<Task> taskList;

    /**
     * Constructor of the TaskList that initialize the TaskList
     */
    public TaskList() {
        taskList = new ArrayList<Task>();
    }

    /**
     * Method to add the task to the lisr
     * @param task
     */
    public void addToTask(Task task) {
        taskList.add(task);
    }

    /**
     * Method to return the task list in ArrayList type
     * @return the list of the task
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     * Get the size of the taskList
     * @return size of task list
     */
    public int getTaskListSize() {
        return taskList.size();
    }

    /**
     * Gets the index of the particular task
     * @param index
     * @return the particular index of the task
     */
    public Task getTask(int index) {
        return taskList.get(index);
    }

    /**
     * Deletes the task given the id of the task
     * @param index of the id of the task
     */
    public void deleteTaskList(int index) {
        taskList.remove(index - 1);
    }
}
