package Viewer.Command;

import Viewer.ConsoleUI;

public class GetFamilyTree extends Command {
    public GetFamilyTree(ConsoleUI consoleUI) {
        super("Показать древо.", consoleUI);
    }


    @Override
    public void execute() {
        super.getConsoleUI().getTree();
    }
}
