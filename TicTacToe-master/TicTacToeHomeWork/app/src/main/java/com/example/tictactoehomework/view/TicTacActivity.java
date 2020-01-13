package com.example.tictactoehomework.view;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    TextView playerOneScore;
    TextView playerTwoScore;
    TextView activePlayer;
    TicTacPresenter presenter = new TicTacPresenter(this);
    private List<List<ImageView>> imageViewsList = new ArrayList<>();
    private View winnerPlayerViewGroup;
    private TextView winnerPlayerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneScore = findViewById(R.id.player_one_score);
        playerTwoScore = findViewById(R.id.player_two_score);

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
                        Log.i(TAG, "Click Row: [" + finalI + "," + finalJ + "]");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        presenter.onCreate();
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

    }

    @Override
    public void clearWinnerDisplay() {

    }

    @Override
    public void clearImages() {

    }

    @Override
    public void setImage(int row, int col, int drawableRes) {
        imageViewsList.get(row).get(col).setImageResource(drawableRes);
    }

    private void showExitDialog() {
        final Dialog dialog = new Dialog(TicTacActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout_exit);
        dialog.setCancelable(false);

        dialog.show();

        Button exit = dialog.findViewById(R.id.yes_button);
        final Button dismiss = dialog.findViewById(R.id.no_button);

        exit.setOnClickListener(view -> finish());

        dismiss.setOnClickListener(view -> dialog.dismiss());
    }

    @Override
    public void onBackPressed() {
        showExitDialog();
    }

}
