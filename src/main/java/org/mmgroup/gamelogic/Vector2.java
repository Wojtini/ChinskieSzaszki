package org.mmgroup.gamelogic;

public class Vector2 {
  public int x;
  public int y;
  public boolean forceTurnAfterThisMove = false;
  
  public Vector2(int x,int y) {
    this.x = x;
    this.y = y;
  }
}