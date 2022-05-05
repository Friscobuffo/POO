package it.uniroma3.diadia;

import java.util.List;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.fixture.Fixture;

public class DiaDiaSimulator {

	@Test
	public void testPartitaCompleta() {
		Labirinto labirinto = Fixture.creaLabirintoCompleto();
		List<String> istruzioni = Fixture.istruzioniPartitaCompleta();
		
		Fixture.creaSimulazionePartitaEGioca(istruzioni, labirinto);
	}
}
