package Ui;

public class Ui {

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


    public void printLine() {
        String lines = "\t____________________________________________________________";
        System.out.println(lines);
    }
}
