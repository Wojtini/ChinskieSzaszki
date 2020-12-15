package org.mmgroup.UI;

import org.mmgroup.gamelogic.Board;
import org.mmgroup.gamelogic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    Game game = new Game();
    Board b = game.getBoard();
    int xPole;
    int yPole;
    public GamePanel(){
        b.insertPawn(1,1,7);
        this.setVisible(true);
        this.setSize(new Dimension(b.getWidth(),b.getHeight()));
        for(int i=0; i < b.getWidth(); i++)
            for(int j=0; j < b.getHeight();j++){
                b.Grid[i][j].getEllipse();
            }
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Point p = e.getPoint();
                for(int i = 0; i < b.getWidth(); i++)
                    for (int j = 0; j < b.getHeight(); j++)
                        if(b.Grid[i][j].getEllipse().contains(p)){
                            // i,j to wspolrzedne pola, na ktore przesuwamy pionek
                            xPole = i;
                            yPole = j;
                        }
            }
        });
    }
    //moze sie przydadzą
    public int getxPola(){
        return xPole;
    }
    public int getyPola(){
        return yPole;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for(int i = 0; i < b.getWidth(); i++){
            for(int j = 0; j < b.getHeight(); j++){
                if(b.Grid[i][j].getActive()){
                    if(b.Grid[i][j].getPawn()!=null){
                        g2d.setColor(b.Grid[i][j].getPawn().getColor());
                    }
                    else
                    {
                        g2d.setColor(Color.LIGHT_GRAY);
                    }
                    g2d.fill(b.Grid[i][j].getEllipse());
                }
            }
        }
    }
}
