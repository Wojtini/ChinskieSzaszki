package org.mmgroup.gamelogic;

import java.awt.geom.Ellipse2D;

public class Field {
  Pawn currPawn = null;
  boolean active;
   public Ellipse2D ellipse;
 /* public Field(int i, int j){
    ellipse = new Ellipse2D.Double( i*20,j*20,20,20);
  }
  public Ellipse2D getEllipse(){
    return ellipse;
  }
  */
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
