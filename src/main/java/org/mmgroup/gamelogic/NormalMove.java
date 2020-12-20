package org.mmgroup.gamelogic;

import java.util.ArrayList;

public class NormalMove extends Move{
  
  public NormalMove() {
    super();
  }
  
  @Override
  public ArrayList<Vector2> generateMoves(Board board,int pawnPosX,int pawnPosY,ArrayList<Vector2> possibleMoves) {
    if(possibleMoves==null) {
      possibleMoves = new ArrayList<Vector2>();
    }
    for(Vector2 dir: directions) {
      int currX = pawnPosX + dir.x;
      int currY = pawnPosY + dir.y;
      if(currX < board.getWidth() && currY < board.getHeight() && board.getPawn(currX, currY)==null && currX >= 0 && currY >= 0) {
        if(board.Grid[currX][currY].getActive()) {
          possibleMoves.add(new Vector2(currX,currY));
        }
      }
    }
    return possibleMoves;
  }
}
