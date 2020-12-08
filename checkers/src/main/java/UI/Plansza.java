package UI;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class Plansza extends JPanel implements ActionListener {
    Pole[][] plansza = new Pole[70][70];
    Pionek[][] pionki = new Pionek[20][20];
    //GridLayout layout = new GridLayout(70,70);
    //Point pionekZaznaczony;
    Point nowaPozycja;
    Color kolorGracza;
    int click =0;

    public Plansza() {
        //this.setLayout(layout);
        this.setVisible(true);
        this.setSize(500, 500);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                pionki[i][j] = new Pionek(i,j);
            }
        }

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                    nowaPozycja=e.getPoint();
                for(int i=0; i < 20;i++){
                    for(int j=0;j<20;j++){
                        if(pionki[i][j].getElipsa().contains(nowaPozycja)){
                            kolorGracza = Color.yellow; //domyslny
                            pionki[i][j].setColor(kolorGracza);
                            repaint();
                        }
                    }
                }
            }
          /*  @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                pionekZaznaczony = e.getPoint();
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 20; j++) {
                        if (pionki[i][j].getElipsa().contains(pionekZaznaczony) && pionki[i][j].getPionekStatus() == true) {
                            kolorGracza = Color.yellow;
                        }

                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                nowaPozycja = e.getPoint();
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 20; j++) {
                        if (pionki[i][j].getElipsa().contains(nowaPozycja)) {
                            pionki[i][j].setColor(kolorGracza);
                            repaint();
                        }
                    }
                }

            } */
        });

    }
        @Override
        public void paintComponent (Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (int i = 0; i < 20; i++)
                for (int j = 0; j < 20; j++) {
                    //el = new Ellipse2D.Float(pionki[i][j].getX(),pionki[i][j].getY(),20,20);
                    g2d.setColor(pionki[i][j].getColor());
                    g2d.fill(pionki[i][j].getElipsa());
                }
        }

}
