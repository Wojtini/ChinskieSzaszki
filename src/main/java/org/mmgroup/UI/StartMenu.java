package org.mmgroup.UI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A class which is a start menu - player connects with server and starts game
 * */

public class StartMenu extends JFrame {
    JPanel panel = new JPanel();
    JLabel startGame = new JLabel(" START GAME ");

    JButton connectButton = new JButton("   CONNECT     ");
    JButton exitButton = new JButton("   exit     ");
    JTextField getPortField = new JTextField("Write the port number");
    String[] playerOptions = {"  How many players?  ","2 players", "3 players", "4 players", "6 players" };
    JComboBox<String> playerBox = new JComboBox<String>(playerOptions);

    JMenu menu = new JMenu();
    JCheckBox ruch = new JCheckBox("    Move");
    JCheckBox skok = new JCheckBox("    Jump");

    boolean zaznaczonyRuch = false;
    boolean zaznaczonySkok = false;

    int fontSize=25;
    int numberOfPlayers;

    public StartMenu(){
        this.add(panel);
        panel.setBackground(Color.orange);
        panel.setLayout(new FlowLayout());

        this.setBounds(550,250,270,400);
        setVisible(true);
        setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.add(startGame);
        startGame.setHorizontalTextPosition(10);
        startGame.setSize(40,60);
        startGame.setFont(new Font("Helvetica",Font.BOLD,fontSize));

        panel.add(getPortField);
        getPortField.setFont(new Font("Helvetica",Font.PLAIN,14));
        connectButton.setSize(40,10);

        panel.add(playerBox);
        playerBox.setFont(new Font("Helvetica",Font.PLAIN,17));

        panel.add(skok);
        skok.setBackground(Color.orange);
        skok.setFont(new Font("Helvetica",Font.BOLD,15));

        panel.add(ruch);
        ruch.setBackground(Color.orange);
        ruch.setFont(new Font("Helvetica",Font.BOLD,15));

        panel.add(connectButton);
        connectButton.setFont(new Font("Helvetica",Font.BOLD,17));
        connectButton.setBackground(Color.lightGray);
        connectButton.setForeground(Color.BLUE);

        panel.add(exitButton);
        exitButton.setBackground(Color.lightGray);

        getPortField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                getPortField.setText(""); //czyscimy pole, by mozna było wpisac nr portu
            }
        });
        ruch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // zaznaczenie opcji ruchu
                zaznaczonyRuch=true;
            }
        });
        skok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // zaznaczenie opcji skoku
                zaznaczonySkok=true;
            }
        });

         //liczba graczy
        playerBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerBox.getSelectedItem()=="2 players"){
                    setNumberOfPlayers(2);
                }
                else if(playerBox.getSelectedItem()=="3 players"){
                    setNumberOfPlayers(3);
                }
                else if(playerBox.getSelectedItem()=="4 players"){
                    setNumberOfPlayers(4);
                }
                else if(playerBox.getSelectedItem()=="6 players"){
                    setNumberOfPlayers(6);
                }
            }
        });
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // try .. łaczenie sie z serwerem i tworzenie gry z wybrana iloscia graczy (getNumberOfPlayers)
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //wychodzimy z gry
            }
        });
    }

    public void setNumberOfPlayers(int number){
        this.numberOfPlayers=number;
    }
    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }

}
