package org.mmgroup.boardfactory;

import org.mmgroup.gamelogic.Board;

public interface BoardFactory {
  public Board buildBoard();
  public int[][] getWinCondition();
}
