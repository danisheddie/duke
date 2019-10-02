package Ui;

//import Commands.ListCmd;
import Commands.ListCmd;
import Exceptions.DukeException;
import Parser.DateTime;
import Storage.Storage;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ui {
    public String cmd;

    public void start() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| |_| | |_| |   <  __/\n"
                + "| | | | | | | |/ / _ \\\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printLine();
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you");
        printLine();
    }


    private void printLine() {
        String lines = "\t____________________________________________________________";
        System.out.println(lines);
    }

    public void run(TaskList taskList, Scanner sc, Storage save) {

        boolean isExit = true;

        while (isExit) {
            String cmd = sc.nextLine(); // Will go next line after sending command
            String[] splitString = cmd.split(" ");
            List<String> listInputs;
            String description;
            String[] dayInput;

            String[] Inputs = cmd.split(" "); // Split the strongs by the spaces
            listInputs = new ArrayList<>(Arrays.asList(Inputs)); // Making the string into a list of strings
            listInputs.remove(0); // Remove the first index of the string which is "todo"
            description = String.join(" ", listInputs); // Will return the string "borrow book"

            switch (splitString[0]) {

                case "list":
                    new ListCmd(taskList).execute();
                    break;

                case "done":
                    String[] allInputs = cmd.split(" "); // Split the input string by spaces
                    System.out.println("Nice! I've marked this task as done: ");
                    for (String i : allInputs) {
                        if (!i.equals("done")) {
                            int index = Integer.parseInt(i) - 1; // Changing the string to integer
                            taskList.getTaskList().get(index).tickIcon(); // Change the x to tick
                            System.out.println(taskList.getTaskList().get(index).getDescription());
                        }
                    }
                    break;


                case "todo":
                    try {
                        if (listInputs.size() == 1) {
                            throw new DukeException("todo");
                        }
                    } catch (DukeException error) {
                        System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
                        continue;
                    }

                    ToDos newToDos = new ToDos(description); // Creating a new object
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("\t" + newToDos.getDescription());
                    taskList.getTaskList().add(newToDos); // Add the new task into the list of tasktodo
                    System.out.println("Now you have " + taskList.getTaskListSize() + " tasks in the list.");
                    break;

                case "deadline":
                    dayInput = description.split(" /by ");
                    Deadline newDeadline = new Deadline(dayInput[0], new DateTime().formatDateTime(dayInput[1])); // to select the description and day
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("\t" + newDeadline.getDescription());
                    taskList.getTaskList().add(newDeadline); // Add the new task into the list of tasktodo
                    System.out.println("Now you have " + taskList.getTaskList().size() + " tasks in the list.");
                    break;

                case "event":
                    dayInput = description.split(" /at ");
                    Events newEvent = new Events(dayInput[0], new DateTime().formatDateTime(dayInput[1])); // to select the description and day
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("\t" + newEvent.getDescription());
                    taskList.addToTask(newEvent); // Add the new task into the list of tasktodo
                    System.out.println("Now you have " + taskList.getTaskListSize() + " tasks in the list.");
                    break;

                case "find":
                    String findWord = cmd.substring(5); // The word start from index 5 of the cmd
                    ArrayList<Task> search = new ArrayList<>();
                    for (Task i : taskList.getTaskList()) {
                        if (i.getDescription().contains(findWord)) {
                            search.add(i);
                        }
                    }

                    System.out.println("Here are the matching task in your list: ");
                    for (int i = 0; i < search.size(); i++) {
                        System.out.print(i + 1);
                        System.out.println("." + search.get(i).getDescription());
                    }
                    break;

                case "delete":
                    allInputs = cmd.split(" "); // Split the input string by spaces
                    System.out.println("Noted. I've removed this task: ");
                    for (String i : allInputs) {
                        if (!i.equals("delete")) {
                            int index = Integer.parseInt(i); // Changing the string to integer
                            System.out.println("\t" + taskList.getTaskList().get(index - 1).getDescription());
                            taskList.deleteTaskList(index);
                            System.out.println("Now you have " + taskList.getTaskListSize() + " task in the list.");
                        }
                    }
                    break;

                case "bye":
                    isExit = false;
                    System.out.println("Bye. Hope to see you again soon!");
                    break;

                default:
                    try {
                        if (!cmd.matches("todo|deadlines|task|list|event"))
                            throw new DukeException(cmd);
                    } catch (DukeException error) {
                        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                    break;
            }
            // Save the input to text file
            save.saveToFile(taskList.getTaskList());
        }
    }

}
