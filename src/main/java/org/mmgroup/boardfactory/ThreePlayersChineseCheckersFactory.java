package org.mmgroup.boardfactory;

import org.mmgroup.gamelogic.Board;

public class ThreePlayersChineseCheckersFactory implements BoardFactory{
    @Override
    public Board buildBoard() {
        return threePlayersGame();
    }
    /**
     * Grid with information how to build board
     * n=0 - field inactive
     * n=1 - field active
     * n>2 - field contains pawn with id n-2
     */
    int[][] threeGrid = {
            {0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,2,2,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0},
             {0,0,0,0,0,0,2,2,2,2,0,0,0,0,0,0},
            {0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0},
             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
             {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
             {0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0},
             {0,0,4,1,1,1,1,1,1,1,1,1,1,3,0,0},
            {0,0,4,4,1,1,1,1,1,1,1,1,1,3,3,0},
             {0,4,4,4,1,1,1,1,1,1,1,1,3,3,3,0},
            {0,4,4,4,4,1,1,1,1,1,1,1,3,3,3,3},
             {4,4,4,4,4,1,1,1,1,1,1,3,3,3,3,3},
            {0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0},
             {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
    };
    int[][] winCondition = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
             {3,3,3,3,3,0,0,0,0,0,0,4,4,4,4,4},
            {0,3,3,3,3,0,0,0,0,0,0,0,4,4,4,4},
             {0,3,3,3,0,0,0,0,0,0,0,0,4,4,4,0},
            {0,0,3,3,0,0,0,0,0,0,0,0,0,4,4,0},
             {0,0,3,0,0,0,0,0,0,0,0,0,0,4,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0},
             {0,0,0,0,0,0,2,2,2,2,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,2,2,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0},
    };

    /**
     * Grids interpreter, builds based on threeGrid and winCondition
     * @return board
     */
    public Board threePlayersGame() {
        Board board = new Board(threeGrid[0].length,threeGrid.length);
        for(int i=0;i<threeGrid.length;i++) {
            for(int j=0;j<threeGrid[i].length;j++) {
                int number = threeGrid[i][j];
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
    @Override
    public int[][] getWinCondition() {
        return winCondition;
    }
}
