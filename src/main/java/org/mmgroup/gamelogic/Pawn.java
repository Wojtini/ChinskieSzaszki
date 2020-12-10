package org.mmgroup.gamelogic;

public class Pawn {
  int ownerID;
  boolean locked;
  
  public Pawn(int ownerId) {
    this.ownerID = ownerId;
  }
  
  public int getOwnerId() {
    return ownerID;
  }
  
  public void setLockedState(boolean locked) {
    this.locked = locked;
  }
}
