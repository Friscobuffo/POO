package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends Comando{

private static final String SALUTA_NESSUNO = "Non c'e' nessuno da salutare...";
	
	@Override
	public void esegui(Partita partita) {
		IO io = this.getIo();
		
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		
		if (personaggio!=null) {
			io.mostraMessaggio(personaggio.saluta());
		}
		else io.mostraMessaggio(SALUTA_NESSUNO);
	}

}
