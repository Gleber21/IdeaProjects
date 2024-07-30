package Viewer.Command;

import Viewer.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super("Сортировать древо по возрасту.", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByAge();
    }

}
