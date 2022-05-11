package it.uniroma3.diadia.comandi;

import org.junit.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoAiutoTest {

	@Test
	public void testComandoAiutoDiaDia() {
		Fixture.creaSimulazionePartitaEGioca("aiuto", "fine");
	}
	
	@Test
	public void testComandoAiuto() {
		ComandoAiuto comandoAiuto = new ComandoAiuto();
		comandoAiuto.setIo(new IOSimulator());
		Partita partita = new Partita(Fixture.creaLabirintoBaseUnaStanza());
		comandoAiuto.esegui(partita);		
	}
}
