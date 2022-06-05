package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import static it.uniroma3.diadia.ambienti.Direzione.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class LabirintoBuilderTest {

	private LabirintoBuilder builder;
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
		this.builder = labirinto. new LabirintoBuilder();
	}

	@Test
	public void testAddStanzaIniziale() {
		this.builder.addStanzaIniziale("Stanza Iniziale");
		assertEquals("Stanza Iniziale", this.labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testAddStanzaVincente() {
		this.builder.addStanzaVincente("Stanza Vincente");
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
		
		assertEquals(2, this.builder.getStanze().size());
		assertTrue(this.builder.getStanze().containsKey("Stanza1"));
		assertTrue(this.builder.getStanze().containsKey("Stanza2"));
	}
	
	@Test
	public void testAddDueStanzeUguali() {
		this.builder.addStanza("Stanza");
		this.builder.addStanza("Stanza");
		
		assertEquals(1, this.builder.getStanze().size());
		assertTrue(this.builder.getStanze().containsKey("Stanza"));
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
		this.builder.addAdiacenza("Stanza1", "Stanza2", NORD);
		assertTrue(this.builder.getStanze().get("Stanza1").getDirezioni().contains(NORD));
		assertTrue(this.builder.getStanze().get("Stanza2").getDirezioni().contains(SUD));

	}
}
