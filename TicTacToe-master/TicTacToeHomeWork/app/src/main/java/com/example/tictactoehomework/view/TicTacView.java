package com.example.tictactoehomework.view;


public interface TicTacView {

    void showWinner(String winningPlayerDisplayLabel);

    void clearWinnerDisplay();

    void clearImages();

    void setImage(int row, int col, int drawableRes);

}
