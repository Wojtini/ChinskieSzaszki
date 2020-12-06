package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    protected String readNick;
    protected String port;
    JButton portButton = new JButton("Zatwierdz port");
    JButton nickButton = new JButton("Zatwierdz nick");
    JButton serwerButton = new JButton("Stwórz serwer");
    JPanel panel = new JPanel();
    JTextField nickArea = new JTextField("Tutaj wprowadź nick",20);
    JTextField portArea = new JTextField("Tutaj wprowadz port",20);
    JTextField IParea = new JTextField("Podaj adres IP",20);
    public MainMenu(){
        this.add(panel);
        this.setBounds(50,30,300,200);
        setVisible(true);
        setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.add(nickArea);
        panel.add(nickButton);
        panel.add(portArea);
        panel.add(portButton);
        panel.add(IParea);
        panel.add(serwerButton);

        portButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                port=portArea.getText();
                System.out.println(port);
                portArea.setText("Tutaj wprowadź port");
            }
        });
        nickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readNick = nickArea.getText();
                System.out.println(readNick);
                nickArea.setText("Tutaj wprowadź nick");
            }
        });
        serwerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });


    }

}
