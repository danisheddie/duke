import Commands.Command;
import Storage.Storage;
import Ui.Ui;
import model.TaskList;

import java.util.Scanner;

public class Duke {
    private Ui ui;
    private Command command;

    public static void main(String[] args) throws Exception {
        Ui ui = new Ui();
        ui.start(); // Start message
        TaskList taskList = new TaskList();
        Scanner sc = new Scanner(System.in); // To read input
        Storage save = new Storage(taskList.getTaskList());
        Storage read = new Storage(taskList.getTaskList());
        read.ReadFile(taskList.getTaskList());
        ui.run(taskList, sc, save);
    }
}
