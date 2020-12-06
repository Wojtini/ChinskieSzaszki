package org.mmgroup.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client implements Runnable{
  Socket socket;
  PrintWriter writer;
  
  public void Connect(String ipAddress,int port){
    try {
      socket = new Socket(ipAddress, port);
      System.out.println("CLIENT: Połączono");
      new ClientCommander();
      System.out.println("CLIENT: ClientCommander stworzony");
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
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
          clientMessage = reader.readLine();
          //System.out.println(this + ": Dostano wiadomosc " + clientMessage);
          ClientCommander.instance.handleMessage(this,clientMessage);
      } while (!clientMessage.equals("bye"));
    }catch(Exception ex) {}
  }
  
  public void sendMessage(String message) {
    writer.println(message);
  }
}
