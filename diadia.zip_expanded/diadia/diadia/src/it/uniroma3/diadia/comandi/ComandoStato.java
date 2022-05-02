package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoStato extends BaseComando {

	private final static String NOME = "ComandoStato";
	
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Stato del giocatore:");
		this.getIo().mostraMessaggio(partita.getGiocatore().getDescrizione());
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
