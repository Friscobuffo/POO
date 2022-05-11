package it.uniroma3.diadia.comandi;

import org.junit.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoFineTest {
	
	@Test
	public void testComandoFineDiaDia() {
		Fixture.creaSimulazionePartitaEGioca("fine");
	}
	
	@Test
	public void testComandoFine() {
		ComandoFine comandoFine = new ComandoFine();
		comandoFine.setIo(new IOSimulator());
		Partita partita = new Partita(Fixture.creaLabirintoBaseUnaStanza());
		comandoFine.esegui(partita);		
	}
}
