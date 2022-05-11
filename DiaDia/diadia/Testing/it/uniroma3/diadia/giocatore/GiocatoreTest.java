package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {

	Giocatore giocatore;
	
	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
	}

	@Test
	public void testGetCfu() {
		assertEquals(Giocatore.CFU_INIZIALI, this.giocatore.getCfu());
	}

	@Test
	public void testSetCfu() {
		int cfu = this.giocatore.getCfu();
		cfu += 1;
		this.giocatore.setCfu(cfu);
		assertEquals(cfu, this.giocatore.getCfu());
	}

	@Test
	public void testGetBorsa() {
		assertNotNull(this.giocatore.getBorsa());
	}

}
