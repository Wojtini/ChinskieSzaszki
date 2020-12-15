package org.mmgroup.UI;

import javax.swing.*;

import org.mmgroup.client.Client;
import org.mmgroup.gamelogic.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    GamePanel panel;
    Client client;
    JButton button = new JButton("Zakończ ture");
    JMenuBar bar = new JMenuBar();
    JLabel label = new JLabel("Informacja o turze");
    public GUI(Game game,Client client){
        this.panel = new GamePanel(game);
        this.client = client;
        bar.setLayout(new GridLayout(1,2));
        this.setJMenuBar(bar);
        bar.add(label);
        bar.add(button);
        this.setVisible(true);
        this.setSize(new Dimension(800,850));
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              endTurnPressed();
            }
        });
    }
    public void endTurnPressed() {
      Game game = this.panel.game;
      game.currentPosPawnY = -1;
      game.currentPosPawnX = -1;
      game.canSelectNewPawn = true;
      game.getGui().repaintBoard();
      this.client.sendMessage("endTurn");
    }
    //może sie przyda
    public void setKomunikat(String komunikat){
        this.label.setText(komunikat);
    }
    public void repaintBoard() {
      this.panel.repaint();
    }
}
