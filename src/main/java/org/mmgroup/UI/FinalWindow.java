package org.mmgroup.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalWindow extends JFrame {
    JPanel panel = new JPanel();
    JLabel winnerLabel = new JLabel("Zwycięzcą zostaje");
    JButton OkButton = new JButton("OK");
    JButton newGameButton = new JButton("Nowa gra");
    public FinalWindow(){
        this.add(panel);
        this.setSize(400,400);
        this.setLayout(new GridLayout(3,1));
        this.add(winnerLabel,BorderLayout.CENTER);
        this.add(OkButton);
        this.add(newGameButton);
        this.setVisible(true);
        OkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Koniec gry
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //nowa gra
            }
        });
    }
    public void setWinnerLabelText(String s){
        this.winnerLabel.setText(s);
    }

}