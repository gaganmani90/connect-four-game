package com.droptoken.repository;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class Board {
    private String[][] board;

    public Board(int row, int col) {
        board = new String[row][col];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = StringUtils.EMPTY;
            }
        }
    }

    public void moveWhenLegal(int col, String player) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (StringUtils.isEmpty(board[row][col])) {
                board[row][col] = player;
                break;
            }
        }
        checkWinner(player);
    }

    public boolean checkWinner(String player) {
        int width = board[0].length;
        int height = board.length;
        // horizontalCheck
        for (int j = 0; j < height - 3; j++) {
            for (int i = 0; i < width; i++) {
                if (this.board[i][j] == player && this.board[i][j + 1] == player
                        && this.board[i][j + 2] == player && this.board[i][j + 3] == player) {
                    return true;
                }
            }
        }
        // verticalCheck
        for (int i = 0; i < width - 3; i++) {
            for (int j = 0; j < height; j++) {
                if (this.board[i][j] == player && this.board[i + 1][j] == player
                        && this.board[i + 2][j] == player && this.board[i + 3][j] == player) {
                    return true;
                }
            }
        }
        // ascendingDiagonalCheck
        for (int i = 3; i < width; i++) {
            for (int j = 0; j < height - 3; j++) {
                if (this.board[i][j] == player && this.board[i - 1][j + 1] == player
                        && this.board[i - 2][j + 2] == player && this.board[i - 3][j + 3] == player)
                    return true;
            }
        }
        // descendingDiagonalCheck
        for (int i = 3; i < width; i++) {
            for (int j = 3; j < height; j++) {
                if (this.board[i][j] == player && this.board[i - 1][j - 1] == player
                        && this.board[i - 2][j - 2] == player && this.board[i - 3][j - 3] == player)
                    return true;
            }
        }
        return false;
    }

    public boolean isSpaceLeft(int col) {
        String value = board[0][col];
        if (StringUtils.isEmpty(value)) {
            return true;
        }
        return false;
    }
}
