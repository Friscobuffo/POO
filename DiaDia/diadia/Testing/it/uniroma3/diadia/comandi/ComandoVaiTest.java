package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import static it.uniroma3.diadia.ambienti.Direzione.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoVaiTest {

	private Partita partitaNuova;
	private ComandoVai comandoVai;
	
	private final static String DIREZIONE = "nord";
	private final static String STANZA_INIZIALE = "Stanza Iniziale";
	private final static String STANZA_VINCENTE = "Stanza Vincente";
	
	private final static String DIREZIONE_BLOCCATA = "Direzione Bloccata";
	private final static String STANZA_BLOCCATA = "Stanza Bloccata";
	private final static String ATTREZZO_SBLOCCANTE = "Attrezzo sbloccante";
	
	@Before
	public void setUp() {
		this.comandoVai = new ComandoVai();
		IO io = new IOSimulator();
		this.comandoVai.setIo(io);
	}

	@Test
	public void testComandoVaiSenzaParametro() {
		this.partitaNuova = new Partita(creaLabirintoConDueStanze());
		int cfu = this.partitaNuova.getGiocatore().getCfu();
		
		this.comandoVai.esegui(this.partitaNuova);
		
		assertEquals(STANZA_INIZIALE, this.partitaNuova.getStanzaCorrente().getNome());
		assertEquals(cfu, this.partitaNuova.getGiocatore().getCfu());
	}
	
	@Test
	public void testComandoVai() {
		this.partitaNuova = new Partita(creaLabirintoConDueStanze());
		int cfu = this.partitaNuova.getGiocatore().getCfu();
		
		this.comandoVai.setParametro(DIREZIONE);
		this.comandoVai.esegui(partitaNuova);
		
		assertEquals(STANZA_VINCENTE, this.partitaNuova.getStanzaCorrente().getNome());
		assertEquals(cfu-1, this.partitaNuova.getGiocatore().getCfu());
	}
	
	@Test
	public void testComandoVaiConParametroSbagliato() {
		this.partitaNuova = new Partita(creaLabirintoConDueStanze());
		int cfu = this.partitaNuova.getGiocatore().getCfu();

		this.comandoVai.setParametro("parametro sbagliato");
		this.comandoVai.esegui(this.partitaNuova);
		
		assertEquals(STANZA_INIZIALE, this.partitaNuova.getStanzaCorrente().getNome());
		assertEquals(cfu, this.partitaNuova.getGiocatore().getCfu());
	}
	
	@Test
	public void testComandoVaiStanzaBloccataSenzaAttrezzo() {
		this.partitaNuova = new Partita(creaLabirintoBloccato());
		
		int cfu = this.partitaNuova.getGiocatore().getCfu();

		this.comandoVai.setParametro(DIREZIONE_BLOCCATA);
		this.comandoVai.esegui(this.partitaNuova);
		
		assertEquals(STANZA_BLOCCATA, this.partitaNuova.getStanzaCorrente().getNome());
		assertEquals(cfu, this.partitaNuova.getGiocatore().getCfu());
		
	}
	
	@Test
	public void testComandoVaiStanzaBloccataConAttrezzo() {
		this.partitaNuova = new Partita(creaLabirintoBloccato());
		this.partitaNuova.getStanzaCorrente().addAttrezzo(new Attrezzo(ATTREZZO_SBLOCCANTE, 0));
		int cfu = this.partitaNuova.getGiocatore().getCfu();

		this.comandoVai.setParametro("sud");
		this.comandoVai.esegui(this.partitaNuova);
		
		assertEquals(STANZA_VINCENTE, this.partitaNuova.getStanzaCorrente().getNome());
		assertEquals(cfu-1, this.partitaNuova.getGiocatore().getCfu());
	}
	
	private Labirinto creaLabirintoConDueStanze() {
		return new LabirintoBuilder()
				.addStanzaIniziale(STANZA_INIZIALE)
				.addStanzaVincente(STANZA_VINCENTE)
				.addAdiacenza(STANZA_INIZIALE, STANZA_VINCENTE, NORD)
				.getLabirinto();
	}
	
	private Labirinto creaLabirintoBloccato() {
		return new LabirintoBuilder()
				.addStanzaBloccata(STANZA_BLOCCATA, SUD, ATTREZZO_SBLOCCANTE)
				.addStanzaIniziale(STANZA_BLOCCATA)
				.addStanzaVincente(STANZA_VINCENTE)
				.addAdiacenza(STANZA_BLOCCATA, STANZA_VINCENTE, SUD)
				.getLabirinto();
	}
}
