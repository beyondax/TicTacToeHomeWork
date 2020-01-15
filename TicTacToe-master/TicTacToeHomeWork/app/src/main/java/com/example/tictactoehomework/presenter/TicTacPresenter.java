package com.example.tictactoehomework.presenter;

import com.example.tictactoehomework.model.Board;
import com.example.tictactoehomework.model.Player;
import com.example.tictactoehomework.view.TicTacView;

public class TicTacPresenter implements Presenter {

    private TicTacView view;
    private Board board;

    public TicTacPresenter(TicTacView view) {
        this.view = view;
        this.board = new Board();
    }

    @Override
    public void onCreate() {

        board = new Board();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void onImagePressed(int row, int col) {
        Player playerThatMoved = board.mark(row, col);
        if (playerThatMoved != null) {
            view.setImage(row, col, playerThatMoved.getDrawable());

            if (board.getWinner() != null) {
                view.showWinner(playerThatMoved.toString());
            }
        }
    }

    public void onResetSelected() {
        view.clearImages();
        board.restart();
    }

    public String getCurrentPlayer() {
        return board.getCurrentTurn().toString();
    }
}
