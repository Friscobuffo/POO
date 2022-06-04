package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.fixture.Fixture;

public class MagoTest {

	private Mago mago;
	private Partita partita;
	private final static String NOME_MAGO = "Mago";
	private final static String NOME_ATTREZZO = "Attrezzo";
	
	@Before
	public void setUp() throws Exception {
		this.mago = new Mago(NOME_MAGO, new Attrezzo (NOME_ATTREZZO, 0));
		
		Labirinto labirinto = Fixture.creaLabirintoBaseUnaStanza();
		this.partita = new Partita(labirinto);
	}

	@Test
	public void testAgisci() {
		assertEquals(0, this.partita.getStanzaCorrente().getNumeroAttrezzi());
		mago.agisci(partita);
		assertNotNull(this.partita.getStanzaCorrente().getAttrezzo(NOME_ATTREZZO));
	}
	
	@Test
	public void testRiceviRegalo() {
		this.mago.riceviRegalo(new Attrezzo(NOME_ATTREZZO, 10), partita);
		assertEquals(5, this.partita.getStanzaCorrente().getAttrezzo(NOME_ATTREZZO).getPeso());
	}
}
