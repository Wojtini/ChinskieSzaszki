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
  public void setElipsa(int i,int j){
    if(j%2==1)
      this.elipsa=new Ellipse2D.Double(i*30+10,j*30,30,30);
    else
      this.elipsa=new Ellipse2D.Double(i*30,j*30,30,30);

  }
  //ustawiamy kolor
  public void setColor(Color color) { this.color = color; }
  //zwracamy kolor
  public Color getColor(){
    return color;
  }
  public Ellipse2D getElipsa(){
    return elipsa;
  }
  
  public int getOwnerId() {
    return ownerID;
  }
  
  public void setLockedState(boolean locked) {
    this.locked = locked;
  }
}
