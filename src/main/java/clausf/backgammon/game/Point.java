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

public class Point implements Comparable<Point> {

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

	@Override
	public int compareTo(Point o) {
		return -Integer.valueOf(position).compareTo(o.getPosition());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + position;
		result = prime * result + stones;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (position != other.position)
			return false;
		if (stones != other.stones)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point: " + position + " " + player + " " + stones;
	}

}
