package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends Comando {

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Guardo nella stanza:");
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
}
