package Viewer.Command;

import Viewer.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super("Окончание работы.", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().finish();
    }
}
