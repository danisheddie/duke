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
        ArrayList<String> lib = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String cmd = sc.nextLine();
            if (cmd.equals("list")) {
                for (int i = 0; i < lib.size(); i++) {
                    System.out.print(i + 1);
                    System.out.println(". " + lib.get(i));
                }
                // Display everything
            } else if (cmd.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                lib.add(cmd);
                System.out.println("added: " + cmd);
            }

        }
    }
}
