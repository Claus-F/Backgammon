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

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Moves {

	private Map<Move, Integer> moves = new TreeMap<Move, Integer>();

	public Moves() {
		super();
	}

	public void addMove(Move move) {
		if (moves.get(move) == null) {
			moves.put(move, 1);
		}
		else {
			moves.put(move, moves.get(move) + 1);
		}
	}

	public Map<Move, Integer> getMoves() {
		return moves;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moves == null) ? 0 : moves.hashCode());
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
		Moves other = (Moves) obj;
		if (moves == null) {
			if (other.moves != null)
				return false;
		} else if (!moves.equals(other.moves))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder("Moves:");

		for (Entry<Move, Integer> entry : moves.entrySet()) {
			buffer.append(" ");
			buffer.append(entry.getKey().getFrom());
			buffer.append("/");
			buffer.append(entry.getKey().getTo());
			if (entry.getValue() > 1)
				buffer.append("(").append(entry.getValue()).append(")");
		}

		return buffer.toString();
	}

}
