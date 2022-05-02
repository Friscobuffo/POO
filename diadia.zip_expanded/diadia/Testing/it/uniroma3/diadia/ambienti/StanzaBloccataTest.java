package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private final static String NOME = "Stanza bloccata";
	private final static String DIREZIONE_BLOCCATA = "nord";
	private final static String ATTREZZO_SBLOCCANTE = "Attrezzo sbloccante";
	
	private final static String NOMENORD = "Stanza adiacente nord";
	
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaBloccata(NOME, DIREZIONE_BLOCCATA, ATTREZZO_SBLOCCANTE)
				.addStanzaIniziale(NOME)
				.addStanza(NOMENORD)
				.addAdiacenza(NOME, NOMENORD, DIREZIONE_BLOCCATA)
				.getLabirinto();
	}

	@Test
	public void testStanzaBloccataSenzaAttrezzoSbloccante() {
		Stanza stanzaInizialeBloccata = this.labirinto.getStanzaIniziale();
		Stanza prossima = stanzaInizialeBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA);
		assertEquals(stanzaInizialeBloccata, prossima);
	}

	@Test
	public void testStanzaBloccataConAttrezzoSbloccante() {
		Stanza stanzaInizialeBloccata = this.labirinto.getStanzaIniziale();
		stanzaInizialeBloccata.addAttrezzo(new Attrezzo(ATTREZZO_SBLOCCANTE ,0));
		String prossima = stanzaInizialeBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA).getNome();
		assertEquals(NOMENORD, prossima);
	}
}
