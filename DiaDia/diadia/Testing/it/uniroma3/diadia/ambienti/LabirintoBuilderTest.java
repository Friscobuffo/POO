package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoBuilderTest {

	private LabirintoBuilder builder;
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.builder = new LabirintoBuilder();
		this.labirinto = null;
	}

	@Test
	public void testAddStanzaIniziale() {
		this.builder.addStanzaIniziale("Stanza Iniziale");
		this.labirinto = this.builder.getLabirinto();
		assertEquals("Stanza Iniziale", this.labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testAddStanzaVincente() {
		this.builder.addStanzaVincente("Stanza Vincente");
		this.labirinto = this.builder.getLabirinto();
		assertEquals("Stanza Vincente", this.labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testAddStanzaSingola() {
		this.builder.addStanza("Stanza");
		assertTrue(this.builder.getStanze().containsKey("Stanza"));
	}

	@Test
	public void testAddDueStanze() {
		this.builder.addStanza("Stanza1");
		this.builder.addStanza("Stanza2");
		assertTrue(this.builder.getStanze().containsKey("Stanza1"));
		assertTrue(this.builder.getStanze().containsKey("Stanza2"));

	}
	
	@Test
	public void testAddAttrezzo() {
		this.builder.addStanza("Stanza");
		this.builder.addAttrezzo("Attrezzo", 0);
		
		
		assertTrue(this.builder.getStanze().get("Stanza").hasAttrezzo("Attrezzo"));
	}

	@Test
	public void testAddAdiacenza() {
		this.builder.addStanza("Stanza1");
		this.builder.addStanza("Stanza2");
		this.builder.addAdiacenza("Stanza1", "Stanza2", "Nord");
		assertEquals("Nord", this.builder.getStanze().get("Stanza1").getDirezioni().get(0));
	}
}
