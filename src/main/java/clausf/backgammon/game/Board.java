/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\
 * Copyright (C) 2011 Claus Frühwirth                                    *
 *                                                                       *
 * This program is free software: you can redistribute it and/or modify  *
 * it under the terms of the GNU General Public License as published by  *
 * the Free Software Foundation, either version 3 of the License, or     *
 * (at your option) any later version.                                   *
 *                                                                       *
 * This program is distributed in the hope that it will be useful,       *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 * GNU General Public License for more details.                          *
 *                                                                       *
 * You should have received a copy of the GNU General Public License     *
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. *
\* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package clausf.backgammon.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

	public static final int BAR = 25;
	public static final int OFF = 0;

	private Map<Player, List<Point>> board;

	public Board() {
		List<Point> white = new ArrayList<Point>();
		white.add(new Point(24, Player.WHITE, 2));
		white.add(new Point(13, Player.WHITE, 5));
		white.add(new Point( 8, Player.WHITE, 3));
		white.add(new Point( 6, Player.WHITE, 5));

		List<Point> black = new ArrayList<Point>();
		black.add(new Point(24, Player.BLACK, 2));
		black.add(new Point(13, Player.BLACK, 5));
		black.add(new Point( 8, Player.BLACK, 3));
		black.add(new Point( 6, Player.BLACK, 5));

		board = new HashMap<Player, List<Point>>();
		board.put(Player.WHITE, white);
		board.put(Player.BLACK, black);
	}

	public List<Point> getPlayer(Player player) {
		return board.get(player);
	}

	public Point getPoint(Player player, int position) {
		for (Point point : board.get(player)) {
			if (point.getPosition() == position)
				return point;
		}
		for (Point point : board.get(player.opponent())) {
			if (point.getPosition() == (25 - position))
				return point;
		}
		return null;
	}

	public void move(Player player, Move move) throws RuleViolationException {
		Point from = getPoint(player, move.getFrom());
		Point to = getPoint(player, move.getTo());

		if (from == null || from.getPlayer() != player || from.getStones() < 1)
			throw new RuleViolationException("cannot move: player has no stone on from-field");
		if (to != null && to.getPlayer() != player && to.getStones() != 1)
			throw new RuleViolationException("cannot move: opponent has 2 or more stones on to-field");

		List<Point> points = getPlayer(player);
		points.remove(from);
		if (from.getStones() > 1) {
			Point newFrom = new Point(from.getPosition(), from.getPlayer(), from.getStones() - 1);
			points.add(newFrom);
		}

		if (to == null) {
			Point newTo = new Point(move.getTo(), player, 1);
			points.add(newTo);
		}
		else if (to.getPlayer() == player) {
			points.remove(to);
			Point newTo = new Point(to.getPosition(), to.getPlayer(), from.getStones() + 1);
			points.add(newTo);
		}
		else {
			List<Point> opponent = getPlayer(player.opponent());
			opponent.remove(to);
			Point opponentBar = getPoint(player.opponent(), BAR);
			if (opponentBar == null) {
				Point newOpponent = new Point(BAR, player.opponent(), 1);
				opponent.add(newOpponent);
			}
			else {
				opponent.remove(opponentBar);
				Point newOpponent = new Point(BAR, player.opponent(), opponentBar.getStones() + 1);
				opponent.add(newOpponent);
			}
			Collections.sort(opponent);

			Point newTo = new Point(move.getTo(), player, 1);
			points.add(newTo);
		}

		Collections.sort(points);
	}

}
