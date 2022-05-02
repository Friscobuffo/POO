package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private final static String NOMEATTREZZO = "attrezzo di prova";
	
	private Borsa borsa;

	@Before
	public void setUp() {
		this.borsa = new Borsa();
	}

	@Test
	public void testAddAttrezzo() {
		creaEAggiungiAttrezzo(0, 0);
		assertTrue(this.borsa.hasAttrezzo(NOMEATTREZZO+0));
	}
	
	@Test
	public void testAddPiuAttrezzi() {
		creaEAggiungiAttrezzo(0, 0);
		creaEAggiungiAttrezzo(1, 0);
		assertEquals(2, this.borsa.numeroAttrezzi());
	}

	@Test
	public void testAddAttrezziTroppoPesanti() {
		this.borsa = new Borsa(10);
		Attrezzo a0 = creaEAggiungiAttrezzo(0, 5);
		assertTrue(this.borsa.hasAttrezzo(a0.getNome()));
		Attrezzo a1 = creaEAggiungiAttrezzo(1, 10);
		assertFalse(this.borsa.hasAttrezzo(a1.getNome()));

	}
	@Test
	public void testGetPesoMax() {
		assertEquals(Borsa.DEFAULT_PESO_MAX_BORSA, this.borsa.getPesoMax());
	}

	@Test
	public void testGetAttrezzo() {
		Attrezzo a = creaEAggiungiAttrezzo(0, 0);
		assertEquals(a, this.borsa.getAttrezzo(NOMEATTREZZO+0));
	}

	@Test
	public void testGetPeso() {
		assertEquals(0, this.borsa.getPeso());
		creaEAggiungiAttrezzo(0, 1);
		assertEquals(1, this.borsa.getPeso());
		creaEAggiungiAttrezzo(1, 2);
		assertEquals(3, this.borsa.getPeso());
	}

	@Test
	public void testIsEmptyBorsaVuota() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void testIsEmptyBorsaNonVuota() {
		creaEAggiungiAttrezzo(0, 0);
		assertFalse(this.borsa.isEmpty());
	}
	
	@Test
	public void testHasAttrezzoPresente() {
		creaEAggiungiAttrezzo(0, 0);
		assertTrue(this.borsa.hasAttrezzo(NOMEATTREZZO+0));
	}

	@Test
	public void testHasAttrezzoNonPresente() {
		assertFalse(this.borsa.hasAttrezzo(NOMEATTREZZO+0));
	}
	
	@Test
	public void testRemoveAttrezzoPresenteNellaBorsa() {
		Attrezzo a = creaEAggiungiAttrezzo(0, 0);
		assertEquals(a, this.borsa.removeAttrezzo(NOMEATTREZZO+0));
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void testRemoveAttrezzoNonPresenteNellaBorsa() {
		assertNull(this.borsa.removeAttrezzo(NOMEATTREZZO));
	}
	
	@Test
	public void testGetListaAttrezziOrdinataPerPeso() {
		this.creaAttrezziEMettiTuttiInBorsa();
		List<Attrezzo> attrezzi = this.borsa.getListaAttrezziOrdinataPerPeso();
		assertEquals("Piuma", attrezzi.get(0).getNome());
		assertEquals("Libro", attrezzi.get(1).getNome());
		assertEquals("Ps", attrezzi.get(2).getNome());
		assertEquals("Piombo", attrezzi.get(3).getNome());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerNome() {
		creaAttrezziEMettiTuttiInBorsa();
		SortedSet<Attrezzo> attrezzi = this.borsa.getSortedSetOrdinatoPerNome();
		Iterator<Attrezzo> i = attrezzi.iterator();
		assertEquals("Libro", i.next().getNome());
		assertEquals("Piombo", i.next().getNome());
		assertEquals("Piuma", i.next().getNome());
		assertEquals("Ps", i.next().getNome());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		creaAttrezziEMettiTuttiInBorsa();
		SortedSet<Attrezzo> attrezzi = this.borsa.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> i = attrezzi.iterator();
		assertEquals("Piuma", i.next().getNome());
		assertEquals("Libro", i.next().getNome());
		assertEquals("Ps", i.next().getNome());
		assertEquals("Piombo", i.next().getNome());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		creaAttrezziEMettiTuttiInBorsa();
		Map<Integer,Set<Attrezzo>> map = this.borsa.getContenutoRaggruppatoPerPeso();
		
		assertEquals(3, map.size());
		
		Set<Attrezzo> peso1 = map.get(1);
		Attrezzo piuma = new Attrezzo("Piuma", 1);
		assertTrue(peso1.contains(piuma));
		
		Set<Attrezzo> peso5 = map.get(5);
		Attrezzo libro = new Attrezzo("Libro", 5);
		Attrezzo ps = new Attrezzo("Ps", 5);
		assertTrue(peso5.contains(libro));
		assertTrue(peso5.contains(ps));
		
		Set<Attrezzo> peso10 = map.get(10);
		Attrezzo piombo = new Attrezzo("Piombo", 10);
		assertTrue(peso10.contains(piombo));
	}
	
	private void creaAttrezziEMettiTuttiInBorsa() {
		this.borsa = new Borsa(100);
		this.borsa.addAttrezzo(new Attrezzo("Piombo", 10));
		this.borsa.addAttrezzo(new Attrezzo("Ps", 5));
		this.borsa.addAttrezzo(new Attrezzo("Piuma", 1));
		this.borsa.addAttrezzo(new Attrezzo("Libro", 5));
	}
	
	private Attrezzo creaEAggiungiAttrezzo(int i, int peso) {
		Attrezzo a = new Attrezzo(NOMEATTREZZO+i, peso);
		this.borsa.addAttrezzo(a);
		return a;
	}

}
