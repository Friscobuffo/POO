package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoStato extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Stato del giocatore:");
		this.getIo().mostraMessaggio(partita.getGiocatore().getDescrizione());
	}
}
