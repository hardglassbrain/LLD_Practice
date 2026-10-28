package org.example.TicTacToe;

import java.util.Arrays;

public class Board {

    Tile[][] board;

    public Board() {
        this.board = new Tile[3][3];
        for(int i=0;i<3;i++){
            Arrays.fill(board[i],Tile.E);
        }
    }

    public Tile[][] getBoard() {
        return board;
    }
}
