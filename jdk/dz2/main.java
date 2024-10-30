import client.domain.ClientController;
import client.UI.ClientGUI;
import serv.domain.ServerController;
import serv.repo.FileStorage;
import serv.UI.ServerWindow;

public class Main {
    public static void main(String[] args) {

        ServerController serverController = new ServerController(new ServerWindow(), new FileStorage());

        new ClientController(new ClientGUI(), serverController);
        new ClientController(new ClientGUI(), serverController);
    }
}
