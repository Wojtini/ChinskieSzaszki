package org.mmgroup.client;


public class ClientCommander {
  public static ClientCommander instance;
  
  public ClientCommander() {
    ClientCommander.instance = this;
  }

  public void handleMessage(Client client,String message) {
    System.out.println("CLIENT: Dostano wiadomosc od Server");
    String[] args = message.split(";");
    switch(args[0]) {
    case "printToConsole":
      System.out.println(client + ": server rozkazał printa: " + args[1]);
      break;
    }
  }
}
