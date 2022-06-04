package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Attrezzo {

	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}

	@Override
	public boolean equals(Object o) {
		Attrezzo that = (Attrezzo) o;
		return this.getNome().equals(that.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
	
	public static class ComparatoreAttrezziPerPeso implements Comparator<Attrezzo> {

		@Override
		public int compare(Attrezzo a1, Attrezzo a2) {
			int v = a1.getPeso() - a2.getPeso();
			if (v == 0)
				return a1.getNome().compareTo(a2.getNome());
			return v;
		}
	}
	
	public static class ComparatoreAttrezziPerNome implements Comparator<Attrezzo> {

		@Override
		public int compare(Attrezzo a1, Attrezzo a2) {
			return a1.getNome().compareTo(a2.getNome());
		}
	}
}