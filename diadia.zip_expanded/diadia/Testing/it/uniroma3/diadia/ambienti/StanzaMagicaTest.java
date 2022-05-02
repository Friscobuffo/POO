package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	StanzaMagica stanzaMagica;
	Attrezzo attrezzo;
	private final static String NOME = "attrezzo";
	
	@Before
	public void setUp() {
		this.stanzaMagica = new StanzaMagica("Stanza Magica", 1);
		
		this.attrezzo = new Attrezzo(NOME, 1);
	}

	@Test
	public void testAddAttrezzoUnaVolta() {
		int peso = this.attrezzo.getPeso();
		String nome = this.attrezzo.getNome();
		this.stanzaMagica.addAttrezzo(attrezzo);
		this.attrezzo = this.stanzaMagica.getAttrezzo(NOME);
		assertEquals(peso, this.attrezzo.getPeso());
		assertEquals(nome, this.attrezzo.getNome());
		
	}

	@Test
	public void testAddAttrezzoDueVolte() {
		int peso = this.attrezzo.getPeso()*2;
		String nome = invertiNome(this.attrezzo.getNome());
		
		this.stanzaMagica.addAttrezzo(attrezzo);
		this.stanzaMagica.removeAttrezzo(attrezzo);
		this.stanzaMagica.addAttrezzo(attrezzo);
		
		this.attrezzo = this.stanzaMagica.getAttrezzi().iterator().next();
		
		assertEquals(peso, this.attrezzo.getPeso());
		assertEquals(nome, this.attrezzo.getNome());
		
	}
	
	private String invertiNome(String nome) {
		StringBuilder nomeInv = new StringBuilder(nome);
		nomeInv = nomeInv.reverse();
		return nomeInv.toString();
	}
}
