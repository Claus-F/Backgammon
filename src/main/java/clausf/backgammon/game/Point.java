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
