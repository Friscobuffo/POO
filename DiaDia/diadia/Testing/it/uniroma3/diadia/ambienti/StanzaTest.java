package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.fixture.Fixture;

public class StanzaTest {
	private Stanza stanza;
	private static final String NOME = "Stanza";
	private static final String ATTREZZO = "attrezzo di prova";
	private static final String STANZA_ADIACENTE = "stanza adiacente";

	@Before
	public void setUp() {
		this.stanza = new Stanza(NOME);
	}

	@Test
	public void testImpostaStanzaAdiacenteSingola() {
		Stanza a = Fixture.creaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, Stanza.NORD);
		assertEquals(a, this.stanza.getStanzaAdiacente(Stanza.NORD));
	}

	@Test
	public void testCambiaStanzaAdiacente() {
		Fixture.creaEImpostaAdiacente(this.stanza, NOME, Stanza.NORD);
		Stanza nuova = Fixture.creaEImpostaAdiacente(this.stanza, NOME, Stanza.NORD);
		assertEquals(nuova, this.stanza.getStanzaAdiacente(Stanza.NORD));
	}
	
	@Test
	public void testGetStanzaAdiacentePresente() {
		Stanza stanzaAdiacente = Fixture.creaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, Stanza.NORD);
		assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente(Stanza.NORD));
	}

	@Test
	public void testGetStanzaAdiacenteNonPresente() {
		assertNull(stanza.getStanzaAdiacente(Stanza.NORD));
	}
	
	@Test
	public void testGetNome() {
		assertEquals(NOME, stanza.getNome());
	}

	@Test
	public void testGetAttrezzoPresenteNellaStanza() {
		Attrezzo a = Fixture.creaEInserisciAttrezzoNellaStanza(ATTREZZO, stanza);
		assertEquals(a, this.stanza.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetAttrezzoNonPresenteNellaStanzaSenzaAttrezzi() {
		assertNull(this.stanza.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetAttrezzoNonPresenteNellaStanzaConAttrezzi() {
		Fixture.creaEInserisciAttrezzoNellaStanza(ATTREZZO+1, stanza);
		assertNull(this.stanza.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoPresenteNellaStanza() {
		Fixture.creaEInserisciAttrezzoNellaStanza(ATTREZZO, stanza);
		assertTrue(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoNonPresenteNellaStanzaSenzaAttrezzi() {
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoNonPresenteNellaStanzaConAttrezzi() {
		Fixture.creaEInserisciAttrezzoNellaStanza("a", stanza);
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO));
	}

	@Test
	public void testRemoveAttrezzoPresenteNellaStanza() {
		Attrezzo a = Fixture.creaEInserisciAttrezzoNellaStanza(ATTREZZO, stanza);
		assertTrue(this.stanza.removeAttrezzo(a));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresenteNellaStanza() {
		Attrezzo a = new Attrezzo(ATTREZZO, 10);
		assertFalse(this.stanza.removeAttrezzo(a));
	}

	@Test
	public void testGetDirezioni() {
		Fixture.creaEImpostaAdiacente(stanza, NOME, Stanza.NORD);
		assertTrue(this.stanza.getDirezioni().contains(Stanza.NORD));
	}

	@Test
	public void testGetNumeroAttrezzi() {
		assertEquals(0, this.stanza.getNumeroAttrezzi());
		Fixture.creaEInserisciAttrezzoNellaStanza(ATTREZZO, stanza);
		assertEquals(1, this.stanza.getNumeroAttrezzi());
		
		Fixture.creaEInserisciAttrezzoNellaStanza(ATTREZZO, stanza);
		assertEquals(1, this.stanza.getNumeroAttrezzi());
		
		Fixture.creaEInserisciAttrezzoNellaStanza(ATTREZZO+1, stanza);
		assertEquals(2, this.stanza.getNumeroAttrezzi());
	}
	
	@Test
	public void testGetStanzaAdiacenteConPiuAttrezzi() {
		Stanza stanza = Fixture.creaStanzaQuattroStanzeAdiacentiEAggiungiAttrezzi();
		Stanza stanzaConPiuAttrezzi = stanza.getStanzaAdiacenteConPiuAttrezzi();
		assertEquals("Stanza 2 attrezzi", stanzaConPiuAttrezzi.getNome());
	}
	
	@Test
	public void testGetStanzaAdiacenteConMenoAttrezzi() {
		Stanza stanza = Fixture.creaStanzaQuattroStanzeAdiacentiEAggiungiAttrezzi();
		Stanza stanzaConMenoAttrezzi = stanza.getStanzaAdiacenteConMenoAttrezzi();
		assertEquals("Stanza 0 attrezzi", stanzaConMenoAttrezzi.getNome());
	}	
}
