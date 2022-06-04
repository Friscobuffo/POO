package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiRiflessivaTest {

	FabbricaDiComandi fabbrica;
	
	@Before
	public void setUp() {
		fabbrica = new FabbricaDiComandiRiflessiva();
	}

	@Test
	public void testCostruisciComandoNull() {
		ComandoNonValido comando = (ComandoNonValido) fabbrica.costruisciComando(null);
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testCostruisciComandoEmpty() {
		ComandoNonValido comando = (ComandoNonValido) fabbrica.costruisciComando("");
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testCostruisciComandoVaiSenzaParametro() {
		ComandoVai comando = (ComandoVai) fabbrica.costruisciComando("vai");
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testCostruisciComandoVaiConParametro() {
		ComandoVai comando = (ComandoVai) fabbrica.costruisciComando("vai nord");
		assertEquals(comando.getParametro(), "nord");
	}
	
	@Test
	public void testCostruisciComandoVaiConDueParametri() {
		ComandoVai comando = (ComandoVai) fabbrica.costruisciComando("vai nord sud");
		assertEquals(comando.getParametro(), "nord sud");
	}
	
	@Test
	public void testCostruisciComandoPosaSenzaParametro() {
		ComandoPosa comando = (ComandoPosa) fabbrica.costruisciComando("posa");
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComandoPosaConParametro() {
		ComandoPosa comando = (ComandoPosa) fabbrica.costruisciComando("posa attrezzo");
		assertEquals(comando.getParametro(), "attrezzo");
	}
	
	@Test
	public void testCostruisciComandoPrendiSenzaParametro() {
		ComandoPrendi comando = (ComandoPrendi) fabbrica.costruisciComando("prendi");
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testCostruisciComandoPrendiConParametro() {
		ComandoPrendi comando = (ComandoPrendi) fabbrica.costruisciComando("prendi attrezzo");
		assertEquals(comando.getParametro(), "attrezzo");
	}
	
	@Test
	public void testCostruisciComandoAiuto() {
		ComandoAiuto comando = (ComandoAiuto) fabbrica.costruisciComando("aiuto prova");
		assertNotNull(comando);
	}
	
	@Test
	public void testCostruisciComandoFine() {
		ComandoFine comando = (ComandoFine) fabbrica.costruisciComando("fine prova");
		assertNotNull(comando);
	}
	
	@Test
	public void testCostruisciComandoGuarda() {
		ComandoGuarda comando = (ComandoGuarda) fabbrica.costruisciComando("guarda prova");
		assertNotNull(comando);

	}
}
