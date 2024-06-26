package org.mmgroup.UI;

import javax.swing.*;

import org.mmgroup.gamelogic.Game;
import org.mmgroup.server.Server;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    protected String readNick;
    protected String port;
    JButton connectButton = new JButton("Polacz");
    JButton serwerButton = new JButton("Stwórz serwer");
    JPanel panel = new JPanel();
    JTextField nickArea = new JTextField("Tutaj wprowadź nick(not implemented)",20);
    JTextField portArea = new JTextField("6666",20);
    JTextField IParea = new JTextField("localhost",20);
    public MainMenu(){
        this.add(panel);
        this.setBounds(50,30,300,200);
        setVisible(true);
        setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.add(IParea);
        panel.add(portArea);
        panel.add(connectButton);
        panel.add(serwerButton);
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                  int port = Integer.parseInt(portArea.getText());
                  new Game(IParea.getText(),port);
                }catch(Exception ex) {
                  System.out.println("Client: Blad polaczenia");
                }
            }
        });
        serwerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //setVisible(false);
              new StartMenu();
            }
        });


    }

}
