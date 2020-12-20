package org.mmgroup.servertest;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.mmgroup.client.Client;
import org.mmgroup.gamelogic.Board;
import org.mmgroup.gamelogic.Game;
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
    
    Game g1 = new Game("localhost",port); //Tworzenie gry z połączeniem na adres:port
    Game g2 = new Game("localhost",port);
    
    Wait(1);
    
    assertTrue(server.getNumberOfPlayers()==2);
    
    g1.getClient().sendMessage("changeNick;Wojtini");
    g2.getClient().sendMessage("changeNick;Hehehe");
    
    Wait(1);
    
    String name1 = server.getAllPlayers().get(0).getPlayerName();
    String name2 = server.getAllPlayers().get(1).getPlayerName();
    
    assertTrue(name1.equals("Wojtini"));
    assertTrue(name2.equals("Hehehe"));
  }
  /*
   * Test do zmian
   */
//  @Test
  public void movingPawnsUsingServer() throws UnknownHostException, IOException
  {
    
    int port = 6666;
    Server server = new Server(port);
    server.setNumberOfPlayers(2);
    Thread serverThread = new Thread(server);
    serverThread.start();
    
    Game g1 = new Game("localhost",port); //Tworzenie gry z połączeniem na adres:port
    Game g2 = new Game("localhost",port);
    
    Wait(1);
    /*
     * częśc do zmiany bo teraz 14-12-2020 na (1,1) jest pionek
     */
    assertTrue(g1.getBoard().getPawn(1, 1)!=null);
    /*
     * Nie powinno zadziałac bo to nie jest tura g2 (gracza o id 1)
     */
    g2.getClient().sendMessage("movePawn;1;1;4;4");
    Wait(1);
    g1.getClient().sendMessage("movePawn;1;1;2;2");

    Wait(1);
//    assertTrue(g1.getBoard().getPawn(1, 1)==null);
//    assertTrue(g1.getBoard().getPawn(2, 2)!=null);
//    assertTrue(g2.getBoard().getPawn(1, 1)==null);
//    assertTrue(g2.getBoard().getPawn(2, 2)!=null);
    
  }
//  @Test
  public void turnsTest() throws UnknownHostException, IOException
  {
    int tura = -1;
    int port = 7777;
    Server server = new Server(port);
    server.setNumberOfPlayers(3);
    Thread serverThread = new Thread(server);
    serverThread.start();
    
    Game g1 = new Game("localhost",port); //Tworzenie gry z połączeniem na adres:port
    Game g2 = new Game("localhost",port);
    Game g3 = new Game("localhost",port);
    
    Wait(2);
   
    assertTrue(g1.getClient().isMyTurn());
    assertTrue(!g2.getClient().isMyTurn());
    assertTrue(!g3.getClient().isMyTurn());
    tura = 0;
    assertTrue(g1.getClient().getCurrentPlayersTurnId()==tura);
    assertTrue(g2.getClient().getCurrentPlayersTurnId()==tura);
    assertTrue(g3.getClient().getCurrentPlayersTurnId()==tura);
    
    g1.getClient().sendMessage("endTurn");

    Wait(2);
    
    assertTrue(!g1.getClient().isMyTurn());
    assertTrue(g2.getClient().isMyTurn());
    assertTrue(!g3.getClient().isMyTurn());
    tura = 1;
    assertTrue(g1.getClient().getCurrentPlayersTurnId()==tura);
    assertTrue(g2.getClient().getCurrentPlayersTurnId()==tura);
    assertTrue(g3.getClient().getCurrentPlayersTurnId()==tura);
    
    g2.getClient().sendMessage("endTurn");

    Wait(2);
    
    assertTrue(!g1.getClient().isMyTurn());
    assertTrue(!g2.getClient().isMyTurn());
    assertTrue(g3.getClient().isMyTurn());
    tura = 2;
    assertTrue(g1.getClient().getCurrentPlayersTurnId()==tura);
    assertTrue(g2.getClient().getCurrentPlayersTurnId()==tura);
    assertTrue(g3.getClient().getCurrentPlayersTurnId()==tura);
    
    g3.getClient().sendMessage("endTurn");

    Wait(2);
    
    assertTrue(g1.getClient().isMyTurn());
    assertTrue(!g2.getClient().isMyTurn());
    assertTrue(!g3.getClient().isMyTurn());
    tura = 0;
    assertTrue(g1.getClient().getCurrentPlayersTurnId()==tura);
    assertTrue(g2.getClient().getCurrentPlayersTurnId()==tura);
    assertTrue(g3.getClient().getCurrentPlayersTurnId()==tura);
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
