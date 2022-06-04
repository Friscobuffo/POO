package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica {

	static private int progId=0;
	private int spostamentoOrizzontale=1;
	private Citta citta;

	public Pendo(Citta citta) {
		super(progId++);
		this.citta = citta;
	}

	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		
		if (this.citta.sulBordo(corrente.traslazioneUnitaria(1, 0))
				|| this.citta.sulBordo(corrente.traslazioneUnitaria(-1, 0))) 
			spostamentoOrizzontale*=-1; //inverte direzione se sul bordo
		
		return corrente.traslazioneUnitaria(spostamentoOrizzontale, 0);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}

}
