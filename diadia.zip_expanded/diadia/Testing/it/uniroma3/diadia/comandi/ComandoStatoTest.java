package it.uniroma3.diadia.comandi;

import org.junit.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoStatoTest {

	@Test
	public void testComandoStatoDiaDia() {
		String[] istruzioni = {"stato", "fine"};
		Labirinto labirinto = Fixture.creaLabirintoBaseUnaStanza();
		Fixture.creaSimulazionePartitaEGioca(istruzioni, labirinto);
	}
	
	@Test
	public void testComandoStato() {
		ComandoStato comandoStato = new ComandoStato();
		comandoStato.setIo(new IOSimulator());
		Partita partita = new Partita(Fixture.creaLabirintoBaseUnaStanza());
		comandoStato.esegui(partita);		
	}
}
