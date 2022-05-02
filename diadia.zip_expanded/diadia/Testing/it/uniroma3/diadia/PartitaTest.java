package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.fixture.Fixture;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {

	private Partita partita;
	
	@Before
	public void setUp() {
		
		this.partita = new Partita(Fixture.creaLabirintoBaseDueStanze());
	}

	@Test
	public void testVintaPartitaNonVinta() {
		assertFalse(this.partita.vinta());
	}

	@Test
	public void testVintaPartitaVinta() {
		Stanza s = this.partita.getStanzaVincente();
		this.partita.setStanzaCorrente(s);
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testIsFinitaPartitaNonFinita() {
		assertFalse(this.partita.isFinita());
		}
	
	@Test
	public void testIsFinitaPartitaFinitaZeroCfu() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	
	}

	@Test
	public void testSetFinitaF() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

	@Test
	public void testGetCfu() {
		assertEquals(Giocatore.CFU_INIZIALI, this.partita.getGiocatore().getCfu());
	}

	@Test
	public void testSetCfu() {
		int cfu = this.partita.getGiocatore().getCfu();
		cfu +=1;
		this.partita.getGiocatore().setCfu(cfu);
		assertEquals(cfu, this.partita.getGiocatore().getCfu());
	}
}
