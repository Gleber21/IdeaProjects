package Viewer;

import Viewer.Command.AddParent;
import Viewer.Command.GetFamilyTree;
import Viewer.Command.SortByName;
import Viewer.Command.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        this.commands = new ArrayList<>();
        commands.add(new AddElement(consoleUI));
        commands.add(new AddParent(consoleUI));
        commands.add(new GetFamilyTree(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SaveTree(consoleUI));
        commands.add(new ReadTree(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public int getNumberOfCommands() {
        return commands.size();
    }
    public String getMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите номер команды:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1).append(". ")
                    .append(commands.get(i).getDescription()).append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice){
        Command command = commands.get(choice - 1);
        command.execute();
    }
}