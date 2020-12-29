package org.mmgroup.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/** This is a final window, it contains information about winner and allows to choose - new game or
 * exit
 * */

public class FinalWindow extends JFrame {
    JPanel panel = new JPanel();
    JLabel summaryLabel = new JLabel("            THE END        ");
    JLabel winnerLabel = new JLabel("The winner is:    ");
    JLabel winnerNameLabel = new JLabel("Player X");
    JButton exitButton = new JButton("Exit");
    JButton newGameButton = new JButton("New game");
    public FinalWindow(){
        this.setLocationRelativeTo(this);
        this.add(panel);
        panel.setBackground(Color.orange);
        this.setSize(400,300);
        //panel.setLayout(new GridLayout(4,1));
        summaryLabel.setFont(new Font("Summ",Font.BOLD,40));
        panel.add(summaryLabel);
        winnerLabel.setFont(new Font("Summ",Font.BOLD,20));
        panel.add(winnerLabel, BorderLayout.CENTER);
        winnerNameLabel.setFont(new Font("Summ",Font.BOLD,30));
        panel.add(winnerNameLabel);
        exitButton.setBackground(Color.LIGHT_GRAY);
        panel.add(exitButton);
        newGameButton.setBackground(Color.LIGHT_GRAY);
        panel.add(newGameButton);
        this.setVisible(true);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //Koniec gry
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //nowa gra
                dispose();
                new StartMenu();
            }
        });
    }
    /**
     * winner setting
     * */
    public void setWinnerLabelText(String s){

        // ustawiamy imie gracza
        this.winnerNameLabel.setText(s);
    }

}