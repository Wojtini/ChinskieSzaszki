package org.mmgroup.gamelogic;

public class Game {
  Board board = new Board(10,10);
  
  public Board getBoard() {
    return board;
  }
  
  public void setBoard(Board board) {
    this.board = board;
  }
}
