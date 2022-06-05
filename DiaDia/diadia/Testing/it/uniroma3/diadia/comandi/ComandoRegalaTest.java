package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.fixture.Fixture;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegalaTest {

	private Partita partita;
	private ComandoRegala comandoRegala;
	private final static String ATTREZZO = "Attrezzo fittizio";
	private final static String NOME_PERSONAGGIO = "Personaggio";
	private final static String PRESENTAZIONE = "Presentazione";
	
	@Before
	public void setUp() throws Exception {
		this.comandoRegala = new ComandoRegala();
		this.comandoRegala.setIo(new IOSimulator());
		
		this.partita = new Partita(Fixture.creaLabirintoBaseUnaStanza());
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo(ATTREZZO, 3));
		
		this.partita.getStanzaCorrente().setPersonaggio(
				new AbstractPersonaggio(NOME_PERSONAGGIO, PRESENTAZIONE) {
			
			@Override
			public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
				partita.getStanzaCorrente().addAttrezzo(attrezzo);
				return "attrezzo posato nella stanza";
			}
			
			@Override
			public String agisci(Partita partita) {
				return "agisci";
			}
		});
	}

	@Test
	public void testEseguiAttrezzoPresenteInBorsa() {
		this.comandoRegala.setParametro(ATTREZZO);
		this.comandoRegala.esegui(partita);
		
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testEseguiAttrezzoNonPresenteInBorsa() {
		this.comandoRegala.setParametro(ATTREZZO+" non presente");
		this.comandoRegala.esegui(partita);
		
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO+" non presente"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(ATTREZZO+" non presente"));
	}
	
	@Test
	public void testEseguiParametroNull() {
		this.comandoRegala.esegui(partita);
		
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testEseguiParametroStringaVuota() {
		this.comandoRegala.setParametro("");
		this.comandoRegala.esegui(partita);
		
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(ATTREZZO));
	}
}
