package clausf.backgammon.game;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Point> white = new ArrayList<Point>();
	private List<Point> black = new ArrayList<Point>();

	public Board() {
		white.add(new Point(24, Player.WHITE, 2));
		white.add(new Point(13, Player.WHITE, 5));
		white.add(new Point( 8, Player.WHITE, 3));
		white.add(new Point( 6, Player.WHITE, 5));
		black.add(new Point(24, Player.BLACK, 2));
		black.add(new Point(13, Player.BLACK, 5));
		black.add(new Point( 8, Player.BLACK, 3));
		black.add(new Point( 6, Player.BLACK, 5));
	}

}
