package org.mmgroup.gamelogic;

import java.awt.geom.Ellipse2D;

/** Field contains Ellipse2D object,
 * when field has a pawn, ellipse object changes its color to player's color*/

public class Field {
  Pawn currPawn = null;
  boolean active = true;
  public Ellipse2D elipsa;
/**
 * Field's constructor
 * @param i  x axis
 * @param j  y axis
 * */
  public Field(int i, int j) {
    if (j % 2 == 1) {
      this.elipsa = new Ellipse2D.Double(i * 30 + 15, j * 30 + 15, 30, 30);
    }
    else {
      this.elipsa = new Ellipse2D.Double(i * 30, j * 30 + 15, 30, 30);
    }
  }

  public Ellipse2D getEllipse() {
    return elipsa;
  }

  public Pawn getPawn() {
    return currPawn;
  }

  public boolean isOccupied() {
    if (currPawn == null)
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

  public boolean getActive() {
    return active;
  }
}
