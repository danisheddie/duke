import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
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
                    System.out.println(".[" + lib.get(i).getStatusIcon() + "] " + lib.get(i).getDescription());
                }
                // Display everything
            } else if (cmd.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (cmd.contains("done")) {
                String[] allInputs = cmd.split(" "); // Split the input string by spaces
                System.out.println("Nice! KI've marked this task as done: ");
                for (String i : allInputs) {
                    if (!i.equals("done")) {
                        int index = Integer.parseInt(i) - 1; // Changing the string to integer
                        lib.get(index).tickIcon(); // Change the x to tick
                        System.out.println("[" + lib.get(index).getStatusIcon() + "] " + lib.get(index).getDescription());
                    }
                }
            } else {
                Task newTask = new Task(cmd);
                lib.add(newTask); // Add commands into the array
                System.out.println("added: " + cmd);
            }

        }
    }
}
