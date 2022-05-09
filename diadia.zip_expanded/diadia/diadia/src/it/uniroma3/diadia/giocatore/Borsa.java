package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerNome;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

/**
 * Questa classe modella una borsa del giocatore
 *
 * @author  docente di POO
 * @see Attrezzo
 * @version base
 */

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>();
	}

	/**
	 * Lista degli attrezzi nella borsa
	 * @return LinkedList di attrezzi
	 */
	public List<Attrezzo> getAttrezzi() {
		return new ArrayList<Attrezzo>(this.attrezzi.values());
	}

	/**
	 * Aggiunge un attrezzo alla borsa se possibile.
	 * Se non � possibile o la borsa ha troppi attrezzi oppure
	 * � troppo pesante.
	 * @param attrezzo l'attrezzo da aggiungere
	 * @return true se l'attrezzo � stato aggiunto
	 * 		   false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}

	/**
	 * Peso totale sostenibile dalla borsa
	 * 
	 * @return peso totale
	 */
	public int getPesoMax() {
		return pesoMax;
	}

	/** 
	 * Trova un attrezzo nella borsa
	 * 
	 * @param nomeAttrezzo stringa con il nome dell'attrezzo da trovare
	 * @return riferimento all'attrezzo se presente nella borsa, null altrimenti
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Calcola il peso della borsa
	 * 
	 * @return int somma dei pesi di tutti gli attrezzi presenti nella borsa
	 */
	public int getPeso() {
		int peso = 0;
		for (Attrezzo attrezzo: attrezzi.values()) {
			peso += attrezzo.getPeso();
		}
		return peso;
	}

	/**
	 * Verifica se la borsa � vuota
	 * 
	 * @return boolean, true se la borsa � vuota, false altrimenti
	 */
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	/**
	 * Verifica la presenza di un attrezzo nella borsa
	 * 
	 * @param nomeAttrezzo stringa con nome dell'attrezzo da verificare
	 * @return un boolean, true se la borsa contiene l'attrezzo di nome
	 * nomeAttrezzo, false altrimenti
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	public int numeroAttrezzi() {
		return this.attrezzi.size();
	}
	
	/**
	 * Rimuove un attrezzo dalla borsa se presente.
	 * 
	 * @param nomeAttrezzo stringa con il nome dell'attrezzo da rimuovere
	 * @return il riferimento dell'attrezzo rimosso se presente
	 * 		   null se l'attrezzo non � presente
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return attrezzi.remove(nomeAttrezzo);
	}
	
	/**
	 * Ordina gli attrezzi presenti nella borsa in base al peso in
	 * maniera crescente.
	 * 
	 * @return la lista di attrezzi
	 */
	public List<Attrezzo> getListaAttrezziOrdinataPerPeso() {
		List<Attrezzo> attrezzi = new ArrayList<Attrezzo>(this.attrezzi.values());
		Collections.sort(attrezzi, new ComparatoreAttrezziPerPeso());
		return attrezzi;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerNome() {
		SortedSet<Attrezzo> attrezzi = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerNome());
		attrezzi.addAll(this.attrezzi.values());
		return attrezzi;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> attrezzi = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		attrezzi.addAll(this.attrezzi.values());
		return attrezzi;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer,Set<Attrezzo>> attrezziRaggruppatiPerPeso = new HashMap<>();
		for (Attrezzo attrezzo : getAttrezzi()) {
			int peso = attrezzo.getPeso();
			Set<Attrezzo> set = attrezziRaggruppatiPerPeso.get(peso);
			if (set==null) {
				set = new HashSet<Attrezzo>();
				attrezziRaggruppatiPerPeso.put(peso, set);
			}
			set.add(attrezzo);
		}
		return attrezziRaggruppatiPerPeso;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (this.isEmpty()) {
			s.append("Borsa vuota ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg)");
		}
		else {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo attrezzo: this.getListaAttrezziOrdinataPerPeso())
				s.append(attrezzo.toString()+" ");
		}
		return s.toString();
	}

	public String getDescrizione() {
		return this.toString();
	}
}