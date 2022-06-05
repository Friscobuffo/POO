package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.fixture.Fixture;

public class StregaTest {

	private Strega strega;
	private Partita partita;
	private final static String NOME_STREGA = "Strega";
	private final static String ATTREZZO = "attrezzo";
	
	@Before
	public void setUp() {
		this.strega = new Strega(NOME_STREGA);
		Labirinto labirinto = Fixture.creaStanzaQuattroStanzeAdiacentiEAggiungiAttrezzi();
		this.partita = new Partita(labirinto);
	}
	
	@Test
	public void testAgisciStregaNonSalutata() {
		this.strega.agisci(partita);
		assertEquals("Stanza 0 attrezzi", this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testAgisciStregaSalutata() {
		this.strega.saluta();
		this.strega.agisci(partita);
		assertEquals("Stanza 2 attrezzi", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testRiceviRegalo() {
		this.strega.riceviRegalo(new Attrezzo(ATTREZZO, 1), partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(ATTREZZO));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO));
	}
}
