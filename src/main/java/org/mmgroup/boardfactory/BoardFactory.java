package org.mmgroup.boardfactory;

import org.mmgroup.gamelogic.Board;

/**
 * Factory interface to build boards
 * @author Wojciech.Maziarz
 *
 */
public interface BoardFactory {
  public Board buildBoard();
  public int[][] getWinCondition();
}
