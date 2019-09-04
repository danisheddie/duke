import Exceptions.DukeException;
import Parser.DateTime;
import Storage.Storage;
import Ui.Ui;
import model.Deadline;
import model.Events;
import model.Task;
import model.ToDos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Duke {
    private Ui ui;
    public static void main(String[] args) throws Exception {
        Ui ui = new Ui();
        ui.start(); // Start message
        ArrayList<Task> lib = new ArrayList<Task>(); // Store command in array
        Scanner sc = new Scanner(System.in); // To read input
        Storage save = new Storage(lib);
        Storage read = new Storage(lib);
        read.ReadFile(lib);


        while (true) {
            String cmd = sc.nextLine(); // Will go next line after sending command
            if (cmd.equals("list")) { // Will print out all the command that is in the array
                System.out.println("Here are the tasks in your list: ");
                for (int i = 0; i < lib.size(); i++) {
                    System.out.print(i + 1);
                    System.out.println("." + lib.get(i).getDescription());
                }
                // Display everything
            } else if (cmd.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;

            } else if (cmd.contains("done")) {
                String[] allInputs = cmd.split(" "); // Split the input string by spaces
                System.out.println("Nice! I've marked this task as done: ");
                for (String i : allInputs) {
                    if (!i.equals("done")) {
                        int index = Integer.parseInt(i) - 1; // Changing the string to integer
                        lib.get(index).tickIcon(); // Change the x to tick
                        System.out.println(lib.get(index).getDescription());
                        save.saveToFile(lib);
                    }
                }

            } else if (cmd.contains("todo")) { // If cmd contains todo
                String[] todoInputs = cmd.split(" "); // Split the strongs by the spaces

                List<String> listInputs = new ArrayList<>(Arrays.asList(todoInputs)); // Making the string into a list of strings
                try {
                    if (listInputs.size() == 1) {
                        throw new DukeException("todo");
                    }
                } catch (DukeException error) {
                    System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
                    continue;
                }

                listInputs.remove(0); // Remove the first index of the string which is "todo"
                String description = String.join(" ", listInputs); // Will return the string "borrow book"
                ToDos newToDos = new ToDos(description); // Creating a new object
                System.out.println("Got it. I've added this task: ");
                System.out.println("\t" + newToDos.getDescription());
                lib.add(newToDos); // Add the new task into the list of tasktodo
                save.saveToFile(lib);
                System.out.println("Now you have " + lib.size() + " tasks in the list.");


            } else if (cmd.contains("deadline")) { // IF cmd contains deadline
                String[] deadlineInputs = cmd.split(" ");
                List<String> listInputs = new ArrayList<>(Arrays.asList(deadlineInputs)); // Making the string into a list of strings
                listInputs.remove(0); // Remove the first index of the string which is "deadline"
                String description = String.join(" ", listInputs); // Will return the string "borrow book"
                String[] dayInput = description.split(" /by ");
                Deadline newDeadline = new Deadline(dayInput[0], new DateTime().formatDateTime(dayInput[1])); // to select the description and day
                System.out.println("Got it. I've added this task: ");
                System.out.println("\t" + newDeadline.getDescription());
                lib.add(newDeadline); // Add the new task into the list of tasktodo
                save.saveToFile(lib);
                System.out.println("Now you have " + lib.size() + " tasks in the list.");

            } else if (cmd.contains("event")) { // If cmd contains event
                String[] eventInputs = cmd.split(" "); // Split all the string by spaces
                List<String> listInputs = new ArrayList<>(Arrays.asList(eventInputs)); // Making the string into a LIST of strings
                listInputs.remove(0); // Remove the first index of the string which is "deadline"
                String description = String.join(" ", listInputs); // Join back the list of strings. Will return the string "borrow book"
                String[] dayInput = description.split(" /at ");
                Events newEvent = new Events(dayInput[0], new DateTime().formatDateTime(dayInput[1])); // to select the description and day
                System.out.println("Got it. I've added this task: ");
                System.out.println("\t" + newEvent.getDescription());
                lib.add(newEvent); // Add the new task into the list of tasktodo
                save.saveToFile(lib);
                System.out.println("Now you have " + lib.size() + " tasks in the list.");

            } else if (cmd.contains("delete")) {
                // Add code here
                String[] allInputs = cmd.split(" "); // Split the input string by spaces
                System.out.println("Noted. I've removed this task: ");
                for (String i : allInputs) {
                    if (!i.equals("delete")) {
                        int index = Integer.parseInt(i) - 1; // Changing the string to integer
//                        lib.get(index).tickIcon(); // Change the x to tick
                        System.out.println("\t" + lib.get(index).getDescription());
                        lib.remove(index);
                        System.out.println("Now you have " + lib.size() + " task in the list.");
                        save.saveToFile(lib);
                    }
                }

            } else if (cmd.startsWith("find")) {
                String findWord = cmd.substring(5); // The word start from index 5 of the cmd
                ArrayList<Task> search = new ArrayList<>();
                for (Task i : lib) {
                    if (i.getDescription().contains(findWord)) {
                        search.add(i);
                    }
                }
                System.out.println("Here are the matching task in your list: ");
                for (int i = 0; i < search.size(); i++) {
                    System.out.print(i + 1);
                    System.out.println("." + search.get(i).getDescription());
                }

            } else {
                try {
                    if (!cmd.matches("todo|deadlines|task|list|event"))
                        throw new DukeException(cmd);
                } catch (DukeException error) {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }

        }
    }
}
