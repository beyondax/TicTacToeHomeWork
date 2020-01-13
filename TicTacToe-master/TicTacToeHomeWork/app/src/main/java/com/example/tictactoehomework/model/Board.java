package com.example.tictactoehomework.model;

import static com.example.tictactoehomework.model.Player.CIRCLE;
import static com.example.tictactoehomework.model.Player.CROSS;

public class Board {

    private Cell[][] cells = new Cell[3][3];

    private Player winner;
    private GameState state;
    private Player currentTurn;

    public Board() {
        restart();
    }

    ;

    public void restart() {
        clearCells();
        winner = null;
        currentTurn = CROSS;
        state = GameState.IN_PROGRESS;
    }

    public Player mark(int row, int col) {

        Player playerThatMoved = null;

        if (isValid(row, col)) {

            cells[row][col].setPlayer(currentTurn);
            playerThatMoved = currentTurn;

            if (isWinningMoveByPlayer(currentTurn, row, col)) {
                state = GameState.FINISHED;
                winner = currentTurn;

            } else {
                // flip the current turn and continue
                flipCurrentTurn();
            }
        }

        return playerThatMoved;
    }

    public Player getWinner() {
        return winner;
    }

    private void clearCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private boolean isValid(int row, int col) {
        if (state == GameState.FINISHED) {
            return false;
        } else if (isOutOfBounds(row) || isOutOfBounds(col)) {
            return false;
        } else if (isCellValueAlreadySet(row, col)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isOutOfBounds(int idx) {
        return idx < 0 || idx > 2;
    }

    private boolean isCellValueAlreadySet(int row, int col) {
        return cells[row][col].getPlayer() != null;
    }

    private boolean isWinningMoveByPlayer(Player player, int currentRow, int currentCol) {

        return (cells[currentRow][0].getPlayer() == player         // 3-in-the-row
                && cells[currentRow][1].getPlayer() == player
                && cells[currentRow][2].getPlayer() == player
                || cells[0][currentCol].getPlayer() == player      // 3-in-the-column
                && cells[1][currentCol].getPlayer() == player
                && cells[2][currentCol].getPlayer() == player
                || currentRow == currentCol            // 3-in-the-diagonal
                && cells[0][0].getPlayer() == player
                && cells[1][1].getPlayer() == player
                && cells[2][2].getPlayer() == player
                || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                && cells[0][2].getPlayer() == player
                && cells[1][1].getPlayer() == player
                && cells[2][0].getPlayer() == player);
    }

    private void flipCurrentTurn() {
        currentTurn = currentTurn == CROSS ? CIRCLE : CROSS;
    }

    private enum GameState {IN_PROGRESS, FINISHED}

}
