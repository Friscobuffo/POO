package bici.tipo;

import static bici.gui.LettoreImmagini.leggiImmagineBici;
import static bici.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;

import bici.sim.Coordinate;
import bici.sim.Zona;

/**
 * Modella le fasi del ciclo di vista di una bicicletta {@link Bianca}.
 * <B>(VEDI DOMANDA 2)</B>
 */
public class Bianca extends Bici{
	
	static private int progId = 0;
	
	static final private Image IMMAGINE_BICI = leggiImmagineBici(java.awt.Color.WHITE);

	public Bianca(Zona zona) {
		super(zona, progId++);
	}
	
	@Override
	protected Coordinate decidiProssimaDestinazione() {
		return posizioneCasuale();
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_BICI;
	}

	/**
	 * <B>DA CORREGGERE (VEDI DOMANDA 2)</B> 
	 * @return un id progressivo (per tipologia) associato a
	 *         questo oggetto
	 */

}
