package battlefield;

import java.util.Comparator;

/*
 * Da sistemare. Vedi PositionTest.
 * (vedi DOMANDA 1)
 */
public class Position {
	
	private int x, y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
		
	public String toString() {
		return this.x+"-"+this.y;
	}

	@Override
	public boolean equals(Object o) {
		Position that = (Position) o;
		return this.getX() == that.getX() && this.getY() == that.getY();
	}
	
	@Override
	public int hashCode() {
		return this.x + this.y*Main.DIMENSIONE;
	}
	
	public static class Comparatore implements Comparator<Position> {

		@Override
		public int compare(Position p1, Position p2) {
			if (p1.x == p2.x)
				return p1.y - p2.y;
			return p1.x - p2.x;
		}
		
	}
}