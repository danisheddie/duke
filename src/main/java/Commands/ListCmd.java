package Commands;

import model.TaskList;

public class ListCmd {
    private TaskList taskList;
    public ListCmd(TaskList taskList){
        this.taskList = taskList;
    }

    public void execute(){
        System.out.println("Here are the tasks in your list: ");

        for (int i = 0; i < taskList.getTaskListSize(); i++) {
            System.out.print(i + 1);
            System.out.println("." + taskList.getTask(i).getDescription());
        }
    }
}


