package bici.tipo;

import static bici.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;
import java.util.Set;

import bici.sim.Coordinate;
import bici.sim.Direzione;
import bici.sim.Percorso;
import bici.sim.Zona;

public abstract class Bici {

	private final int id;
	
	private Zona zona;

	private Coordinate posizione; // posizione corrente

	private Direzione direzione;  // direzione corrente

	private Coordinate origine;
	
	private Coordinate destinazione;
	
	public Bici(Zona zona, int id) {
		this.id = id;
		this.zona = zona;
		final Coordinate posizioneIniziale = posizioneCasuale();
		this.posizione = posizioneIniziale;
		this.origine = posizioneIniziale;
		this.destinazione = null;
		this.direzione = null;
	}
	
	public int getId() {
		return id;
	}
	
	public Zona getZona() {
		return this.zona;
	}

	protected void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}

	public Direzione getDirezione() {
		return this.direzione;
	}

	protected void setDirezione(Direzione nuova) {
		this.direzione = nuova;
	}
	
	public abstract Image getImmagine();
	
	protected abstract Coordinate decidiProssimaDestinazione();

	private boolean destinazioneRaggiunta() {
		return this.getPosizione().equals(this.destinazione);
	}
	
	public void simula(int passo) {
		int passoIniziale = -1;
		/* destinazione iniziale gia' fissata? */
		if (this.destinazione==null) {
			this.destinazione = decidiProssimaDestinazione();
			passoIniziale = passo;
		} else if (destinazioneRaggiunta()) {
			/* registra il percorso coperto */
			final Percorso percorso = new Percorso(this,this.origine,this.destinazione);
			percorso.setPassoIniziale(passoIniziale);
			percorso.setPassoFinale(passo);
			this.getZona().add(percorso);
			this.origine = this.destinazione;
			this.destinazione = decidiProssimaDestinazione();			
		}
		direzionaVerso(this.destinazione);
		eseguiSpostamento();
	}
	
	private void eseguiSpostamento() {
		this.setPosizione(this.getPosizione().trasla(this.getDirezione()));
	}
	
	private void direzionaVerso(Coordinate dest) {
		final Direzione verso = Direzione.verso(this.getPosizione(),dest);
		final Set<Direzione> possibili = getPossibiliDirezioni();
		if (possibili.contains(verso)) 
			this.setDirezione(verso);
		else this.setDirezione(Direzione.scegliAcasoTra(possibili));
	}
	
	private Set<Direzione> getPossibiliDirezioni() {
		return this.getZona().getPossibiliDirezioni(this.getPosizione());
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
