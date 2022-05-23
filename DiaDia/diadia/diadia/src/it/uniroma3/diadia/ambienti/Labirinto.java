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
	
	public static Labirinto labirintoDiaDia() {
		return new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addMago("Merlino", new Attrezzo("bacchetta magica",1))
				.addAttrezzo("osso",1)
				.addStanza("Aula N10")
				.addCane()
				.addAttrezzo("lanterna", 3)
				.addStanza("Aula N11")
				.addStanza("Laboratorio Campus")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", Stanza.NORD)
				.addAdiacenza("Atrio", "Aula N11", Stanza.EST)
				.addAdiacenza("Atrio", "Aula N10", Stanza.SUD)
				.addAdiacenza("Atrio", "Laboratorio Campus", Stanza.OVEST)
				.addAdiacenza("Aula N11", "Laboratorio Campus", Stanza.EST)
				.addAdiacenza("Aula N11", "Atrio", Stanza.OVEST)
				.addAdiacenza("Aula N10", "Atrio", Stanza.NORD)
				.addAdiacenza("Aula N10", "Aula N11", Stanza.EST)
				.addAdiacenza("Aula N10", "Laboratorio Campus", Stanza.OVEST)
				.addAdiacenza("Laboratorio Campus", "Atrio", Stanza.EST)
				.addAdiacenza("Laboratorio Campus", "Aula N11", Stanza.OVEST)
				.addAdiacenza("Biblioteca", "Atrio", Stanza.SUD)
				.getLabirinto();
	}
}
