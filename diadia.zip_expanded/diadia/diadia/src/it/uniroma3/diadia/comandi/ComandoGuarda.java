package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends BaseComando {

	private final static String NOME = "ComandoGuarda";
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Guardo nella stanza:");
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
