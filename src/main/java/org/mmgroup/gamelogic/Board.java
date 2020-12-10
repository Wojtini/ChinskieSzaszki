package org.mmgroup.gamelogic;

public class Board {
  Field Grid[][];
  int width;
  int height;
  
  public Board(int height, int width) {
    this.height = height;
    this.width = width;
    Grid = new Field[height][width];
    for(int i=0;i<height;i++) {
      for(int j=0;j<width;j++) {
        Grid[i][j]=new Field();
      }
    }
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
