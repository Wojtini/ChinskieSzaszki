package org.mmgroup.gamelogic;

import java.util.ArrayList;

public class Move {
  
  protected ArrayList<Vector2> directionsEven = new ArrayList<Vector2>();
  protected ArrayList<Vector2> directionsOdd = new ArrayList<Vector2>();
  
  
  //jest na odwrót niż normalnie
  //dodatkowo ruchy roznia sie w zaleznosci od pozycji (parzyste lub nieparzyste)
  //parowanie
  public Move() {
    directionsEven.add(new Vector2(-1,-1));
    directionsOdd.add(new Vector2(0,-1));
//  directionsEven.add(new Vector2(0,0));
//  directionsOdd.add(new Vector2(0,0));
    
    directionsEven.add(new Vector2(-1,0));
    directionsOdd.add(new Vector2(-1,0));
//  directionsEven.add(new Vector2(0,0));
//  directionsOdd.add(new Vector2(0,0));
    
    directionsEven.add(new Vector2(0,1));
    directionsOdd.add(new Vector2(1,1));
//  directionsEven.add(new Vector2(0,0));
//  directionsOdd.add(new Vector2(0,0));
    
    directionsEven.add(new Vector2(1,0));
    directionsOdd.add(new Vector2(1,0));
//  directionsEven.add(new Vector2(0,0));
//  directionsOdd.add(new Vector2(0,0));
    
    directionsEven.add(new Vector2(-1,1));
    directionsOdd.add(new Vector2(0,1));
//  directionsEven.add(new Vector2(0,0));
//  directionsOdd.add(new Vector2(0,0));
    
    directionsEven.add(new Vector2(0,-1));
    directionsOdd.add(new Vector2(1,-1));
//  directionsEven.add(new Vector2(0,0));
//  directionsOdd.add(new Vector2(0,0));
  }
  
  public ArrayList<Vector2> generateMoves(Board board,int pawnPosX,int pawnPosY,ArrayList<Vector2> possibleMoves) {
    if(possibleMoves==null) {
      possibleMoves = new ArrayList<Vector2>();
    }
    return possibleMoves;
  }
}
