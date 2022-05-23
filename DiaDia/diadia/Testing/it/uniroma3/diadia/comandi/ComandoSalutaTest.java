package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.fixture.Fixture;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.FakePersonaggio;

public class ComandoSalutaTest {

	private Partita partita;
	private ComandoSaluta comandoSaluta;
	private AbstractPersonaggio personaggio;
	private IOSimulator io;
	private final static String NOME_PERSONAGGIO = "Personaggio";
	private final static String PRESENTAZIONE = "Presentazione";
	
	@Before
	public void setUp() throws Exception {
		personaggio = new FakePersonaggio(NOME_PERSONAGGIO, PRESENTAZIONE);
		
		this.partita = new Partita(Fixture.creaLabirintoBaseUnaStanza());
		this.partita.getStanzaCorrente().setPersonaggio(personaggio);
		
		this.comandoSaluta = new ComandoSaluta();
		this.io = new IOSimulator();
		this.comandoSaluta.setIo(io);
	}

	@Test
	public void testEsegui() {
		assertFalse(personaggio.haSalutato());
		
		//saluta prima volta
		this.comandoSaluta.esegui(partita);
		assertTrue(personaggio.haSalutato());
		assertEquals(salutoPrimaVolta(), io.getMessaggiProdotti().get(0));
		
		//saluta seconda volta
		this.comandoSaluta.esegui(partita);
		assertEquals(salutoSecondaVolta(), io.getMessaggiProdotti().get(1));
		
	}
	
	private String salutoPrimaVolta() {
		return "Ciao, io sono " + NOME_PERSONAGGIO + ". " + PRESENTAZIONE;
	}
	
	private String salutoSecondaVolta() {
		return "Ciao, io sono " + NOME_PERSONAGGIO + ". " + "Ci siamo gia' presentati!";
	}
}
