package com.example.tictactoehomework.view;


public interface TicTacView {

    void showWinner(String winningPlayerDisplayLabel);

    void clearImages();

    void showCurrentPlayer(String name);

    void setImage(int row, int col, int drawableRes);


}
