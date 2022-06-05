package it.uniroma3.diadia.comandi;

import org.junit.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoNonValidoTest {

	@Test
	public void testComandoNonValidoDiaDia() {
		Fixture.creaSimulazionePartitaEGioca("comando non valido", "fine");
	}
	
	@Test
	public void testComandoNonValido() {
		ComandoNonValido comandoNonValido = new ComandoNonValido();
		comandoNonValido.setIo(new IOSimulator());
		
		Partita partita = new Partita(Fixture.creaLabirintoBaseUnaStanza());
		comandoNonValido.esegui(partita);	
	}
}
