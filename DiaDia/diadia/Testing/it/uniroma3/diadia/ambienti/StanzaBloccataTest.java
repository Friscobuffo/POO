package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private final static String STANZA_BLOCCATA = "Stanza bloccata";
	private final static String DIREZIONE_BLOCCATA = "nord";
	private final static String ATTREZZO_SBLOCCANTE = "Attrezzo sbloccante";
	private final static String ATTREZZO_NON_SBLOCCANTE = "Attrezzo non sbloccante";
	private final static String STANZA_NORD = "Stanza adiacente nord";
	
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaBloccata(STANZA_BLOCCATA, DIREZIONE_BLOCCATA, ATTREZZO_SBLOCCANTE)
				.addStanzaIniziale(STANZA_BLOCCATA)
				.addStanzaVincente(STANZA_NORD)
				.addAdiacenza(STANZA_BLOCCATA, STANZA_NORD, DIREZIONE_BLOCCATA)
				.getLabirinto();
	}

	@Test
	public void testStanzaBloccataSenzaAttrezzoSbloccante() {
		Stanza stanzaInizialeBloccata = this.labirinto.getStanzaIniziale();
		Stanza prossimaStanza = stanzaInizialeBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA);
		assertEquals(stanzaInizialeBloccata, prossimaStanza);
	}

	@Test
	public void testStanzaBloccataConAttrezzoSbloccante() {
		Stanza stanzaInizialeBloccata = this.labirinto.getStanzaIniziale();
		stanzaInizialeBloccata.addAttrezzo(new Attrezzo(ATTREZZO_SBLOCCANTE ,0));
		Stanza stanzaVincente = this.labirinto.getStanzaVincente();
		
		Stanza prossimaStanza = stanzaInizialeBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA);
		assertEquals(stanzaVincente, prossimaStanza);
	}
	
	@Test
	public void testStanzaBloccataConAttrezzoNonSbloccante() {
		Stanza stanzaInizialeBloccata = this.labirinto.getStanzaIniziale();
		
		stanzaInizialeBloccata.addAttrezzo(new Attrezzo(ATTREZZO_NON_SBLOCCANTE ,0));
		Stanza prossimaStanza = stanzaInizialeBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA);
		assertEquals(stanzaInizialeBloccata, prossimaStanza);
	}
}