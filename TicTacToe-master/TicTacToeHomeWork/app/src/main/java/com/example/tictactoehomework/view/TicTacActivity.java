package com.example.tictactoehomework.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tictactoehomework.R;
import com.example.tictactoehomework.presenter.TicTacPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TicTacActivity extends AppCompatActivity implements TicTacView {

    private static String TAG = TicTacActivity.class.getName();

    ImageView cell_00, cell_01, cell_02, cell_10, cell_11, cell_12, cell_20, cell_21, cell_22;
    private TextView mPlayerOneScore;
    private TextView mPlayerTwoScore;
    private TextView mActivePlayer;
    private Button mResetButton;
    private int scoreOne = 0;
    private int scoreTwo = 0;
    TicTacPresenter presenter = new TicTacPresenter(this);
    private List<List<ImageView>> imageViewsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayerOneScore = findViewById(R.id.player_one_score);
        mPlayerTwoScore = findViewById(R.id.player_two_score);
        mActivePlayer = findViewById(R.id.active_player);

        mResetButton = findViewById(R.id.reset_main);

        mPlayerOneScore.setText(String.valueOf(scoreOne));
        mPlayerTwoScore.setText(String.valueOf(scoreOne));

        cell_00 = findViewById(R.id.table_00);
        cell_01 = findViewById(R.id.table_01);
        cell_02 = findViewById(R.id.table_02);
        cell_10 = findViewById(R.id.table_10);
        cell_11 = findViewById(R.id.table_11);
        cell_12 = findViewById(R.id.table_12);
        cell_20 = findViewById(R.id.table_20);
        cell_21 = findViewById(R.id.table_21);
        cell_22 = findViewById(R.id.table_22);

        imageViewsList.add(Arrays.asList(cell_00, cell_01, cell_02));
        imageViewsList.add(Arrays.asList(cell_10, cell_11, cell_12));
        imageViewsList.add(Arrays.asList(cell_20, cell_21, cell_22));


        for (int i = 0; i < imageViewsList.size(); i++) {
            int finalI = i;
            for (int j = 0; j < imageViewsList.size(); j++) {
                int finalJ = j;
                imageViewsList.get(i).get(j).setOnClickListener(v -> {
                    try {
                        presenter.onImagePressed(finalI, finalJ);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        presenter.onCreate();
        currentPlayer();

        mResetButton.setOnClickListener(v -> {
            presenter.onResetSelected();
            currentPlayer();
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }


    @Override
    public void showWinner(String winningPlayerDisplayLabel) {
        final Dialog dialog = new Dialog(TicTacActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_winner_reset);
        TextView titleText = dialog.findViewById(R.id.winner);
        dialog.setCancelable(false);
        dialog.show();

        titleText.setText(winningPlayerDisplayLabel + " WINS!");

        switch (winningPlayerDisplayLabel) {
            case "X":
                scoreOne++;
                break;
            case "O":
                scoreTwo++;
                break;
            default:
                break;
        }

        mPlayerOneScore.setText(String.valueOf(scoreOne));
        mPlayerTwoScore.setText(String.valueOf(scoreTwo));

        Button exit = dialog.findViewById(R.id.exit_button);
        final Button reset = dialog.findViewById(R.id.reset_button);

        exit.setOnClickListener(view -> finish());
        reset.setOnClickListener(view -> {
            dialog.dismiss();
            presenter.onResetSelected();
        });

    }

    @Override
    public void clearImages() {
        for (int i = 0; i < imageViewsList.size(); i++) {
            for (int j = 0; j < imageViewsList.size(); j++) {
                imageViewsList.get(i).get(j).setImageResource(0);
            }
        }
    }

    @Override
    public void currentPlayer() {
        mActivePlayer.setText(presenter.getCurrentPlayer());
    }

    @Override
    public void setImage(int row, int col, int drawableRes) {
        imageViewsList.get(row).get(col).setImageResource(drawableRes);
        currentPlayer();
    }

}