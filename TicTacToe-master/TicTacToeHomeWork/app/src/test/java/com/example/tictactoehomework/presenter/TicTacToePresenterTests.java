package com.example.tictactoehomework.presenter;


import com.example.tictactoehomework.R;
import com.example.tictactoehomework.view.TicTacView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * There are a lot more tests we can and should write but for now, just a few smoke tests.
 */
@RunWith(MockitoJUnitRunner.class)
public class TicTacToePresenterTests {

    private TicTacPresenter presenter;

    @Mock
    private TicTacView view;

    @Before
    public void setup() {
        presenter = new TicTacPresenter(view);
    }

    private void clickAndAssertValueAt(int row, int col, int expectedDrawableRes) {
        presenter.onImagePressed(row, col);
        verify(view).setImage(row, col, expectedDrawableRes);
    }

    /**
     * This test will simulate and verify X is the winner.
     * <p>
     * X | X | X
     * O |   |
     * | O |
     */
    @Test
    public void test3inRowAcrossTopForX() {

        clickAndAssertValueAt(0, 0, R.drawable.cross);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(1, 0, R.drawable.circle);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(0, 1, R.drawable.cross);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(2, 1, R.drawable.circle);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(0, 2, R.drawable.cross);
        verify(view).showWinner("X");

    }

    /**
     * This test will simulate and verify X is the winner.
     * <p>
     * | O |
     * X | X | X
     * | O |
     */
    @Test
    public void test3inRowAcrossMidForX() {

        clickAndAssertValueAt(1, 0, R.drawable.cross);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(0, 1, R.drawable.circle);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(1, 1, R.drawable.cross);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(2, 1, R.drawable.circle);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(1, 2, R.drawable.cross);

        verify(view).showWinner("X");

    }

    /**
     * This test will simulate and verify X is the winner.
     *
     *     |   |
     *   O | O |
     *   X | X | X
     */
    @Test
    public void test3inRowAcrossBotForX() {

        clickAndAssertValueAt(2, 0, R.drawable.cross);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(0, 1, R.drawable.circle);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(2, 1, R.drawable.cross);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(1, 1, R.drawable.circle);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(2, 2, R.drawable.cross);

        verify(view).showWinner("X");

    }


    /**
     * This test will simulate and verify O is the winner.
     *
     * O | X | X
     *   | O |
     *   | X | O
     */
    @Test
    public void test3inRowDiagonalFromTopLeftToBottomForO() {

        clickAndAssertValueAt(0, 1, R.drawable.cross);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(0, 0, R.drawable.circle);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(2, 1, R.drawable.cross);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(1, 1, R.drawable.circle);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(0, 2, R.drawable.cross);
        verify(view, never()).showWinner(anyString());

        clickAndAssertValueAt(2, 2, R.drawable.circle);
        verify(view).showWinner("O");

    }


}