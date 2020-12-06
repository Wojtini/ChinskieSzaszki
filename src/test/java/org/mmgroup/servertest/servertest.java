package org.mmgroup.servertest;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.mmgroup.client.Client;
import org.mmgroup.server.Server;


public class servertest {
  @Test
  public void basicMethods() throws UnknownHostException, IOException
  {
    int port = 5555;
    Server server = new Server(port);
    server.setNumberOfPlayers(2);
    Thread serverThread = new Thread(server);
    serverThread.start();
    
    Client client1 = new Client();
    client1.Connect("localhost", port);
    Thread c1 = new Thread(client1);
    c1.start();
    
    Client client2 = new Client();
    client2.Connect("localhost", port);
    Thread c2 = new Thread(client2);
    c2.start();

    Wait(1);
    
    client1.sendMessage("changeNick;Wojtini");
    client2.sendMessage("changeNick;Hehehe");
    
    Wait(1);
    
    server.broadcast("printToConsole;Test broadcastu");
    String name1 = server.getAllPlayers().get(0).getPlayerName();
    String name2 = server.getAllPlayers().get(1).getPlayerName();
    
    //Poprawne rejestrowanie graczy
    assertTrue(server.getNumberOfPlayers()==2);
    
    //Sprawdzenie zmiany nicków
    assertTrue(name1.equals("Wojtini"));
    assertTrue(name2.equals("Hehehe"));
  }
  
  /*
   * Aby upewnic sie ze serwer (Thread) zdazyl przetworzyc dane
   */
  public void Wait(int sec) {
    try {
      TimeUnit.SECONDS.sleep(sec);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
