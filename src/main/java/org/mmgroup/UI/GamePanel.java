package org.mmgroup.UI;

import org.mmgroup.gamelogic.Board;
import org.mmgroup.gamelogic.Game;
import org.mmgroup.gamelogic.PlayerColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    Game game;
    Board b;
    int xPole;
    int yPole;
    UserInputInterpreter inputInterpreter;
    public GamePanel(Game game){
        this.game = game;
        this.b = game.getBoard();
        inputInterpreter = new UserInputInterpreter(game);
        System.out.println(b);
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
                            // i,j to wspolrzedne pola
                            //xPole = i;
                            //yPole = j;
                          clickedField(i,j);
                        }
            }
        });
    }
    //moze sie przydadzą
    public void clickedField(int x,int y) {
      inputInterpreter.handleClick(x,y);
      repaint();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < b.getWidth(); i++){
            for(int j = 0; j < b.getHeight(); j++){
                if(b.Grid[i][j].getActive()){
                    if(b.Grid[i][j].getPawn()!=null){
                        int x = game.currentPosPawnX;
                        int y = game.currentPosPawnY;
                        if(x==i && y==j) {
                          g2d.setColor(Color.BLACK);
                        }else {
                          Color color = PlayerColors.instance.getPlayerColor(b.Grid[i][j].getPawn().getOwnerId());
                          g2d.setColor(color);
                        }
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
