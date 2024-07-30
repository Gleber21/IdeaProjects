package Viewer.Command;

import Viewer.ConsoleUI;

public class SaveTree extends Command {
    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить древо в файл.",consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().saveTree();
    }
}
