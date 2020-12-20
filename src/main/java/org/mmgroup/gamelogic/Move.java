package org.mmgroup.gamelogic;

import java.util.ArrayList;

public class Move {
  
  protected ArrayList<Vector2> directions = new ArrayList<Vector2>();
  
  public Move() {
    directions.add(new Vector2(-1,-1));
    directions.add(new Vector2(-1,0));
    directions.add(new Vector2(0,1));
    directions.add(new Vector2(1,0));
    directions.add(new Vector2(1,-1));
    directions.add(new Vector2(0,-1));
  }
  
  public ArrayList<Vector2> generateMoves(Board board,int pawnPosX,int pawnPosY,ArrayList<Vector2> possibleMoves) {
    if(possibleMoves==null) {
      possibleMoves = new ArrayList<Vector2>();
    }
    return possibleMoves;
  }
}
