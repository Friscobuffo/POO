package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import static it.uniroma3.diadia.ambienti.Direzione.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private final static String STANZA_BLOCCATA = "Stanza bloccata";
	private final static String ATTREZZO_SBLOCCANTE = "Attrezzo sbloccante";
	private final static String ATTREZZO_NON_SBLOCCANTE = "Attrezzo non sbloccante";
	private final static String STANZA_NORD = "Stanza adiacente nord";
	
	
	private Labirinto labirinto;
	private Stanza stanzaBloccata;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto(). new LabirintoBuilder()
				.addStanzaBloccata(STANZA_BLOCCATA, NORD, ATTREZZO_SBLOCCANTE)
				.addStanzaIniziale(STANZA_BLOCCATA)
				.addStanzaVincente(STANZA_NORD)
				.addAdiacenza(STANZA_BLOCCATA, STANZA_NORD, NORD)
				.addStanza("Stanza")
				.addAdiacenza(STANZA_BLOCCATA, "Stanza", EST)
				.getLabirinto();
		this.stanzaBloccata = this.labirinto.getStanzaIniziale();

	}

	@Test
	public void testStanzaBloccataSenzaAttrezzoSbloccante() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente(NORD));
	}

	@Test
	public void testStanzaBloccataConAttrezzoSbloccante() {
		stanzaBloccata.addAttrezzo(new Attrezzo(ATTREZZO_SBLOCCANTE ,0));
		Stanza stanzaVincente = this.labirinto.getStanzaVincente();
		Stanza prossimaStanza = stanzaBloccata.getStanzaAdiacente(NORD);
		assertEquals(stanzaVincente, prossimaStanza);
	}
	
	@Test
	public void testStanzaBloccataConAttrezzoNonSbloccante() {
		this.stanzaBloccata.addAttrezzo(new Attrezzo(ATTREZZO_NON_SBLOCCANTE ,0));
		Stanza prossimaStanza = this.stanzaBloccata.getStanzaAdiacente(NORD);
		assertEquals(stanzaBloccata, prossimaStanza);
	}
	
	@Test
	public void testStanzaBloccataVersoDirezioneNonBloccata() {
		Stanza prossimaStanza = stanzaBloccata.getStanzaAdiacente(EST);
		assertEquals("Stanza", prossimaStanza.getNome());
	}
}
