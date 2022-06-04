package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	private String nome;
	private Map<String, Attrezzo> attrezzi;
	private Map<Direzione, Stanza> stanzeAdiacenti;
	private AbstractPersonaggio personaggio;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashMap<>();
	}

	/**
	 * Restituisce il nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}
	
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
	
	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		stanzeAdiacenti.put(direzione, stanza);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 * @return la stanza adiacente
	 */
	public Stanza getStanzaAdiacente(Direzione direzione) {
		return stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return new ArrayList<Attrezzo>(this.attrezzi.values());
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public Attrezzo addAttrezzo(Attrezzo attrezzo) {
		attrezzi.put(attrezzo.getNome(), attrezzo);
		return attrezzo;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);

		risultato.append("\nUscite: ");
		Set<Direzione> direzioni = this.getDirezioni();
		for (Direzione direzione : direzioni)
			risultato.append(" " + direzione.toString().toLowerCase());

		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo: this.attrezzi.values()) {
			risultato.append(attrezzo.toString()+" ");
		}
		if(this.personaggio!=null)
			risultato.append("\nC'e' qualcuno nella stanza.");
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @param nomeAttrezzo String con il nome dell'attrezzo da trovare
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se la rimozione è andata a buon fine,
	 * 		   false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return (this.attrezzi.remove(attrezzo.getNome()) != null);
	}

	public Set<Direzione> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}

	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}
	
	public List<Stanza> getStanzeAdiacenti() {
		return new ArrayList<Stanza>(this.stanzeAdiacenti.values());
	}
	
	public Stanza getStanzaAdiacenteConPiuAttrezzi(){
		List<Stanza> stanzeAdiacenti = this.getStanzeAdiacenti();
		if (!stanzeAdiacenti.isEmpty()) {
			int numeroMassimoAttrezzi = -1;
			Stanza stanzaNumeroMassimoAttrezzi = null;
			for(Stanza stanza : stanzeAdiacenti) {
				if (stanza.getNumeroAttrezzi() > numeroMassimoAttrezzi) {
					stanzaNumeroMassimoAttrezzi = stanza;
					numeroMassimoAttrezzi = stanza.getNumeroAttrezzi();
				}
			}
			return stanzaNumeroMassimoAttrezzi;
		}
		throw new IllegalArgumentException("Non ha stanze adiacenti");
	}
	
	public Stanza getStanzaAdiacenteConMenoAttrezzi() {
		List<Stanza> stanzeAdiacenti = this.getStanzeAdiacenti();
		if (!stanzeAdiacenti.isEmpty()) {
			int numeroMinimoAttrezzi = stanzeAdiacenti.get(0).getNumeroAttrezzi();
			Stanza stanzaNumeroMinimoAttrezzi = stanzeAdiacenti.get(0);
			
			for(Stanza stanza : stanzeAdiacenti) {
				if (stanza.getNumeroAttrezzi() < numeroMinimoAttrezzi) {
					stanzaNumeroMinimoAttrezzi = stanza;
					numeroMinimoAttrezzi = stanza.getNumeroAttrezzi();
				}
			}
			return stanzaNumeroMinimoAttrezzi;
		}
		throw new IllegalArgumentException("Non ha stanze adiacenti");	}
}