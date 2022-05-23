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
	public void testCostruisciComandoVaiSenzaParametro() {
		Comando comando = fabbrica.costruisciComando("vai");
		assertEquals(comando.getNome(), "ComandoVai");
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testCostruisciComandoVaiConParametro() {
		Comando comando = fabbrica.costruisciComando("vai nord");
		assertEquals(comando.getNome(), "ComandoVai");
		assertEquals(comando.getParametro(), "nord");
	}
	
	@Test
	public void testCostruisciComandoVaiConDueParametri() {
		Comando comando = fabbrica.costruisciComando("vai nord sud");
		assertEquals(comando.getNome(), "ComandoVai");
		assertEquals(comando.getParametro(), "nord sud");
	}
	
	@Test
	public void testCostruisciComandoPosaSenzaParametro() {
		Comando comando = fabbrica.costruisciComando("posa");
		assertEquals(comando.getNome(), "ComandoPosa");
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComandoPosaConParametro() {
		Comando comando = fabbrica.costruisciComando("posa attrezzo");
		assertEquals(comando.getNome(), "ComandoPosa");
		assertEquals(comando.getParametro(), "attrezzo");
	}
	
	@Test
	public void testCostruisciComandoPrendiSenzaParametro() {
		Comando comando = fabbrica.costruisciComando("prendi");
		assertEquals(comando.getNome(), "ComandoPrendi");
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testCostruisciComandoPrendiConParametro() {
		Comando comando = fabbrica.costruisciComando("prendi attrezzo");
		assertEquals(comando.getNome(), "ComandoPrendi");
		assertEquals(comando.getParametro(), "attrezzo");
	}
	
	@Test
	public void testCostruisciComandoAiuto() {
		Comando comando = fabbrica.costruisciComando("aiuto prova");
		assertEquals(comando.getNome(), "ComandoAiuto");
	}
	
	@Test
	public void testCostruisciComandoFine() {
		Comando comando = fabbrica.costruisciComando("fine prova");
		assertEquals(comando.getNome(), "ComandoFine");
	}
	
	@Test
	public void testCostruisciComandoGuarda() {
		Comando comando = fabbrica.costruisciComando("guarda prova");
		assertEquals(comando.getNome(), "ComandoGuarda");
	}
}
