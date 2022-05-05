package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private Stanza stanza;
	private static final String NORD = "nord";
	private static final String STANZA = "stanza";
	private static final String ATTREZZO = "attrezzo di prova";
	private static final String STANZA_ADIACENTE = "stanza adiacente";

	@Before
	public void setUp() {
		this.stanza = new Stanza(STANZA);
	}

	@Test
	public void testImpostaStanzaAdiacenteSingola() {
		Stanza a = creaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertEquals(a, this.stanza.getStanzaAdiacente(NORD));
	}

	@Test
	public void testCambiaStanzaAdiacente() {
		creaEImpostaAdiacente(this.stanza, STANZA, NORD);
		Stanza nuova = creaEImpostaAdiacente(this.stanza, STANZA, NORD);
		assertEquals(nuova, this.stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testGetStanzaAdiacentePresente() {
		Stanza stanzaAdiacente = creaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente(NORD));
	}

	@Test
	public void testGetStanzaAdiacenteNonPresente() {
		assertNull(stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testGetNome() {
		assertEquals(STANZA, stanza.getNome());
	}

	@Test
	public void testGetAttrezzoPresenteNellaStanza() {
		Attrezzo a = creaEInserisciAttrezzo(ATTREZZO, stanza);
		assertEquals(a, this.stanza.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetAttrezzoNonPresenteNellaStanzaSenzaAttrezzi() {
		assertNull(this.stanza.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetAttrezzoNonPresenteNellaStanzaConAttrezzi() {
		creaEInserisciAttrezzo(ATTREZZO+1, stanza);
		assertNull(this.stanza.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoPresenteNellaStanza() {
		creaEInserisciAttrezzo(ATTREZZO, stanza);
		assertTrue(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoNonPresenteNellaStanzaSenzaAttrezzi() {
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoNonPresenteNellaStanzaConAttrezzi() {
		creaEInserisciAttrezzo("a", stanza);
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO));
	}

	@Test
	public void testRemoveAttrezzoPresenteNellaStanza() {
		Attrezzo a = creaEInserisciAttrezzo(ATTREZZO, stanza);
		assertTrue(this.stanza.removeAttrezzo(a));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresenteNellaStanza() {
		Attrezzo a = new Attrezzo(ATTREZZO, 10);
		assertFalse(this.stanza.removeAttrezzo(a));
	}

	@Test
	public void testGetDirezioni() {
		creaEImpostaAdiacente(stanza, STANZA, NORD);
		assertTrue(this.stanza.getDirezioni().contains(NORD));
	}

	@Test
	public void testGetNumeroAttrezzi() {
		assertEquals(0, this.stanza.getNumeroAttrezzi());
		creaEInserisciAttrezzo(ATTREZZO, stanza);
		assertEquals(1, this.stanza.getNumeroAttrezzi());
		
		creaEInserisciAttrezzo(ATTREZZO, stanza);
		assertEquals(1, this.stanza.getNumeroAttrezzi());
		
		creaEInserisciAttrezzo(ATTREZZO+1, stanza);
		assertEquals(2, this.stanza.getNumeroAttrezzi());
	}
	
	private Stanza creaEImpostaAdiacente(Stanza stanzaIniziale, String nomeStanza, String direzione) {
		Stanza stanza = new Stanza(nomeStanza);
		stanzaIniziale.impostaStanzaAdiacente(direzione, stanza);
		return stanza;
	}
	
	private Attrezzo creaEInserisciAttrezzo(String nome, Stanza stanza) {
		Attrezzo attrezzo = new Attrezzo(nome, 0);
		stanza.addAttrezzo(attrezzo);
		return attrezzo;
	}
}
