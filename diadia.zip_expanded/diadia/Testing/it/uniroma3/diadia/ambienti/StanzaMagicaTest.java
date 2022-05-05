package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzo;
	private final static String ATTREZZO = "attrezzo";
	private final static String ATTREZZO_INVERTITO = "ozzertta";
	
	@Before
	public void setUp() {
		this.stanzaMagica = new StanzaMagica("Stanza Magica", 1);
		this.attrezzo = new Attrezzo(ATTREZZO, 1);
	}

	@Test
	public void testAddAttrezzoUnaVolta() {		
		this.stanzaMagica.addAttrezzo(attrezzo);
		
		assertEquals(1, this.attrezzo.getPeso());
		assertEquals(ATTREZZO, this.attrezzo.getNome());
		
	}

	@Test
	public void testAddAttrezzoDueVolte() {
		this.stanzaMagica.addAttrezzo(attrezzo);
		this.stanzaMagica.removeAttrezzo(attrezzo);
		this.attrezzo = this.stanzaMagica.addAttrezzo(attrezzo);
		
		assertEquals(2, this.attrezzo.getPeso());
		assertEquals(ATTREZZO_INVERTITO, this.attrezzo.getNome());
		
	}
}
