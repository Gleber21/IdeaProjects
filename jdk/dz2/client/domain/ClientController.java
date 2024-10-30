package client.domain;

import client.UI.ClientView;
import serv.domain.ServerController;


public class ClientController {
    private boolean connected;
    private String name;
    private ClientView clientView;
    private ServerController serverController;


    public ClientController(ClientView clientView, ServerController serverController) {
        this.clientView = clientView;
        this.serverController = serverController;
        clientView.setClientController(this);
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (serverController.connectUser(this)){
            showOnWindow("We has been connect!\\n");
            connected = true;
            String log = serverController.getHistory();
            if (log != null){
                showOnWindow(log);
            }
            return true;
        } else {
            showOnWindow("Connect is false");
            return false;
        }
    }


    public void answerFromServer(String text) {
        showOnWindow(text);
    }



    public void disconnectedFromServer() {
        if (connected) {
            connected = false;
            clientView.disconnectedFromServer();
            showOnWindow("we has been offline!");
        }
    }


    public void disconnectFromServer() {
        serverController.disconnectUser(this);
    }


    public void message(String text) {
        if (connected) {
            if (!text.isEmpty()) {
                serverController.message(name + ": " + text);
            }
        } else {
            showOnWindow("not connect in internet");
        }
    }


    public String getName() {
        return name;
    }

    private void showOnWindow(String text) {
        clientView.showMessage(text + "\\n");
    }
}

