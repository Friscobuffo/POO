package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella il labirinto della partita
 * 
 * @author Docente di Poo
 * @see Stanza
 * @see Attrezzo
 * @version base
 */
public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	public Labirinto() {
	}
	
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
}
