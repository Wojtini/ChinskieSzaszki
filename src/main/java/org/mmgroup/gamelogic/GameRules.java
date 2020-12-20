package org.mmgroup.gamelogic;

import java.util.ArrayList;

public class GameRules {
  ArrayList<Move> availableMoves = new ArrayList<Move>();
  
  public void addMoveRuleOption(Move move) {
    availableMoves.add(move);
  }
  
  public ArrayList<Vector2> getAvailableMovesForPos(Board board, int x, int y){
    ArrayList<Vector2> outcome = new ArrayList<Vector2>();
    for(Move option: availableMoves) {
      ArrayList<Vector2> test = option.generateMoves(board, x, y, null);
      for(Vector2 pom: test) {
        outcome.add(pom);
      }
    }
    return outcome;
  }
}
