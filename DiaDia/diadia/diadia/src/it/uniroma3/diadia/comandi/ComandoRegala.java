package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		IO io = this.getIo();
		String nomeAttrezzo = this.getParametro();

		if (nomeAttrezzo==null) {
			io.mostraMessaggio("Selezionare un attrezzo da regalare.");
			return;
		}

		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (attrezzo==null) io.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" non e' presente nella borsa.");
		else {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita));
		}
	}

}
