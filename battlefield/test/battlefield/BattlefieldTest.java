package battlefield;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/* Modificare la classe Position affinche' 
 * il primo test abbia successo (vedi DOMANDA 1) 
 */
public class BattlefieldTest {
	
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
	}

	@Test
	public void testAddRobot() {
		assertEquals(0, this.field.getAllRobots().size());
		this.field.addRobot(new Walker(new Position(0,0)));
		assertEquals(1, this.field.getAllRobots().size());
	}
	
	@Test
	public void testRaggruppaRobotDiDueTipiDiversi() {
		this.field.addRobot(new Walker(new Position(0,0)));
		this.field.addRobot(new Walker(new Position(0,1)));
		this.field.addRobot(new Chaser(new Position(1,0)));
		assertEquals(2, this.field.raggruppaRobotPerTipo().size());
	}

}
