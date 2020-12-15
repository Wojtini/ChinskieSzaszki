package org.mmgroup.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    GamePanel panel = new GamePanel();
    JButton button = new JButton("Zakończ ture");
    JMenuBar bar = new JMenuBar();
    JLabel label = new JLabel("Informacja o turze");
    public GUI(){
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
                //konczymy ture
            }
        });
    }
    //może sie przyda
    public void setKomunikat(String komunikat){
        this.label.setText(komunikat);
    }

}
