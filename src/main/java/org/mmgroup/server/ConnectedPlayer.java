package org.mmgroup.server;

import java.io.*;
import java.net.Socket;
/*
 * ConnectedPlayer czyta wiadomości wysłane przez klienta dla którego został utworzony ten obiekt/thread
 * Można również wysylac wiadomosci do klienta przez metode send message
 */
public class ConnectedPlayer implements Runnable{
  String playerName = "DEFAULT";
  Socket socket;
  PrintWriter writer;
  Server server;
  
  public ConnectedPlayer(Socket socket,Server server) {
    this.socket = socket;
    this.server = server;
  }
  
  public String getPlayerName() {
    return playerName;
  }
  
  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  @Override
  public void run() {
    try {
      InputStream input = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));
      
      OutputStream output = socket.getOutputStream();
      writer = new PrintWriter(output, true);
      
      String clientMessage;
      do {
          System.out.println("SERVER: Czekanie na wiadomosc");
          clientMessage = reader.readLine();
          //serverMessage = clientMessage;
          ServerCommander.instance.handleMessage(this, clientMessage);
          //server.broadcast(serverMessage, this);
  
      } while (!clientMessage.equals("bye"));
    }catch(Exception ex) {}
    
  }
  
  public void sendMessage(String message) {
    writer.println(message);
  }
}
