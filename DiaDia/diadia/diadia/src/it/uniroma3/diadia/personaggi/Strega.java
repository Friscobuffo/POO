package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class Strega extends AbstractPersonaggio {

	public final static String PRESENTAZIONE = "Sono una strega.";
	public final static String CAMBIATO_STANZA =
			"La strega ha fatto una magia:\n" +
			"Sei stato teletrasportato in un'altra stanza.";
	
	public Strega(String nome) {
		super(nome, PRESENTAZIONE);
	}

	@Override
	public String agisci(Partita partita) {
		Stanza prossimaStanza = null;
		
		if(this.haSalutato()) {
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacenteConPiuAttrezzi();
		}
		else {
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacenteConMenoAttrezzi();
		}
		partita.setStanzaCorrente(prossimaStanza);
		return CAMBIATO_STANZA;
	}
}