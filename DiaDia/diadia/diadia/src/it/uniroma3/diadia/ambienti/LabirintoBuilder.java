package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;

public class LabirintoBuilder{

	private Map<String,Stanza> stanze;
	private Stanza ultimaStanza;
	private Labirinto labirinto;

	public LabirintoBuilder() {
		this.stanze = new HashMap<>();
		this.labirinto = new Labirinto();
		this.ultimaStanza = null;
	}

	/**
	 * Dato il nome della stanza la imposta come stanza iniziale del labirinto
	 * se già presente tra le stanze inserite, altrimenti prima la crea e
	 * poi la imposta come stanza iniziale
	 * 
	 * @param nomeStanza String nome della stanza impostare
	 * @return riferimento a se stesso (LabirintoBuilder)
	 */
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {

		Stanza stanza = this.stanze.get(nomeStanza);
		if (stanza==null) {
			stanza = new Stanza(nomeStanza);
			this.stanze.put(nomeStanza, stanza);
		}
		this.labirinto.setStanzaIniziale(stanza);
		this.ultimaStanza = stanza;
		return this;
	}

	/**
	 * Dato il nome della stanza la imposta come stanza vincente del labirinto
	 * se già presente tra le stanze inserite, altrimenti prima la crea e
	 * poi la imposta come stanza vincente.
	 * 
	 * @param nomeStanza String nome della stanza impostare
	 * @return riferimento a se stesso (LabirintoBuilder)
	 */
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza stanza = this.stanze.get(nomeStanza);
		if (stanza == null) {
			stanza = new Stanza(nomeStanza);
			this.stanze.put(nomeStanza, stanza);
		}
		this.labirinto.setStanzaVincente(stanza);
		this.ultimaStanza = stanza;
		return this;
	}

	/**
	 * Crea una stanza e la aggiunge alla mappa delle stanze
	 * 
	 * @param nomeStanza String nome della stanza
	 * @return riferimento a se stesso (LabirintoBuilder)
	 */
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		this.stanze.put(nomeStanza, stanza);
		this.ultimaStanza = stanza;
		return this;
	}

	/**
	 * Crea una stanza bloccata e la aggiunge alla mappa delle stanze
	 * 
	 * @param nomeStanzaBloccata nome della stanza
	 * @param direzioneBloccata direzione bloccata
	 * @param attrezzoSbloccante attrezzo che sblocca la direzione
	 * @return riferimento a se stesso (LabirintoBuilder)
	 */
	public LabirintoBuilder addStanzaBloccata(String nomeStanzaBloccata,
			String direzioneBloccata, String attrezzoSbloccante) {
		StanzaBloccata stanzaBloccata = new StanzaBloccata(nomeStanzaBloccata,
				direzioneBloccata, attrezzoSbloccante);
		this.stanze.put(nomeStanzaBloccata, stanzaBloccata);
		this.ultimaStanza = stanzaBloccata;
		return this;
	}

	/**
	 * Crea una stanza magica e la aggiunge alla mappa delle stanze
	 * 
	 * @param nomeStanzaMagica nome della stanza magica
	 * @return riferimento a se stesso (LabirintoBuilder)
	 */
	public LabirintoBuilder addStanzaMagica(String nomeStanzaMagica) {
		StanzaMagica stanzaMagica = new StanzaMagica(nomeStanzaMagica);
		this.stanze.put(nomeStanzaMagica, stanzaMagica);
		this.ultimaStanza = stanzaMagica;
		return this;
	}

	
	public LabirintoBuilder addStanzaBuia(String nomeStanzaBuia, String attrezzoLuce) {
		StanzaBuia stanzaBuia = new StanzaBuia(nomeStanzaBuia, attrezzoLuce);
		this.stanze.put(nomeStanzaBuia, stanzaBuia);
		this.ultimaStanza = stanzaBuia;
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		this.ultimaStanza.addAttrezzo(attrezzo);
		return this;
	}

	public LabirintoBuilder addAdiacenza(String nomeStanza1, String nomeStanza2, String direzione) {
		Stanza stanza1 = stanze.get(nomeStanza1);
		Stanza stanza2 = stanze.get(nomeStanza2);
		stanza1.impostaStanzaAdiacente(direzione, stanza2);
		this.ultimaStanza = this.stanze.get(nomeStanza1);
		return this;
	}
	
	public LabirintoBuilder addMago(String nomeMago, Attrezzo attrezzo) {
		Mago mago = new Mago(nomeMago, attrezzo);
		this.ultimaStanza.setPersonaggio(mago);
		return this;
	}
	
	public LabirintoBuilder addCane() {
		Cane cane = new Cane();
		this.ultimaStanza.setPersonaggio(cane);
		return this;
	}
	
	public Map<String,Stanza> getStanze() {
		return this.stanze;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
}
