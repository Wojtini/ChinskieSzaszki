package org.mmgroup.gamelogic;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pawn {
  int ownerID;
  boolean locked;
  Ellipse2D elipsa;
  Color color = Color.BLACK;
  public Pawn(int ownerId) {
    this.ownerID = ownerId;
  }
  //ustawiamy kolor
  public void setColor(Color color) { this.color = color; }
  //zwracamy kolor
  public Color getColor(){
    return color;
  }
  
  public int getOwnerId() {
    return ownerID;
  }
  
  public void setLockedState(boolean locked) {
    this.locked = locked;
  }
}
