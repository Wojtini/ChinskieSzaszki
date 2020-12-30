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
    JButton continueButton = new JButton("Continue");
    public FinalWindow(String s){
        this.winnerNameLabel.setText(s);
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
        //exitButton.setBackground(Color.LIGHT_GRAY);
        //panel.add(exitButton);
        continueButton.setBackground(Color.LIGHT_GRAY);
        panel.add(continueButton);
        this.setVisible(true);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //Koniec gry
            }
        });
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               setVisible(false);
            }
        });
    }

}