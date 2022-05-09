package it.uniroma3.diadia.giocatore;

/**
 * Classe che modella il giocatore nella partita
 * 
 * @author Docente di Poo
 * @see Borsa
 * @version base
 */
public class Giocatore {

	static final public int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;

	public Giocatore() {
		borsa = new Borsa();
		this.cfu = CFU_INIZIALI;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}

	/**
	 * Verifica che il giocatore è ancora vivo
	 * @return boolean true se è vivo, false altrimenti
	 */
	public boolean isVivo() {
		return this.cfu>0;
	}
	
	public String toString() {
		return ("CFU disponibili: " + this.getCfu() + "\n" + this.getBorsa().getDescrizione());
	}
	
	public String getDescrizione() {
		return this.toString();
	}
}
