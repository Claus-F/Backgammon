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
