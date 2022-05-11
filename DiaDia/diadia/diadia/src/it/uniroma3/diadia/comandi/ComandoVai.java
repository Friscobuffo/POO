package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */

public class ComandoVai extends BaseComando{
	
	private final static String NOME = "ComandoVai";
	@Override
	public void esegui (Partita partita) {
		String direzione = this.getParametro();
		IO io = this.getIo();
		
		if (direzione == null) {
			io.mostraMessaggio("Dove vuoi andare ?");
			return;
		}
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			if (stanzaCorrente != prossimaStanza) { //direzione non bloccata di stanza bloccata
				partita.setStanzaCorrente(prossimaStanza);
				int cfu = partita.getGiocatore().getCfu();
				partita.getGiocatore().setCfu(--cfu);
			}
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
}
