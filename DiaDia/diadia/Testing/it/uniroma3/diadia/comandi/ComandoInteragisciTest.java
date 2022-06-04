package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.fixture.Fixture;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.AbstractPersonaggioTest;

public class ComandoInteragisciTest {

	private Partita partita;
	private ComandoInteragisci comandoInteragisci;
	private AbstractPersonaggio personaggio;
	private IOSimulator io;
	private final static String NOME_PERSONAGGIO = "Personaggio";
	private final static String PRESENTAZIONE = "Presentazione";
	
	@Before
	public void setUp() throws Exception {
		personaggio = new AbstractPersonaggioTest.FakePersonaggio(NOME_PERSONAGGIO, PRESENTAZIONE);
		
		this.partita = new Partita(Fixture.creaLabirintoBaseUnaStanza());
		this.partita.getStanzaCorrente().setPersonaggio(personaggio);
		
		this.comandoInteragisci = new ComandoInteragisci();
		this.io = new IOSimulator();
		this.comandoInteragisci.setIo(io);
	}

	@Test
	public void testEsegui() {
		this.comandoInteragisci.esegui(partita);
		assertEquals("done", this.io.getMessaggiProdotti().get(0));
	}

}
