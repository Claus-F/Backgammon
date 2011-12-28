package clausf.backgammon.game;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class MoveTest extends TestCase {

	public void testOpening1() throws RuleViolationException {
		Board board = new Board();

		Point point = board.getPoint(Player.WHITE, 23);
		assertNull(point);

		Moves moves = new Moves();
		moves.addMove(new Move(8, 5));
		moves.addMove(new Move(24, 23));

		board.move(Player.WHITE, moves);

		point = board.getPoint(Player.WHITE, 23);
		assertNotNull(point);
		assertEquals(23, point.getPosition());
		assertEquals(Player.WHITE, point.getPlayer());
		assertEquals(1, point.getStones());

		List<Point> white = new ArrayList<Point>();
		white.add(new Point(24, Player.WHITE, 1));
		white.add(new Point(23, Player.WHITE, 1));
		white.add(new Point(13, Player.WHITE, 5));
		white.add(new Point( 8, Player.WHITE, 2));
		white.add(new Point( 6, Player.WHITE, 5));
		white.add(new Point( 5, Player.WHITE, 1));

		List<Point> black = new ArrayList<Point>();
		black.add(new Point(24, Player.BLACK, 2));
		black.add(new Point(13, Player.BLACK, 5));
		black.add(new Point( 8, Player.BLACK, 3));
		black.add(new Point( 6, Player.BLACK, 5));

		Board expected = new Board(white, black);
		assertEquals(expected, board);
	}

	public void testEndGame1() throws RuleViolationException {
		List<Point> white = new ArrayList<Point>();
		white.add(new Point( 3, Player.WHITE,  3));
		white.add(new Point( 2, Player.WHITE,  1));
		white.add(new Point( 0, Player.WHITE, 11));

		List<Point> black = new ArrayList<Point>();
		black.add(new Point( 1, Player.BLACK,  3));
		black.add(new Point( 0, Player.BLACK, 12));

		Board board = new Board(white, black);

		Moves moves = new Moves();
		moves.addMove(new Move(3, 0));
		moves.addMove(new Move(2, 0));

		board.move(Player.WHITE, moves);

		white = new ArrayList<Point>();
		white.add(new Point( 3, Player.WHITE,  2));
		white.add(new Point( 0, Player.WHITE, 13));

		black = new ArrayList<Point>();
		black.add(new Point( 1, Player.BLACK,  3));
		black.add(new Point( 0, Player.BLACK, 12));

		Board expected = new Board(white, black);
		assertEquals(expected, board);
	}

	public void testOffBar1() throws RuleViolationException {
		List<Point> white = new ArrayList<Point>();
		white.add(new Point( 6, Player.WHITE, 5));
		white.add(new Point( 4, Player.WHITE, 2));
		white.add(new Point( 3, Player.WHITE, 5));
		white.add(new Point( 2, Player.WHITE, 1));
		white.add(new Point( 1, Player.WHITE, 2));

		List<Point> black = new ArrayList<Point>();
		black.add(new Point(25, Player.BLACK,  2));
		black.add(new Point( 1, Player.BLACK,  3));
		black.add(new Point( 0, Player.BLACK, 10));

		Board board = new Board(white, black);

		Moves moves = new Moves();
		moves.addMove(new Move(3, 0));
		moves.addMove(new Move(2, 0));

		board.move(Player.WHITE, moves);

		white = new ArrayList<Point>();
		white.add(new Point( 6, Player.WHITE, 5));
		white.add(new Point( 4, Player.WHITE, 2));
		white.add(new Point( 3, Player.WHITE, 4));
		white.add(new Point( 1, Player.WHITE, 2));
		white.add(new Point( 0, Player.WHITE, 2));

		black = new ArrayList<Point>();
		black.add(new Point(25, Player.BLACK,  2));
		black.add(new Point( 1, Player.BLACK,  3));
		black.add(new Point( 0, Player.BLACK, 10));

		Board expected = new Board(white, black);
		assertEquals(expected, board);
	}

	public void testOffBar2() throws RuleViolationException {
		List<Point> white = new ArrayList<Point>();
		white.add(new Point( 6, Player.WHITE, 5));
		white.add(new Point( 4, Player.WHITE, 2));
		white.add(new Point( 3, Player.WHITE, 5));
		white.add(new Point( 2, Player.WHITE, 1));
		white.add(new Point( 1, Player.WHITE, 2));

		List<Point> black = new ArrayList<Point>();
		black.add(new Point(25, Player.BLACK,  1));
		black.add(new Point( 1, Player.BLACK,  3));
		black.add(new Point( 0, Player.BLACK, 11));

		Board board = new Board(white, black);

		Moves moves = new Moves();
		moves.addMove(new Move(3, 0));
		moves.addMove(new Move(2, 0));

		board.move(Player.WHITE, moves);

		white = new ArrayList<Point>();
		white.add(new Point( 6, Player.WHITE, 5));
		white.add(new Point( 4, Player.WHITE, 2));
		white.add(new Point( 3, Player.WHITE, 4));
		white.add(new Point( 1, Player.WHITE, 2));
		white.add(new Point( 0, Player.WHITE, 2));

		black = new ArrayList<Point>();
		black.add(new Point(25, Player.BLACK,  1));
		black.add(new Point( 1, Player.BLACK,  3));
		black.add(new Point( 0, Player.BLACK, 11));

		Board expected = new Board(white, black);
		assertEquals(expected, board);
	}

}
