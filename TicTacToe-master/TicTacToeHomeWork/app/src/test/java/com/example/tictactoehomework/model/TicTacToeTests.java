package com.example.tictactoehomework.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class TicTacToeTests {

    private Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    /**
     * This test will simulate and verify X is the winner.
     *
     *   X | X | X
     *   O |   |
     *     | O |
     */

    @Test
    public void test3inRowAcrossTopForX() {

        board.mark(0, 0); // X
        assertNull(board.getWinner());

        board.mark(1, 0); // O
        assertNull(board.getWinner());

        board.mark(0, 1); // X
        assertNull(board.getWinner());

        board.mark(2, 1); // O
        assertNull(board.getWinner());

        board.mark(0, 2); // X
        assertEquals(Player.X, board.getWinner());
    }

    /**
     * This test will simulate and verify X is the winner.
     *
     *    O |   |
     *    X | X | X
     *      | O |
     */

    @Test
    public void test3inRowMidLineFromLeftToRightForX() {

        board.mark(1, 0); // X
        assertNull(board.getWinner());

        board.mark(0, 0); // O
        assertNull(board.getWinner());

        board.mark(1, 1); // X
        assertNull(board.getWinner());

        board.mark(2, 1); // O
        assertNull(board.getWinner());

        board.mark(1, 2); // X
        assertEquals(Player.X, board.getWinner());
    }


    /**
     * This test will simulate and verify O is the winner.
     *
     *   O | X | X
     *     | O |
     *     | X | O
     */

    @Test
    public void test3inRowDiagonalFromTopLeftToBottomForO() {

        board.mark(0, 1); // X
        assertNull(board.getWinner());

        board.mark(0, 0); // O
        assertNull(board.getWinner());

        board.mark(2, 1); // X
        assertNull(board.getWinner());

        board.mark(1, 1); // O
        assertNull(board.getWinner());

        board.mark(0, 2); // X
        assertNull(board.getWinner());

        board.mark(2, 2); // O
        assertEquals(Player.O, board.getWinner());

    }

    /**
     * This test will simulate and verify O is the winner.
     *
     * X | O | X
     *   | O | X
     *   | O |
     */

    @Test
    public void test3inMidLineFromTopToBottomForO() {

        board.mark(0, 0); // X
        assertNull(board.getWinner());

        board.mark(0, 1); // O
        assertNull(board.getWinner());

        board.mark(0, 2); // X
        assertNull(board.getWinner());

        board.mark(1, 1); // O
        assertNull(board.getWinner());

        board.mark(1, 2); // X
        assertNull(board.getWinner());

        board.mark(2, 1); // O
        assertEquals(Player.O, board.getWinner());

    }

}
