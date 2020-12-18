package org.mmgroup.server;

import java.util.concurrent.TimeUnit;

import org.mmgroup.gamelogic.Board;

public class GameLobby {
  Board board;
  Server server;
  
  public GameLobby(Server server) {
    this.server = server;
  }
  
  public void setBoard(Board board) {
    this.board = board;
  }
  
  public Board getBoard() {
    return board;
  }
  
  public void startGame() {
    /*
     * Trzeba ustawic nieaktywne pionki i pola fabryczka czy cus
     */
    BoardFactory bf = new CheckersFactory();
    Board board = bf.buildBoard(server.getNumberOfPlayers());
    this.setBoard(board);
    sendBoard();
    /*
     * 
     */
    this.gameLoop();
  }
  
  public void sendBoard() {
    server.broadcast("createBoard;"+board.getWidth()+";"+board.getHeight());
    for(int i=0;i<board.getWidth();i++) {
      for(int j=0;j<board.getHeight();j++) {
        if(board.Grid[i][j].getActive()) {
          server.broadcast("setFieldActive;"+i+";"+j+";1");
          if(board.Grid[i][j].getPawn()!=null) {
            server.broadcast("insertPawn;"+i+";"+j+";"+board.Grid[i][j].getPawn().getOwnerId());
          }
        }else {
          server.broadcast("setFieldActive;"+i+";"+j+";0");
        }
      }
    }
  }
  
  public void gameLoop() {
    //server.numberOfPlayers;
    int turaGracza = 0;
    boolean czyKoniecRozgrywki = false;
    while(!czyKoniecRozgrywki) {
      server.getAllPlayers().get(turaGracza).setTurn(true);
      server.broadcast("newTurn;"+turaGracza);
      System.out.println("SERVER: Tura Gracza o ID: " + turaGracza);
      /*
       * Czekanie az gracz skonczy ture
       */
      while(server.getAllPlayers().get(turaGracza).isItsTurn()) {
        //Bez tego nie działa (może jakiś hazard, przyjrze się potem)
        Wait(1);
        System.out.println("Oczekiwanie na gracza numer: " + server.getAllPlayers().get(turaGracza).getId() + " " + turaGracza + " - ");
      };
      /*
       * Sprawdzenie czy ktos wygral, jesli nie to nowa tura z nowym graczem
       */
      System.out.println("SERVER: GRACZ o ID: " + turaGracza + " zakonczyl ture ");
      turaGracza = turaGracza + 1;
      turaGracza = turaGracza % server.numberOfPlayers;
      System.out.println(turaGracza);
    }
    System.out.println("Koniec gry");
  }
  
  public void Wait(int sec) {
    try {
      TimeUnit.SECONDS.sleep(sec);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}


