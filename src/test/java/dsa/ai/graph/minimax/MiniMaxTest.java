package dsa.ai.graph.minimax;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MiniMaxTest {

    @Test
    public void minimax() {

        // This section is for testing purposes only, in cases where the
        // computer makes a seemingly bad choice.
        Board board = new Board();
        board.set(0, Board.MARK_RED);
        board.set(0, Board.MARK_RED);

        board.set(1, Board.MARK_BLACK);
        board.set(1, Board.MARK_RED);
        board.set(1, Board.MARK_BLACK);
        board.set(1, Board.MARK_BLACK);
        board.set(1, Board.MARK_RED);
        board.set(1, Board.MARK_RED);

        board.set(2, Board.MARK_RED);
        board.set(2, Board.MARK_RED);
        board.set(2, Board.MARK_RED);
        board.set(2, Board.MARK_BLACK);
        board.set(2, Board.MARK_RED);

        board.set(3, Board.MARK_RED);
        board.set(3, Board.MARK_BLACK);
        board.set(3, Board.MARK_RED);
        board.set(3, Board.MARK_BLACK);
        board.set(3, Board.MARK_BLACK);
        board.set(3, Board.MARK_BLACK);

        board.set(4, Board.MARK_BLACK);
        board.set(4, Board.MARK_RED);
        board.set(4, Board.MARK_BLACK);
        board.set(4, Board.MARK_RED);

        board.set(6, Board.MARK_BLACK);
        board.set(6, Board.MARK_BLACK);
        board.set(6, Board.MARK_BLACK);
        board.set(6, Board.MARK_RED);
        board.set(6, Board.MARK_BLACK);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);

        board.display(out);

        String board1 = "| |X| |O| | | |\n"
                + "| |X|X|O| | |O|\n"
                + "| |O|O|O|X| |X|\n"
                + "| |O|X|X|O| |O|\n"
                + "|X|X|X|O|X| |O|\n"
                + "|X|O|X|X|O| |O|\n"
                + "---------------";

        assertEquals(board1.trim(), baos.toString().trim());

        Minimax minimax = new Minimax(board, 8);
        char mark = Board.MARK_RED;
        int col = minimax.alphaBeta(mark);
//        System.out.println("Place in column: " + col);
        assertEquals(2, col);

//        System.out.println("Boards analyzed: " + minimax.getBoardsAnalyzed());

        assertEquals(2494, minimax.getBoardsAnalyzed());
        board.set(col, mark);
        board.display(out);

        /*
        String board2 = "| |X|X|O| | | |\n"
                + "| |X|X|O| | |O|\n"
                + "| |O|O|O|X| |X|\n"
                + "| |O|X|X|O| |O|\n"
                + "|X|X|X|O|X| |O|\n"
                + "|X|O|X|X|O| |O|\n"
                + "---------------";

        assertEquals(board2.trim(), baos.toString().trim());
        */
    }

}
