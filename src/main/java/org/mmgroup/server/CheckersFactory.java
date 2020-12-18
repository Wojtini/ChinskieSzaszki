package org.mmgroup.server;

import org.mmgroup.gamelogic.Board;

public class CheckersFactory implements BoardFactory {

  @Override
  public Board buildBoard(int numberOfPlayers) {
    if(numberOfPlayers==2) {
      return twoPlayerGame();
    }
    return null;
  }
  /*
   * Grid
   * n=0 - field inactive
   * n=1 - field active
   * n>2 - field contains pawn with id n-2
   */
  int[][] twoGrid = {
      {0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0},
       {0,0,0,0,0,0,0,2,2,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0},
       {0,0,0,0,0,0,2,2,2,2,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0},
       {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
      {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
       {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
      {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
       {0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
      {0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
       {0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
      {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
       {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
      {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
       {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
      {0,0,0,0,0,0,3,3,3,3,3,0,0,0,0,0,0},
       {0,0,0,0,0,0,3,3,3,3,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,3,3,3,0,0,0,0,0,0,0},
       {0,0,0,0,0,0,0,3,3,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0},
  };
  
  public Board twoPlayerGame() {
    Board board = new Board(17,21);
    for(int i=0;i<twoGrid.length;i++) {
      for(int j=0;j<twoGrid[i].length;j++) {
          int number = twoGrid[i][j];
          if(number == 0) {
            board.Grid[j][i].setActive(false);
          }else if(number == 1) {
            board.Grid[j][i].setActive(true);
          }else {
            board.insertPawn(j, i, number-2);
          }
      }
    }
    return board;
  }
  
}
