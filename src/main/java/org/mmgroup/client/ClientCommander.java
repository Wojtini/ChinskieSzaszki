package org.mmgroup.client;

import org.mmgroup.UI.GUI;
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
      if(game.getClient().getCurrentPlayersTurnId() == client.getId()) {
        game.canSelectNewPawn = false;
        game.currentPosPawnX = toX;
        game.currentPosPawnY = toY;
      }
      game.getGui().repaintBoard();
      break;
    case "createBoard":
      int x = Integer.parseInt(args[1]);
      int y = Integer.parseInt(args[2]);
      game.setBoard(new Board(x,y));
      System.out.println("ClientCommadner: Stworzono board");
      game.setGUI(new GUI(game,game.getClient()));
      break;
    case "insertPawn":
      int xpawn = Integer.parseInt(args[1]);
      int ypawn = Integer.parseInt(args[2]);
      int id = Integer.parseInt(args[3]);
      game.getBoard().insertPawn(xpawn, ypawn, id);
      game.getGui().repaintBoard();
      break;
    case "setFieldActive":
      int xField = Integer.parseInt(args[1]);
      int yField = Integer.parseInt(args[2]);
      int bool = Integer.parseInt(args[3]); //1 - true, 0 - false 
      game.getBoard().toggleActive(xField, yField, bool==1);
      game.getGui().repaintBoard();
      break;
    case "newTurn":
      int turaGracza = Integer.parseInt(args[1]);
      if(turaGracza == client.getId()) {
        client.setMyTurn(true);
        //reset zaznaczonego pionka
        game.currentPosPawnY = -1;
        game.currentPosPawnX = -1;
        game.canSelectNewPawn = true;
        game.getGui().repaintBoard();
      }else {
        client.setMyTurn(false);
      }
      client.setCurrentPlayersTurnId(turaGracza);
      game.getGui().setKomunikat("Twoje ID: " + client.getId() + " Tura gracza o id: " + turaGracza);
      break;
    }
  }
}
