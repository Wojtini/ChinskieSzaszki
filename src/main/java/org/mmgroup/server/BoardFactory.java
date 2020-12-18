package org.mmgroup.server;

import org.mmgroup.gamelogic.Board;

public interface BoardFactory {
  public Board buildBoard(int numberOfPlayers);
}
