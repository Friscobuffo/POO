package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private Stanza stanza;
	private static final String NORD = "nord";
	private static final String NOME = "stanza di prova";
	private static final String NOMEATTREZZO = "attrezzo di prova";

	@Before
	public void setUp() {
		this.stanza = new Stanza(NOME);
	}

	@Test
	public void testImpostaStanzaAdiacenteSingola() {
		Stanza a = creaEImpostaAdiacente(this.stanza, "Stanza Adiacente", NORD);
		assertEquals(a, this.stanza.getStanzaAdiacente(NORD));
	}

	@Test
	public void testCambiaStanzaAdiacente() {
		creaEImpostaAdiacente(this.stanza, NOME, NORD);
		Stanza nuova = creaEImpostaAdiacente(stanza, NOME, NORD);
		assertEquals(nuova, this.stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testGetStanzaAdiacentePresente() {
		Stanza stanzaAdiacente = creaEImpostaAdiacente(stanza, "Stanza Adiacente", NORD);
		assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente(NORD));
	}

	@Test
	public void testGetStanzaAdiacenteNonPresente() {
		assertNull(stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testGetNome() {
		assertEquals(NOME, stanza.getNome());
	}

	@Test
	public void testGetAttrezzi() {
		Attrezzo a0 = creaEInserisciAttrezzo(0, stanza);
		Attrezzo a1 = creaEInserisciAttrezzo(1, stanza);
		Attrezzo a2 = creaEInserisciAttrezzo(2, stanza);
		assertTrue(this.stanza.getAttrezzi().contains(a0));
		assertTrue(this.stanza.getAttrezzi().contains(a1));
		assertTrue(this.stanza.getAttrezzi().contains(a2));
	}

	@Test
	public void testAddAttrezzo() {
		Attrezzo a = creaEInserisciAttrezzo(0, stanza);
		assertEquals(a, this.stanza.getAttrezzo(NOMEATTREZZO+0));
	}
	
	@Test
	public void testHasAttrezzoPresenteNellaStanza() {
		creaEInserisciAttrezzo(0, stanza);
		assertTrue(this.stanza.hasAttrezzo(NOMEATTREZZO+0));
	}
	
	@Test
	public void testHasAttrezzoNonPresenteNellaStanza() {
		assertFalse(this.stanza.hasAttrezzo("attrezzo non presente"));
	}

	@Test
	public void testGetAttrezzoPresenteNellaStanza() {
		Attrezzo a = creaEInserisciAttrezzo(0, stanza);
		assertEquals(a, this.stanza.getAttrezzo(NOMEATTREZZO+0));
	}
	
	@Test
	public void testGetAttrezzoNonPresenteNellaStanza() {
		assertNull(this.stanza.getAttrezzo(NOMEATTREZZO));
	}
	
	@Test
	public void testRemoveAttrezzoPresenteNellaStanza() {
		Attrezzo a = creaEInserisciAttrezzo(0, stanza);
		assertTrue(this.stanza.removeAttrezzo(a));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresenteNellaStanza() {
		Attrezzo a = new Attrezzo(NOMEATTREZZO, 10);
		assertFalse(this.stanza.removeAttrezzo(a));
	}

	@Test
	public void testGetDirezioni() {
		creaEImpostaAdiacente(stanza, NOME, NORD);
		assertTrue(this.stanza.getDirezioni().contains(NORD));
	}

	@Test
	public void testGetNumeroAttrezzi() {
		assertEquals(0, this.stanza.getNumeroAttrezzi());
		creaEInserisciAttrezzo(0, stanza);
		assertEquals(1, this.stanza.getNumeroAttrezzi());
	}
	
	private Stanza creaEImpostaAdiacente(Stanza stanzaIniziale, String nomeStanza, String direzione) {
		Stanza stanza = new Stanza(nomeStanza);
		stanzaIniziale.impostaStanzaAdiacente(direzione, stanza);
		return stanza;
	}
	
	private Attrezzo creaEInserisciAttrezzo(int i, Stanza stanza) {
		Attrezzo attrezzo = new Attrezzo(NOMEATTREZZO+i, 10);
		stanza.addAttrezzo(attrezzo);
		return attrezzo;
	}
}
