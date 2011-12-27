package clausf.backgammon.game;

import java.util.ArrayList;
import java.util.List;

public class Dice {

	private List<Die> dice;

	public Dice() {
		dice = new ArrayList<Die>();
		dice.add(new Die());
		dice.add(new Die());
	}

	public void roll() {
		for (Die die: dice)
			die.roll();
	}

	public List<Die> getDice() {
		return dice;
	}

}
