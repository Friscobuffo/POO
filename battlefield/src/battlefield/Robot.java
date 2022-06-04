package battlefield;

import java.util.Comparator;

public abstract class Robot {
	private Position posizione;
	private int longevita;
	
	public Robot(Position p) {
		this.posizione = p;
		this.longevita = 0 ;
	}
	
	public Position getPosizione() {
		return this.posizione;
	}
	
	public int incrementaLongevita() {
		return ++this.longevita;
	}
	
	public int getLongevita() {
		return this.longevita;
	}
	
	public void passo(Battlefield field) {
		Position nuova = this.decidiMossa(field);
		if (nuova!=null) {
			Robot clone = creaClone(nuova);
			field.addRobot(clone);
		}
		this.incrementaLongevita();
	}
	
	protected abstract Position decidiMossa(Battlefield field);

	protected abstract Robot creaClone(Position position);
	
	public static class comparatorePerPosizione implements Comparator<Robot> {
		
		private Comparator<Position> comparatorePosizione = new Position.Comparatore();

		@Override
		public int compare(Robot r1, Robot r2) {
			return comparatorePosizione.compare(r1.getPosizione(), r2.getPosizione());
		}
		
	}
	
	public static class comparatorePerLongevita implements Comparator<Robot> {

		private Comparator<Robot> comparatorePerPosizione = new comparatorePerPosizione();
		
		@Override
		public int compare(Robot r1, Robot r2) {
			
			if (r1.getLongevita() == r2.getLongevita())
				return comparatorePerPosizione.compare(r1, r2);
			
			return (r1.getLongevita() - r2.getLongevita());
		}
		
	}
}
