package clausf.backgammon.game;

public class Point {

	private int position;
	private Player player;
	private int stones;

	public Point(int position, Player player, int stones) {
		super();
		this.position = position;
		this.player = player;
		this.stones = stones;
	}

	public int getPosition() {
		return position;
	}

	public Player getPlayer() {
		return player;
	}

	public int getStones() {
		return stones;
	}

}
