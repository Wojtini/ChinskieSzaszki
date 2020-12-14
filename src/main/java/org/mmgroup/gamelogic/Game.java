package org.mmgroup.gamelogic;

import org.mmgroup.client.Client;

public class Game {
  Board board;
  Client client;
  Thread clientThread;
  
  public Game(String address,int port) {
    client = new Client();
    client.Connect(address, port, this);
    
    clientThread = new Thread(client);
    clientThread.start();
    
    //Stworzenie UI z grą
  }
  
  public Board getBoard() {
    return board;
  }
  
  public void setBoard(Board board) {
    this.board = board;
  }
  
  public Client getClient() {
    return client;
  }
}
