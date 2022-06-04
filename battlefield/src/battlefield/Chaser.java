package battlefield;

public class Chaser extends Robot{

	public Chaser(Position p) {
		super(p);
	}
	
	@Override	
	public Position decidiMossa(Battlefield field) {
		Walker inseguito = cercaAvversario(field);
		if (inseguito==null) 
			return null; /* nessuno da inseguire: stai fermo */
		else return inseguito.getPosizione();
	}

	private Walker cercaAvversario(Battlefield field) {
		for(Position p : field.adiacenti(this.getPosizione())) {
			Robot vicino = field.getRobot(p);
			if (vicino != null && isAvversario(vicino)) {
				return (Walker) vicino;
			}
		}
		return null;
	}

	private boolean isAvversario(Robot avvistato) {
		return avvistato.getClass().equals(Walker.class);
	}

	@Override
	protected Robot creaClone(Position position) {
		return new Chaser(position);
	}

	
}

