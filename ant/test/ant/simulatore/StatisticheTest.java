package ant.simulatore;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ant.Cibo;
import ant.Coordinate;
import ant.formica.Esploratrice;
import ant.formica.Formica;
import ant.formica.Inseguitrice;

@SuppressWarnings("unused")
public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	
	final private Coordinate origine = new Coordinate(0, 0);
	
	private Esploratrice formica ;
	private Inseguitrice altraFormica ;
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
		this.formica = this.simulatore.creaEsploratrice();
		this.altraFormica = this.simulatore.creaInseguitrice();
	}

	
	private Cibo creaCiboRaccoltoDaEsploratore(Esploratrice e) {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(e);	
		return cibo;
	}

	private Cibo creaCiboRaccoltoDaInseguitore(Inseguitrice i) {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(i);	
		return cibo;
	}

	@Test
	public void testRaccoltoPerFormica() {
		Set<Cibo> raccolto = new HashSet<Cibo>();
		raccolto.add(creaCiboRaccoltoDaEsploratore(formica));
		raccolto.add(creaCiboRaccoltoDaInseguitore(altraFormica));
		raccolto.add(creaCiboRaccoltoDaInseguitore(altraFormica));
		
		Map<Formica,Integer> formica2quantita = this.stats.raccoltoPerFormica(raccolto);
		assertEquals(1, formica2quantita.get(formica).intValue());
		assertEquals(2, formica2quantita.get(altraFormica).intValue());
		assertEquals(2, formica2quantita.size());

	}
	
	@Test
	public void testRaccoltoPerTipoDiFormica() {
		Set<Cibo> raccolto = new HashSet<Cibo>();
		raccolto.add(creaCiboRaccoltoDaEsploratore(formica));
		raccolto.add(creaCiboRaccoltoDaInseguitore(altraFormica));
		raccolto.add(creaCiboRaccoltoDaInseguitore(altraFormica));
		
		Map<Class<? extends Formica>, Set<Cibo>> tipo2quantita = this.stats.raccoltoPerTipoDiFormica(raccolto);
		Set<Cibo> ciboEsploratori = tipo2quantita.get(Esploratrice.class);
		Set<Cibo> ciboInseguitori = tipo2quantita.get(Inseguitrice.class);
		
		assertEquals(1, ciboEsploratori.size());
		assertEquals(2, ciboInseguitori.size());
	}
	
}
