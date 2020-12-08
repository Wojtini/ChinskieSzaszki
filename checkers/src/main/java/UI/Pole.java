package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pole extends JPanel {
    private Pionek pionek;
    boolean czyJestPionek = false;
    public Pole(int i, int j){
        pionek = new Pionek(i,j);
        this.setSize(20,20);
        this.setBackground(Color.white);
        //repaint();
    }
    public void setCzyJestPionek(boolean status){
        this.czyJestPionek = status;
    }
    public boolean getCzyJestPionek(){
        return czyJestPionek;
    }
    public Pionek getPionek(){
        return pionek;
    }
    public void zmienKolorPionka(Color color){
        pionek.setColor(color);
        repaint();
    }
   /* public void rysujPionek(Graphics g){
        Graphics2D circle = (Graphics2D) g;
        circle = new Ellipse2D(pionek.getX(),pionek.getY());
        circle.setColor(pionek.getColor());
    } */

    /*@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        Ellipse2D el = new Ellipse2D.Float(0,0,this.getWidth(),this.getHeight());
        g2d.setColor(pionek.getColor());
        g2d.fill(el);
        } */
    }


