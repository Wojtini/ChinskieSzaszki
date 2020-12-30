package org.mmgroup.boardfactory;

import org.mmgroup.gamelogic.Board;

public class FourPlayersChineseCheckersFactory implements BoardFactory{
    public Board buildBoard() {
        return fourPlayersGame();
    }
    /**
     * Grid with information how to build board
     * n=0 - field inactive
     * n=1 - field active
     * n>2 - field contains pawn with id n-2
     */
    int[][] fourGrid = {
            {0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,2,2,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0},
             {0,0,0,0,0,0,2,2,2,2,0,0,0,0,0,0},
            {0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0},
             {1,1,1,1,1,1,1,1,1,1,1,3,3,3,3,3},
            {0,1,1,1,1,1,1,1,1,1,1,1,3,3,3,3},
             {0,1,1,1,1,1,1,1,1,1,1,1,3,3,3,0},
            {0,0,1,1,1,1,1,1,1,1,1,1,1,3,3,0},
             {0,0,1,1,1,1,1,1,1,1,1,1,1,3,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0},
             {0,0,5,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,0,5,5,1,1,1,1,1,1,1,1,1,1,1,0},
             {0,5,5,5,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1},
             {5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,4,4,4,4,4,0,0,0,0,0},
             {0,0,0,0,0,0,4,4,4,4,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,4,4,4,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,4,4,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0},
    };

    int[][] winCondition = {
            {0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,4,4,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,4,4,4,0,0,0,0,0,0},
             {0,0,0,0,0,0,4,4,4,4,0,0,0,0,0,0},
            {0,0,0,0,0,0,4,4,4,4,4,0,0,0,0,0},
             {0,0,0,0,0,0,0,0,0,0,0,5,5,5,5,5},
            {0,0,0,0,0,0,0,0,0,0,0,0,5,5,5,5},
             {0,0,0,0,0,0,0,0,0,0,0,0,5,5,5,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,5,5,0},
             {0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
             {0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,3,3,0,0,0,0,0,0,0,0,0,0,0,0},
             {0,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,3,3,3,3,0,0,0,0,0,0,0,0,0,0,0},
             {3,3,3,3,3,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0},
             {0,0,0,0,0,0,2,2,2,2,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,2,2,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0},
    };

    /**
     * Grids interpreter, builds based on fourGrid and winCondition
     * @return board
     */
    public Board fourPlayersGame() {
        Board board = new Board(fourGrid[0].length,fourGrid.length);
        for(int i=0;i<fourGrid.length;i++) {
            for(int j=0;j<fourGrid[i].length;j++) {
                int number = fourGrid[i][j];
                if(number == 0) {
                    board.Grid[j][i].setActive(false);
                }else if(number == 1) {
                    board.Grid[j][i].setActive(true);
                }else {
                    board.insertPawn(j, i, number-2);
                }
            }
        }
        board.winCondition = this.getWinCondition();
        return board;
    }

    /**
     * returns winCondition array
     */
    public int[][] getWinCondition() {
        return winCondition;
    }

}
