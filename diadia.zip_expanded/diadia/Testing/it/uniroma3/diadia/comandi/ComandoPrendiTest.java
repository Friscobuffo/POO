package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoPrendiTest {

	private Partita partitaNuova;
	private ComandoPrendi comandoPrendi;
	private final static String ATTREZZO_FITTIZIO = "Attrezzo fittizio";
	
	@Before
	public void setUp() {
		this.partitaNuova = new Partita(Fixture.creaLabirintoBaseUnaStanza());
		this.comandoPrendi = new ComandoPrendi();
		IO io = new IOConsole();
		this.comandoPrendi.setIo(io);
	}

	@Test
	public void testComandoPrendiSenzaParametro() {
		int numeroAttrezzi = this.partitaNuova.getStanzaCorrente().getAttrezzi().size();
		this.comandoPrendi.esegui(this.partitaNuova);
		assertEquals(numeroAttrezzi, this.partitaNuova.getStanzaCorrente().getAttrezzi().size());
	}
	
	@Test
	public void testComandoPrendiConParametroFittizio() {
		int numeroAttrezzi = this.partitaNuova.getStanzaCorrente().getAttrezzi().size();
		this.comandoPrendi.setParametro(ATTREZZO_FITTIZIO);
		this.comandoPrendi.esegui(this.partitaNuova);
		assertEquals(numeroAttrezzi, this.partitaNuova.getStanzaCorrente().getAttrezzi().size());
	}

	@Test
	public void testComandoPrendiConParametroCorretto() {
		creaAttrezzoFittizioEAggiungiloAllaStanza(ATTREZZO_FITTIZIO);
		assertTrue(this.partitaNuova.getStanzaCorrente().hasAttrezzo(ATTREZZO_FITTIZIO));
		
		this.comandoPrendi.setParametro(ATTREZZO_FITTIZIO);
		this.comandoPrendi.esegui(partitaNuova);
		
		assertTrue(this.partitaNuova.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_FITTIZIO));
		assertFalse(this.partitaNuova.getStanzaCorrente().hasAttrezzo(ATTREZZO_FITTIZIO));
	}
	
	private Attrezzo creaAttrezzoFittizioEAggiungiloAllaStanza(String nomeAttrezzo) {
		Attrezzo attrezzoFittizio = new Attrezzo(nomeAttrezzo, 0);
		this.partitaNuova.getStanzaCorrente().addAttrezzo(attrezzoFittizio);
		return attrezzoFittizio;
	}
}
