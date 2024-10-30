package serv.UI;

import serv.domain.ServerController;


public interface ServerView {
    void showMessage(String message);
    void setServerController(ServerController serverController);
}