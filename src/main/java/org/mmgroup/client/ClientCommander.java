package org.mmgroup.client;

import org.mmgroup.gamelogic.Board;
import org.mmgroup.gamelogic.Game;

public class ClientCommander {
  Game game;
  
  public ClientCommander(Game game) {
    this.game = game;
  }

  public void handleMessage(Client client,String message) {
    //System.out.println(this + " CLIENT: Dostano wiadomosc od Server: " + message);
    String[] args = message.split(";");
    switch(args[0]) {
    case "printToConsole":
      System.out.println(client + ": server rozkazał printa: " + args[1]);
      break;
    case "setId":
      int newId = Integer.parseInt(args[1]);
      client.setId(newId);
      break;
    case "movePawn":
      int fromX = Integer.parseInt(args[1]);
      int fromY = Integer.parseInt(args[2]);
      int toX = Integer.parseInt(args[3]);
      int toY = Integer.parseInt(args[4]);
      game.getBoard().movePawn(fromX, fromY, toX, toY);
      break;
    case "createBoard":
      int x = Integer.parseInt(args[1]);
      int y = Integer.parseInt(args[2]);
      game.setBoard(new Board(x,y));
      break;
    case "insertPawn":
      int xpawn = Integer.parseInt(args[1]);
      int ypawn = Integer.parseInt(args[2]);
      int id = Integer.parseInt(args[2]);
      game.getBoard().insertPawn(xpawn, ypawn, id);
      break;
    case "newTurn":
      int turaGracza = Integer.parseInt(args[1]);
      if(turaGracza == client.getId()) {
        client.setMyTurn(true);
      }else {
        client.setMyTurn(false);
      }
      client.setCurrentPlayersTurnId(turaGracza);
      break;
    }
  }
}
