package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static it.uniroma3.diadia.ambienti.Direzione.*;

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
				.addAdiacenza("Atrio", "Biblioteca", NORD)
				.addAdiacenza("Atrio", "Aula N11", EST)
				.addAdiacenza("Atrio", "Aula N10", SUD)
				.addAdiacenza("Atrio", "Laboratorio Campus", OVEST)
				.addAdiacenza("Aula N11", "Laboratorio Campus", EST)
				.addAdiacenza("Aula N11", "Atrio", OVEST)
				.addAdiacenza("Aula N10", "Atrio", NORD)
				.addAdiacenza("Aula N10", "Aula N11", EST)
				.addAdiacenza("Aula N10", "Laboratorio Campus", OVEST)
				.addAdiacenza("Laboratorio Campus", "Atrio", EST)
				.addAdiacenza("Laboratorio Campus", "Aula N11", OVEST)
				.addAdiacenza("Biblioteca", "Atrio", SUD)
				.getLabirinto();
	}
}
