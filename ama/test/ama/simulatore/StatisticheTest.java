package ama.simulatore;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ama.Posizione;
import ama.mezzo.Brown;
import ama.mezzo.Chase;
import ama.mezzo.Mezzo;
import ama.mezzo.Politica;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;

public class StatisticheTest {

	private Simulatore simulatore;
	private Set<Rifiuto> smaltiti;
	private Statistiche stats;	
	
	final static private Posizione ORIGINE = new Posizione(0, 0);
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
		this.smaltiti = new HashSet<>();
		this.smaltiti.add(creaVetroRaccoltoDaBrowniano());
		this.smaltiti.add(creaVetroRaccoltoDaChaser());
		this.smaltiti.add(creaVetroRaccoltoDaBrowniano());
	}

	private Vetro creaVetroRaccoltoDaBrowniano() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaBrowniano());	
		return rifiuto;
	}

	
	private Vetro creaVetroRaccoltoDaChaser() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaChaser());	
		return rifiuto;
	}
	
	@Test
	public void testRaccoltoPerMezzo() {
		
		Map<Mezzo, Integer> mezzo2raccolta = stats.raccoltoPerMezzo(smaltiti);
		
		assertEquals(3, mezzo2raccolta.size());
		
		for(Mezzo m : mezzo2raccolta.keySet()) {
			assertEquals(1, mezzo2raccolta.get(m).intValue());
		}
	}

	
	@Test
	public void testRaccoltoPerPolitica() {

		Map<Class<? extends Politica>, Integer> politica2raccolta = stats.raccoltoPerPolitica(smaltiti);
		
		assertEquals(2, politica2raccolta.size());
		
		assertEquals(1, politica2raccolta.get(Chase.class).intValue());
		assertEquals(2, politica2raccolta.get(Brown.class).intValue());
	}
	
	@Test
	public void testOrdinaPolitichePerRaccolta() {
		List<Class<? extends Politica>> politicheOrdinate = 
				this.stats.ordinaPolitichePerRaccolta(stats.raccoltoPerPolitica(smaltiti));
		
		assertEquals(Arrays.asList(Brown.class, Chase.class), politicheOrdinate);
	}
	
	@Test
	public void testOrdinaPolitichePerRaccoltaVuota() {
		List<Class<? extends Politica>> politicheOrdinate = 
				this.stats.ordinaPolitichePerRaccolta(stats.raccoltoPerPolitica(Collections.emptySet()));
		
		assertTrue(politicheOrdinate.isEmpty());
	}
	
	@Test
	public void testOrdinaPolitichePerRaccoltaPareggio() {
		this.smaltiti = new HashSet<>();
		this.smaltiti.add(creaVetroRaccoltoDaChaser());
		this.smaltiti.add(creaVetroRaccoltoDaBrowniano());
		
		List<Class<? extends Politica>> politicheOrdinate = 
				this.stats.ordinaPolitichePerRaccolta(stats.raccoltoPerPolitica(this.smaltiti));
		
		assertEquals(2, politicheOrdinate.size());
	}
}
