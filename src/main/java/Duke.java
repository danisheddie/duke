import Commands.Command;
import Ui.Ui;

public class Duke {
    private Ui ui;
    private Command command;

    public static void main(String[] args) throws Exception {
        Ui ui = new Ui();
        ui.start(); // Start message
        ui.run();

    }
}
