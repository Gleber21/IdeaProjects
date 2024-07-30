package Viewer.Command;

import Viewer.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super("Сортировать древо по имени", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByName();
    }
}
