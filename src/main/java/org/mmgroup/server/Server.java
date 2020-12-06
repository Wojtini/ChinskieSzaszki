package org.mmgroup.server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
/*
 * 
 * 
 */
public class Server implements Runnable {
  ServerSocket serverSocket;
  int port = 30120;
  int numberOfPlayers = 2;
  
  List<ConnectedPlayer> connectedPlayers = new ArrayList<ConnectedPlayer>();
  List<Thread> connectedPlayersThreads = new ArrayList<Thread>();
  
  public Server(int port) {
    this.port = port;
  }
  
  public void setNumberOfPlayers(int numberOfPlayers) {
    this.numberOfPlayers = numberOfPlayers;
  }
  
  public List<ConnectedPlayer> getAllPlayers() {
    return connectedPlayers;
  }
  
  public int getNumberOfPlayers() {
    return connectedPlayers.size();
  }
  
  @Override
  public void run() {
    try {
      System.out.println("SERVER: Creating commander: ");
      new ServerCommander();
      System.out.println("SERVER: Creating commander SUCCESS: ");
      System.out.println("SERVER: Trying to host on port: " + port);
      serverSocket = new ServerSocket(port);
      System.out.println("SERVER: Hosted: ");
      //Dodaje graczy i tworzy dla nich connectedPlayers;
      for(int i=0;i<numberOfPlayers;i++) {
        System.out.println("SERVER: Czekanie na gracza...");
        Socket socket = serverSocket.accept();
        System.out.println("SERVER: Gracz polaczony...");
        ConnectedPlayer cp = new ConnectedPlayer(socket,this);
        connectedPlayers.add(cp);
        Thread t = new Thread(cp);
        t.start();
        connectedPlayersThreads.add(t);
        
        System.out.println("SERVER: Dolaczyl gracz. Do rozpoczecia rozgrywki potrzeba jeszcze: " + (numberOfPlayers-getNumberOfPlayers()));
      }
      System.out.println("SERVER: Startowanie rozgrywki");
      // Rozgrywka
    }catch(Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
  /*
   * Wysyla message dla kazdego polaczonego klienta
   */
  public void broadcast(String message) {
    for(ConnectedPlayer player: connectedPlayers) {
      player.sendMessage(message);
    }
  }
}
