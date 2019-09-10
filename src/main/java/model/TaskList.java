package model;

import java.util.ArrayList;

/**
 *
 */

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() { // Constructor for TaskList to instantiate taskList
        taskList = new ArrayList<Task>();
    }

    public void addToTask(Task task) {
        taskList.add(task);
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public int getTaskListSize() {
        return taskList.size();
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public void deleteTaskList(int index) {
        taskList.remove(index - 1);
    }
}
