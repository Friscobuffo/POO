package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Toglie un attrezzo dalla stanza corrente e lo mette nella borsa
 * 
 * @param attrezzo stringa con il nome dell'attrezzo da prendere
 */
public class ComandoPrendi extends BaseComando {

	private final static String NOME = "ComandoPrendi";
	
	@Override
	public void esegui(Partita partita) {
		IO io = this.getIo();
		String attrezzo = this.getParametro();
		
		if (attrezzo==null) {
			io.mostraMessaggio("Selezionare un attrezzo da prendere.");
			return;
		}

		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(attrezzo);
		if (a==null) io.mostraMessaggio("L'attrezzo "+attrezzo+" non e' presente nella stanza.");
		else
			if (partita.getGiocatore().getBorsa().addAttrezzo(a)) {
				io.mostraMessaggio("L'attrezzo "+attrezzo+" e' stato preso.");
				partita.getStanzaCorrente().removeAttrezzo(a);
			}
			else io.mostraMessaggio("La borsa è piena.");
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
}
