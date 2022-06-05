package it.uniroma3.diadia.comandi;

import org.junit.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoStatoTest {

	@Test
	public void testComandoStatoDiaDia() {
		String[] istruzioni = {"stato", "fine"};
		Fixture.creaSimulazionePartitaEGioca(istruzioni);
	}
	
	@Test
	public void testComandoStato() {
		ComandoStato comandoStato = new ComandoStato();
		comandoStato.setIo(new IOSimulator());
		Partita partita = new Partita(Fixture.creaLabirintoBaseUnaStanza());
		comandoStato.esegui(partita);		
	}
}
