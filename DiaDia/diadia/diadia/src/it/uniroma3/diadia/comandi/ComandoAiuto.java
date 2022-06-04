package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */
public class ComandoAiuto extends AbstractComando {

	private static final String[] elencoComandi = {
			"vai [direzione]: scegli la prossima stanza",
			"aiuto: mostra i comandi disponibili",
			"prendi [attrezzo]: prendi un attrezzo presente nella stanza",
			"posa [attrezzo]: posa un attrezzo dalla borsa",
			"guarda: guarda nella stanza corrente",
			"stato: mostra informazioni sulla partita",
			"saluta: saluta il personaggio se presente nella stanza",
			"interagisci: interagisci con il personaggio nella stanza",
			"fine: concludi la partita"};
	
	@Override
	public void esegui(Partita partita) {
		for(String comando : elencoComandi) 
			this.getIo().mostraMessaggio(comando + " ");
	}
}
