package org.mmgroup.UI;

import org.mmgroup.gamelogic.Board;
import org.mmgroup.gamelogic.Game;
import org.mmgroup.gamelogic.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    Game game = new Game();
    Board b = game.getBoard();
    public GamePanel(){
        this.setVisible(true);
        this.setSize(new Dimension(b.getWidth(),b.getHeight()));
        for(int i=0; i < b.getWidth(); i++)
            for(int j=0; j < b.getHeight();j++){
               b.Grid[i][j].setPawn(new Pawn(1));
            }
        for(int i=0; i < b.getWidth(); i++)
            for(int j=0; j < b.getHeight();j++){
                b.Grid[i][j].getPawn().setElipsa(i,j);
            }
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Point p = e.getPoint();
                for(int i = 0; i < b.getWidth(); i++)
                    for (int j = 0; j < b.getHeight(); j++)
                        if(b.Grid[i][j].getPawn().getElipsa().contains(p)){
                            // teraz trzeba przesunac pionek na zaznaczone pole - game.getBoard().movePawn()
                            // i zrobic repaint()
                            b.Grid[i][j].getPawn().setColor(Color.YELLOW);
                            repaint();

                        }

            }
        });
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < b.getWidth(); i++){
            for(int j = 0; j < b.getHeight(); j++){
                g2d.setColor(b.Grid[i][j].getPawn().getColor());
                g2d.fill(b.Grid[i][j].getPawn().getElipsa());
            }
        }

    }
}
