package it.uniroma3.diadia.comandi;

import org.junit.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoGuardaTest {

	@Test
	public void testComandoGuardaDiaDia() {
		Fixture.creaSimulazionePartitaEGioca("guarda", "fine");
	}
	
	@Test
	public void testComandoGuarda() {
		ComandoGuarda comandoGuarda = new ComandoGuarda();
		comandoGuarda.setIo(new IOSimulator());
		Partita partita = new Partita(Fixture.creaLabirintoBaseUnaStanza());
		comandoGuarda.esegui(partita);		
	}
}
