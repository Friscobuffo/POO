package battlefield;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

public class RobotOrdinatiPerPosizioneTest {
	
	private Battlefield battlefield;
	private Robot r1;
	private Robot r2;
	private Robot r3;
	private Robot r4;
	
	@Before
	public void setUp() {
		this.battlefield = new Battlefield(3);
		this.r1 = new Walker(new Position(0,0));
		this.r2 = new Walker(new Position(0,1));
		this.r3 = new Chaser(new Position(1,0));
		this.r4 = new Chaser(new Position(1,1));
	}
	
	@Test
	public void testBattlefieldVuoto() {
		assertTrue(this.battlefield.getRobotOrdinatiPerPosizione().isEmpty());
	}
	
	@Test
	public void testBattlefieldRobotSingleton() {
		this.battlefield.addRobot(r1);
		
		assertEquals(1, this.battlefield.getRobotOrdinatiPerPosizione().size());
		assertSame(r1, this.battlefield.getRobotOrdinatiPerPosizione().get(0));
	}
	
	@Test
	public void testBattlefieldRobotDoubletonDiversaX() {
		this.battlefield.addRobot(r3);
		this.battlefield.addRobot(r1);
		
		List<Robot> robotOrdinatiPerPosizione = this.battlefield.getRobotOrdinatiPerPosizione();
		
		assertEquals(2, robotOrdinatiPerPosizione.size());
		assertSame(r1, robotOrdinatiPerPosizione.get(0));
		assertSame(r3, robotOrdinatiPerPosizione.get(1));
	}
	
	@Test
	public void testBattlefieldRobotDoubletonStessaXDiversaY() {
		this.battlefield.addRobot(r2);
		this.battlefield.addRobot(r1);
		
		List<Robot> robotOrdinatiPerPosizione = this.battlefield.getRobotOrdinatiPerPosizione();
		
		assertEquals(2, robotOrdinatiPerPosizione.size());
		assertSame(r1, robotOrdinatiPerPosizione.get(0));
		assertSame(r2, robotOrdinatiPerPosizione.get(1));
	}
	
	@Test
	public void testBattlefieldCompleto() {
		this.battlefield.addRobot(r3);
		this.battlefield.addRobot(r4);
		this.battlefield.addRobot(r1);
		this.battlefield.addRobot(r2);

		
		List<Robot> robotOrdinatiPerPosizione = this.battlefield.getRobotOrdinatiPerPosizione();
		
		assertEquals(4, robotOrdinatiPerPosizione.size());
		assertSame(r1, robotOrdinatiPerPosizione.get(0));
		assertSame(r2, robotOrdinatiPerPosizione.get(1));
		assertSame(r3, robotOrdinatiPerPosizione.get(2));
		assertSame(r4, robotOrdinatiPerPosizione.get(3));
	}
}
