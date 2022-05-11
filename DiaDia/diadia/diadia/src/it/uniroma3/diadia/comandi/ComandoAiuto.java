package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;


/**
 * Stampa informazioni di aiuto.
 */
public class ComandoAiuto extends BaseComando {

	private static final String[] elencoComandi = {"vai", "aiuto", "prendi",
			"posa", "guarda", "stato", "fine"};
	private static final String NOME = "ComandoAiuto";
	
	@Override
	public void esegui(Partita partita) {
		for(String comando : elencoComandi) 
			this.getIo().mostraMessaggio(comando + " ");
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
