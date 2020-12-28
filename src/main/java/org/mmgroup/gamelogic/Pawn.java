package org.mmgroup.gamelogic;

/**
 * Pawn object holds ownerId
 * @author Wojciech.Maziarz
 *
 */
public class Pawn {
  int ownerID;
  public Pawn(int ownerId) {
    this.ownerID = ownerId;
  }
  
  public int getOwnerId() {
    return ownerID;
  }
}
