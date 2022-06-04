package bici.tipo;

import static bici.gui.LettoreImmagini.leggiImmagineBici;

import java.awt.Image;
import java.util.List;
import java.util.Random;

import bici.sim.Coordinate;
import bici.sim.CostantiSimulazione;
import bici.sim.GeneratoreCasuale;
import bici.sim.Zona;

public class Gialla extends Bici {
	
	static private int progId = 0;
	static final private Random random = new Random();
	
	static final private Image IMMAGINE_BICI = leggiImmagineBici(java.awt.Color.YELLOW);
	static final private List<Coordinate> DESTINAZIONI =
			GeneratoreCasuale.generaNposizioniCasuali(CostantiSimulazione.N_DESTINAZIONI);

	public Gialla(Zona zona) {
		super(zona, progId++);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_BICI;
	}

	@Override
	protected Coordinate decidiProssimaDestinazione() {
		return DESTINAZIONI.get(random.nextInt(DESTINAZIONI.size()));
	}

}
