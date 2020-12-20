package org.mmgroup.gamelogic;

import java.util.ArrayList;

public class JumpMove extends Move {
  public JumpMove() {
    super();
  }
  
  @Override
  public ArrayList<Vector2> generateMoves(Board board,int pawnPosX,int pawnPosY,ArrayList<Vector2> possibleMoves) {
    if(possibleMoves==null) {
      possibleMoves = new ArrayList<Vector2>();
    }
    for(Vector2 dir: directions) {
      int currX = pawnPosX;
      int currY = pawnPosY;
      
      boolean end = false;
      int i = 1;
      while (!end) {
        currX = pawnPosX + dir.x * i;
        currY = pawnPosY + dir.y * i;
        //System.out.println("Sprawdzanie "+currX+" "+currY);
        /*
         * Sprawdzanie czy nie wyszlo poza tablice
         */
        if(currX > board.getWidth() || currY > board.getHeight() || currX < 0 || currY < 0) {
          //System.out.println("Koniec "+currX+" "+currY);
          end = true;
          break;
        }
        int curr2X = pawnPosX + dir.x * i * 2;
        int curr2Y = pawnPosY + dir.y * i * 2;
        if(curr2X > board.getWidth() || curr2Y > board.getHeight() || curr2X < 0 || curr2Y < 0) {
          end = true;
          break;
        }
        /*
         * Sprawdzanie mozliwosci skoku
         */
        if(board.getPawn(currX, currY)!=null && board.getPawn(curr2X, curr2Y)==null) {
          if(board.Grid[curr2X][curr2Y].getActive()) {
            possibleMoves.add(new Vector2(pawnPosX + dir.x * i * 2, pawnPosY + dir.y * i * 2));
          }
        }
        i+=1;
      }
    }
    return possibleMoves;
  }
}
