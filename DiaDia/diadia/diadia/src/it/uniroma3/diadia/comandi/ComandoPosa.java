package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Toglie un attrezzo dalla borsa e lo mette nella stanza corrente
 * 
 * @param attrezzo stringa con il nome dell'attrezzo da posare
 */
public class ComandoPosa extends AbstractComando{

	@Override
	public void esegui(Partita partita) {
		IO io = this.getIo();
		String attrezzo = this.getParametro();

		Borsa borsa = partita.getGiocatore().getBorsa();

		if (borsa.isEmpty()) {
			io.mostraMessaggio("La borsa e' vuota");
			return;
		}
		if (attrezzo == null) {
			io.mostraMessaggio("Che attrezzo vuoi posare?");
			return;
		}

		Attrezzo attrezzoDaPosare = borsa.removeAttrezzo(attrezzo); //null se non c'è
		if (attrezzoDaPosare == null)
			io.mostraMessaggio("L'attrezzo <"+this.getParametro()+"> non e' presente nella borsa");
		else {
			partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			io.mostraMessaggio("L'attrezzo <"+attrezzo+"> e' stato posato.");				
		}
	}
}
