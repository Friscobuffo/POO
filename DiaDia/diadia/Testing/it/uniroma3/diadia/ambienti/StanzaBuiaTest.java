package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;
	private final static String NOME = "Stanza buia";
	private final static String ATTREZZO_LUCE = "Attrezzo luce";
	private final static String ATTREZZO_SBAGLIATO = "Attrezzo sbagliato";
	private Attrezzo attrezzoLuce;
	
	@Before
	public void setUp() {
		this.stanzaBuia = new StanzaBuia(NOME, ATTREZZO_LUCE);
		this.attrezzoLuce = new Attrezzo(ATTREZZO_LUCE, 0);
	}

	@Test
	public void testGetDescrizioneSenzaAttrezzoLuce() {
		String descrizione = this.stanzaBuia.getDescrizione();
		assertEquals(StanzaBuia.BUIO, descrizione);
		
		String toString = this.stanzaBuia.toString();
		assertFalse(descrizione.equals(toString));
	}
	
	@Test
	public void testGetDescrizioneConAttrezzoLuce() {
		this.stanzaBuia.addAttrezzo(this.attrezzoLuce);
		String descrizione = this.stanzaBuia.getDescrizione();
		String toString = this.stanzaBuia.toString();
		assertEquals(toString, descrizione);
	}
	
	@Test
	public void testGetDescrizioneConAttrezzoSbagliato() {
		this.stanzaBuia.addAttrezzo(new Attrezzo(ATTREZZO_SBAGLIATO, 0));
		String descrizione = this.stanzaBuia.getDescrizione();
		assertEquals(StanzaBuia.BUIO, descrizione);
	}
}
