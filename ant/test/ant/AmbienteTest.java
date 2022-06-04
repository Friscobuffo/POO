package ant;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AmbienteTest {
	private Ambiente ambiente;
	private final static int DIMENSIONE = 10;

	@Before
	public void setUp() throws Exception {
		Set<Coordinate> ostacoli = new HashSet<>();
		
		ostacoli.add(new Coordinate(2,2));
		ostacoli.add(new Coordinate(1,2));
		ostacoli.add(new Coordinate(2,1));
		
		ostacoli.add(new Coordinate(4,5));
		ostacoli.add(new Coordinate(3,4));
		ostacoli.add(new Coordinate(5,5));

		this.ambiente = new Ambiente(DIMENSIONE, ostacoli);
	}

	@Test
	public void testGetPossibiliDirezioniTutteLibere() {
		Set<Direzione> direzioni = this.ambiente.getPossibiliDirezioni(new Coordinate(7,7));
		assertEquals(8, direzioni.size());
	}
	
	
	@Test
	public void testGetPossibiliDirezioniTutteOccupate() {
		Set<Direzione> direzioni = this.ambiente.getPossibiliDirezioni(new Coordinate(1,1));
		assertEquals(0, direzioni.size());
	}
	
	@Test
	public void testGetPossibiliDirezioniAlcuneOccupate() {
		Set<Direzione> direzioni = this.ambiente.getPossibiliDirezioni(new Coordinate(4,4));
		assertEquals(5, direzioni.size());
	}
}
