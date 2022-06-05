package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import static it.uniroma3.diadia.ambienti.Direzione.*;

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
		Stanza adiacente = new Stanza(STANZA_ADIACENTE);
		stanza.impostaStanzaAdiacente(NORD, adiacente);
		assertEquals(adiacente, this.stanza.getStanzaAdiacente(NORD));
	}

	@Test
	public void testCambiaStanzaAdiacente() {
		Stanza adiacente = new Stanza(STANZA_ADIACENTE);
		stanza.impostaStanzaAdiacente(NORD, adiacente);
		
		Stanza nuova = new Stanza(STANZA_ADIACENTE+" nuova");
		stanza.impostaStanzaAdiacente(NORD, nuova);
		assertEquals(nuova, this.stanza.getStanzaAdiacente(NORD));
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
	public void testGetAttrezzoPresenteNellaStanza() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 0);
		stanza.addAttrezzo(attrezzo);
		assertEquals(attrezzo, this.stanza.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetAttrezzoNonPresenteNellaStanzaSenzaAttrezzi() {
		assertNull(this.stanza.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetAttrezzoNonPresenteNellaStanzaConAttrezzi() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 0);
		this.stanza.addAttrezzo(attrezzo);
		assertNull(this.stanza.getAttrezzo(ATTREZZO+" non presente"));
	}
	
	@Test
	public void testHasAttrezzoPresenteNellaStanza() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 0);
		stanza.addAttrezzo(attrezzo);
		assertTrue(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoNonPresenteNellaStanzaSenzaAttrezzi() {
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoNonPresenteNellaStanzaConAttrezzi() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 0);
		stanza.addAttrezzo(attrezzo);
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO+" non presente"));
	}

	@Test
	public void testRemoveAttrezzoPresenteNellaStanza() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 0);
		stanza.addAttrezzo(attrezzo);
		assertTrue(this.stanza.removeAttrezzo(attrezzo));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresenteNellaStanza() {
		Attrezzo a = new Attrezzo(ATTREZZO+" non presente", 10);
		assertFalse(this.stanza.removeAttrezzo(a));
	}

	@Test
	public void testGetDirezioni() {
		Stanza adiacente = new Stanza(STANZA_ADIACENTE);
		stanza.impostaStanzaAdiacente(NORD, adiacente);
		
		assertTrue(this.stanza.getDirezioni().contains(NORD));
	}

	@Test
	public void testGetNumeroAttrezzi() {
		assertEquals(0, this.stanza.getNumeroAttrezzi());

		stanza.addAttrezzo(new Attrezzo(ATTREZZO, 0));
		assertEquals(1, this.stanza.getNumeroAttrezzi());
		
		stanza.addAttrezzo(new Attrezzo(ATTREZZO, 0));
		assertEquals(1, this.stanza.getNumeroAttrezzi());
		
		stanza.addAttrezzo(new Attrezzo(ATTREZZO+"1", 0));
		assertEquals(2, this.stanza.getNumeroAttrezzi());
	}
	
	@Test
	public void testGetStanzaAdiacenteConPiuAttrezzi() {
		Stanza stanza = Fixture.creaStanzaQuattroStanzeAdiacentiEAggiungiAttrezzi().getStanzaIniziale();
		Stanza stanzaConPiuAttrezzi = stanza.getStanzaAdiacenteConPiuAttrezzi();
		assertEquals("Stanza 2 attrezzi", stanzaConPiuAttrezzi.getNome());
	}
	
	@Test
	public void testGetStanzaAdiacenteConMenoAttrezzi() {
		Stanza stanza = Fixture.creaStanzaQuattroStanzeAdiacentiEAggiungiAttrezzi().getStanzaIniziale();
		Stanza stanzaConMenoAttrezzi = stanza.getStanzaAdiacenteConMenoAttrezzi();
		assertEquals("Stanza 0 attrezzi", stanzaConMenoAttrezzi.getNome());
	}	
}
