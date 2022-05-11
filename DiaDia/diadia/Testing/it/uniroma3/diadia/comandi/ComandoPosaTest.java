package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoPosaTest {
	
	private Partita partitaNuova;
	private ComandoPosa comandoPosa;
	private final static String ATTREZZO_FITTIZIO = "Attrezzo fittizio";

	@Before
	public void setUp() {
		this.partitaNuova = new Partita(Fixture.creaLabirintoBaseUnaStanza());
		this.comandoPosa = new ComandoPosa();
		IO io = new IOConsole();
		this.comandoPosa.setIo(io);
	}

	@Test
	public void testComandoPosaSenzaParametroBorsaVuota() {
		int numeroAttrezzi = this.partitaNuova.getGiocatore().getBorsa().getAttrezzi().size();
		
		this.comandoPosa.esegui(this.partitaNuova);
		
		assertTrue(this.partitaNuova.getGiocatore().getBorsa().isEmpty());
		assertEquals(numeroAttrezzi, this.partitaNuova.getGiocatore().getBorsa().getAttrezzi().size());
	}
	
	@Test
	public void testComandoPosaConParametroBorsaVuota() {
		int numeroAttrezzi = this.partitaNuova.getGiocatore().getBorsa().getAttrezzi().size();
		
		this.comandoPosa.setParametro(ATTREZZO_FITTIZIO);
		this.comandoPosa.esegui(this.partitaNuova);
		
		assertTrue(this.partitaNuova.getGiocatore().getBorsa().isEmpty());
		assertEquals(numeroAttrezzi, this.partitaNuova.getGiocatore().getBorsa().getAttrezzi().size());
	}
	
	@Test
	public void testComandoPosaSenzaParametroBorsaNonVuota() {
		creaAttrezzoFittizioEMettiInBorsa();
		assertTrue(this.partitaNuova.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_FITTIZIO));
		
		this.comandoPosa.esegui(partitaNuova);
		
		assertTrue(this.partitaNuova.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_FITTIZIO));
		assertFalse(this.partitaNuova.getStanzaCorrente().hasAttrezzo(ATTREZZO_FITTIZIO));
	}

	@Test
	public void testComandoPosaConAttrezzo() {
		creaAttrezzoFittizioEMettiInBorsa();
		assertTrue(this.partitaNuova.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_FITTIZIO));
		
		this.comandoPosa.setParametro(ATTREZZO_FITTIZIO);
		this.comandoPosa.esegui(this.partitaNuova);
		
		assertFalse(this.partitaNuova.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_FITTIZIO));
		assertTrue(this.partitaNuova.getStanzaCorrente().hasAttrezzo(ATTREZZO_FITTIZIO));
	}

	private Attrezzo creaAttrezzoFittizioEMettiInBorsa() {
		Attrezzo attrezzoFittizio = new Attrezzo(ATTREZZO_FITTIZIO, 0);
		this.partitaNuova.getGiocatore().getBorsa().addAttrezzo(attrezzoFittizio);
		return attrezzoFittizio;
	}
}
