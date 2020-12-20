package org.mmgroup.server;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.mmgroup.boardfactory.BoardFactory;
import org.mmgroup.boardfactory.TwoPlayersChineseCheckersFactory;
import org.mmgroup.gamelogic.Board;
import org.mmgroup.gamelogic.GameRules;
import org.mmgroup.gamelogic.JumpMove;
import org.mmgroup.gamelogic.NormalMove;
import org.mmgroup.gamelogic.Vector2;

public class GameLobby {
  Board board;
  Server server;
  int[][] winCondition;
  
  public GameRules moveRules = new GameRules();
  private ArrayList<String> rulesNames = new ArrayList<String>();
  
  public GameLobby(Server server) {
    this.server = server;
  }
  
  public void setBoard(Board board) {
    this.board = board;
  }
  
  public Board getBoard() {
    return board;
  }
  
  public void addMoveRule(String ruleName) {
    if(ruleName.equals("normalMove")) {
      moveRules.addMoveRuleOption(new NormalMove());
    }else if(ruleName.equals("jumpMove")) {
      moveRules.addMoveRuleOption(new JumpMove());
    }else {
      System.out.println("SERVER WARNING: proba dodania nie istniejacej zasady");
      return;
    }
    rulesNames.add(ruleName);
  }
  
  public void startGame() {
    /*
     * Trzeba ustawic nieaktywne pionki i pola fabryczka czy cus
     */
    BoardFactory bf = createFactory();
    Board board = bf.buildBoard();
    this.setBoard(board);
    this.winCondition = bf.getWinCondition();
    sendBoard();
    
    sendRules();
    /*
     * 
     */
    this.gameLoop();
  }
  
  BoardFactory createFactory() {
    if(server.getNumberOfPlayers()==2) {
      return new TwoPlayersChineseCheckersFactory();
    }else if(server.getNumberOfPlayers()==3) {
      //TO DO
    }else if(server.getNumberOfPlayers()==4) {
      //TO DO
    }else if(server.getNumberOfPlayers()==6) {
      //TO DO
    }
    return null;
    
  }
  
  void sendRules() {
    for(String ruleName: rulesNames) {
      server.broadcast("addRule;"+ruleName);
    }
  }
  
  void sendBoard() {
    server.broadcast("createBoard;"+board.getWidth()+";"+board.getHeight());
    for(int i=0;i<board.getWidth();i++) {
      for(int j=0;j<board.getHeight();j++) {
        if(board.Grid[i][j].getActive()) {
          server.broadcast("setFieldActive;"+i+";"+j+";1");
          if(board.Grid[i][j].getPawn()!=null) {
            server.broadcast("insertPawn;"+i+";"+j+";"+board.Grid[i][j].getPawn().getOwnerId());
          }
        }else {
          server.broadcast("setFieldActive;"+i+";"+j+";0");
        }
      }
    }
  }
  
  void gameLoop() {
    //server.numberOfPlayers;
    Random rd = new Random();
    int rand = Math.abs(rd.nextInt());
    System.out.println("SERVER: zaczyna gracz o id " + rand%server.numberOfPlayers);
    int turaGracza = rand%server.numberOfPlayers;
    int winnersCount = 0;
    boolean czyKoniecRozgrywki = false;
    while(!czyKoniecRozgrywki) {
      server.getAllPlayers().get(turaGracza).setTurn(true);
      server.getAllPlayers().get(turaGracza).movedThisTurn = false;
      server.broadcast("newTurn;"+turaGracza);
      System.out.println("SERVER: Tura Gracza o ID: " + turaGracza);
      /*
       * Czekanie az gracz skonczy ture lub jesli status==false (gracz wygral i juz nie moze sie ruszyc)
       */
      ConnectedPlayer currentPlayer = server.getAllPlayers().get(turaGracza);
      while(currentPlayer.isItsTurn() && currentPlayer.getPlayingStatus()) {
        Wait(1);
        //System.out.println("Oczekiwanie na gracza numer: " + server.getAllPlayers().get(turaGracza).getId() + " " + turaGracza + " - ");
      };
      if(checkIfWinner(currentPlayer.getId())) {
        System.out.println("ZWYCIEZYL GRACZ " + currentPlayer.getId());
        winnersCount++;
        if(winnersCount+1==server.getNumberOfPlayers()) {
          czyKoniecRozgrywki = true;
        }
        /*
         * GRACZ WYGRAL POWIADOM WSZYSTKICH
         */
      }
      System.out.println("SERVER: GRACZ o ID: " + turaGracza + " zakonczyl ture ");
      turaGracza = turaGracza + 1;
      turaGracza = turaGracza % server.numberOfPlayers;
      System.out.println(turaGracza);
    }
    System.out.println("Koniec gry");
    /*
     * KONIEC GRY POWIADOM WSZYSTKICH
     */
  }
  
  public void Wait(int sec) {
    try {
      TimeUnit.SECONDS.sleep(sec);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public int checkIfMoveIsLegal(int fromX,int fromY,int toX,int toY, boolean movedThisTurn) {
    ArrayList<Vector2> possMoves = moveRules.getAvailableMovesForPos(this.board, fromX, fromY, movedThisTurn);
    /*
     * Sprawdzanie czy ruch byl legalny
     */
    for(Vector2 move: possMoves) {
      if(move.x == toX && move.y == toY) {
        if(move.forceTurnAfterThisMove) {
          return 2; // Legalny, konczacy ture
        }
        return 1; // Legalny, niekonczacy ture
      }
    }
    return 0; //Nielegalny
  }
  
  public boolean checkIfWinner(int playerId){
    for(int i=0;i<winCondition.length;i++) {
      for(int j=0;j<winCondition[i].length;j++) {
          int number = winCondition[i][j] - 2;
          if(number==playerId) {
            
            if(board.Grid[j][i].getPawn() == null) {
              return false;
            }else if(board.Grid[j][i].getPawn().getOwnerId() != playerId) {
              return false;
            }
            
          }
      }
    }
    return true;
  };
}


