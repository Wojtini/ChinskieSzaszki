package org.mmgroup.gamelogic;

import javax.swing.*;
import java.awt.*;

public class Board{
  public static Field[][] Grid;
  int width;
  int height;
  
  public Board(int height, int width) {
    this.height = height;
    this.width = width;
    Grid = new Field[height][width];
    for(int i=0; i < width;i++){
        for(int j=0; j < height;j++)
            Grid[i][j]=new Field();
    }
    }
    public int getWidth(){
      return width-1;
    }
    public int getHeight(){
      return height-1;
    }
 public boolean insertPawn(int x,int y,int playerId) {
    if(Grid[x][y].isOccupied()) {
      return false;
    }
    Grid[x][y].setPawn(new Pawn(playerId));
    return true;
  }
  public boolean movePawn(int fromX,int fromY,int toX,int toY) {
    if(!Grid[fromX][fromY].isOccupied() || Grid[toX][toY].isOccupied())
      return false;
    Pawn pawn = Grid[fromX][fromY].getPawn();
    Grid[fromX][fromY].removePawn();
    Grid[toX][toY].setPawn(pawn);
    return true;
  }
  public Pawn getPawn(int x,int y) {
    return Grid[x][y].getPawn();
  }
  
  public void removePawn(int x,int y) {
    Grid[x][y].removePawn();
  }
}
