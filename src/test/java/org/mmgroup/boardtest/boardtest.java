package org.mmgroup.boardtest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mmgroup.gamelogic.Board;

public class boardtest {
  @Test
  public void BasicTest() {
    Board board = new Board(20,40);
    board.insertPawn(10, 10, 1);
    assertTrue(board.getPawn(10,10)!=null);
    board.movePawn(10, 10, 15, 15);
    
    assertTrue(board.getPawn(10,10)==null);
    assertTrue(board.getPawn(15,15)!=null);
    
    board.removePawn(15, 15);
    assertTrue(board.getPawn(15,15)==null);
  }

}
