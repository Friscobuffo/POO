package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.fixture.Fixture;
import it.uniroma3.diadia.giocatore.Giocatore;

public class CaneTest {

	private Cane cane;
	private Partita partita;
	
	@Before
	public void setUp() throws Exception {
		this.cane = new Cane();
		Labirinto labirinto = Fixture.creaLabirintoBaseUnaStanza();
		this.partita = new Partita(labirinto);
	}

	@Test
	public void testAgisci() {
		assertEquals(Giocatore.CFU_INIZIALI, this.partita.getGiocatore().getCfu());
		cane.agisci(partita);
		assertEquals(Giocatore.CFU_INIZIALI -1, this.partita.getGiocatore().getCfu());
	}

}
