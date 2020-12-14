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
     * Trzeba ustawic nieaktywne pionki i pola
     */
    Board board = new Board(10,10);
    this.setBoard(board);
    
    server.broadcast("createBoard;10;10");
    server.broadcast("insertPawn;1;1;1");
    server.broadcast("insertPawn;0;0;0");
    /*
     * 
     */
    this.gameLoop();
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


