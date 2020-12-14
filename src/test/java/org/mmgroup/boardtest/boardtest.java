package org.mmgroup.boardtest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mmgroup.gamelogic.Board;

public class boardtest {
  @Test
  public void BasicTest() {
    Board board = new Board(10,20);
    board.insertPawn(9, 15, 1);
    board.insertPawn(8, 14, 1);
    
    assertTrue(!board.movePawn(8, 14, 9, 15));
    assertTrue(board.getPawn(8,14)!=null);
    
    assertTrue(board.getPawn(9,15)!=null);
    board.movePawn(9, 15, 1, 2);
    
    assertTrue(board.getPawn(9,15)==null);
    assertTrue(board.getPawn(1,2)!=null);
    
    board.removePawn(1, 1);
    assertTrue(board.getPawn(1,1)==null);
  }
}
