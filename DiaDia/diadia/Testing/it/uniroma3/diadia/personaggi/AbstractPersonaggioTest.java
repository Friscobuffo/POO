package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.fixture.Fixture;

public class AbstractPersonaggioTest {

	private FakePersonaggio fakePersonaggio;
	private Partita partita;
	private static final String NOME = "Fake Personaggio";
	private static final String PRESENTAZIONE = "Sono un personaggio finto";
	
	@Before
	public void setUp() throws Exception {
		fakePersonaggio = new FakePersonaggio(NOME, PRESENTAZIONE);
		partita = new Partita(Fixture.creaLabirintoBaseUnaStanza());
	}

	@Test
	public void testSaluta() {
		String saluto = fakePersonaggio.saluta();
		assertTrue(saluto.contains(PRESENTAZIONE));
	}
	
	@Test
	public void testAgisci() {
		String azione = fakePersonaggio.agisci(partita);
		assertEquals(FakePersonaggio.DONE, azione);
	}
	
	public static class FakePersonaggio extends AbstractPersonaggio {

		public static final String DONE = "done";
		
		public FakePersonaggio(String nome, String presentazione) {
			super(nome, presentazione);
		}

		@Override
		public String agisci(Partita partita) {
			return DONE;
		}

		@Override
		public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
			return "ricevuto";
		}
	}
}
