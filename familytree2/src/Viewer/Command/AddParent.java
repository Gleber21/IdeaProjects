package Viewer.Command;

import Viewer.ConsoleUI;

public class AddParent extends Command {
    public AddParent(ConsoleUI consoleUI) {
        super("Добавить родителя по ID.", consoleUI);
    }

    @Override
    public void execute() {
        this.getConsoleUI().addParent();
    }
}
