package org.mmgroup.server;
/*
 * Klasa interpretująca wiadomości wysłane przez klientów
 */
public class ServerCommander {
  public static ServerCommander instance;
  
  /*
   * Singleton, commander bedzie tylko jeden oraz powinien byc dostepny dla kazdego obiektu tj. Server i ConnectedPlayer.
   */
  public ServerCommander() {
    ServerCommander.instance = this;
  }
  /*
   * connectedPlayer - gracz ktory wyslal wiadomosc
   * message - tresc wiadomosci
   * Schemat wiadomosci:
   * KOMENDA=ARGS[0];ARG1;ARG2;ARG3;...;ARGn; - wywoluje komende przy podanych argumentach.(Patrz pierwszy przyklad)
   */
  public void handleMessage(ConnectedPlayer connectedPlayer,String message) {
    System.out.println("SERVER: Dostano wiadomosc '" + message + "' od " + connectedPlayer);
    String[] args = message.split(";");
    switch(args[0]) {
    case "changeNick":
      connectedPlayer.setPlayerName(args[1]);
      break;
    case "printToConsole":
      System.out.println(args[1]);
      break;
    }
  }
}
