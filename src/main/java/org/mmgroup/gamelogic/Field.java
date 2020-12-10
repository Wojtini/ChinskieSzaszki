package org.mmgroup.gamelogic;

public class Field {
  Pawn currPawn = null;
  boolean active;
  
  public Pawn getPawn() {
    return currPawn;
  }
  
  public boolean isOccupied() {
    if(currPawn==null)
      return false;
    return true;
  }
  
  public void removePawn() {
    currPawn = null;
  }
  
  public void setPawn(Pawn pawn) {
    currPawn = pawn;
  }
  
  public void setActive(boolean bool) {
    this.active = bool;
  }
}
