import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws Exception {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you");
        ArrayList<Task> lib = new ArrayList<Task>(); // Store command in array
        Scanner sc = new Scanner(System.in); // To read input

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
                    }
                }
            } else if (cmd.contains("todo")) {
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
                System.out.println("Now you have " + lib.size() + " tasks in the list.");

            } else if (cmd.contains("deadline")) {
                String[] deadlineInputs = cmd.split(" ");
                List<String> listInputs = new ArrayList<>(Arrays.asList(deadlineInputs)); // Making the string into a list of strings
                listInputs.remove(0); // Remove the first index of the string which is "deadline"
                String description = String.join(" ", listInputs); // Will return the string "borrow book"
                String[] dayInput = description.split(" /by ");
                Deadline newDeadline = new Deadline(dayInput[0], dayInput[1]); // to select the description and day
                System.out.println("Got it. I've added this task: ");
                System.out.println("\t" + newDeadline.getDescription());
                lib.add(newDeadline); // Add the new task into the list of tasktodo
                System.out.println("Now you have " + lib.size() + " tasks in the list.");

            } else if (cmd.contains("event")) {
                String[] eventInputs = cmd.split(" ");
                List<String> listInputs = new ArrayList<>(Arrays.asList(eventInputs)); // Making the string into a list of strings
                listInputs.remove(0); // Remove the first index of the string which is "deadline"
                String description = String.join(" ", listInputs); // Will return the string "borrow book"
                String[] dayInput = description.split(" /at ");
                Events newEvent = new Events(dayInput[0], dayInput[1]); // to select the description and day
                System.out.println("Got it. I've added this task: ");
                System.out.println("\t" + newEvent.getDescription());
                lib.add(newEvent); // Add the new task into the list of tasktodo
                System.out.println("Now you have " + lib.size() + " tasks in the list.");

            } else {
                try {
                    throw new DukeException("blah");
                } catch (DukeException error) {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
//                Task newTask = new Task(cmd);
//                lib.add(newTask); // Add commands into the array
//                System.out.println("added: " + cmd);
            }

        }
    }
}
