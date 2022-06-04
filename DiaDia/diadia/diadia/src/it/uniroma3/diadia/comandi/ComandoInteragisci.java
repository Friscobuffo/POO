package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {

	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?...";
	
	@Override
	public void esegui(Partita partita) {
		IO io = this.getIo();
		
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			String messaggio = personaggio.agisci(partita);
			io.mostraMessaggio(messaggio);
		} else io.mostraMessaggio(MESSAGGIO_CON_CHI);
	}
}
