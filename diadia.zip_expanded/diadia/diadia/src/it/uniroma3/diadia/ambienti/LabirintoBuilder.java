package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder{
	
	private Map<String,Stanza> stanze;
	private Stanza ultimaStanza;
	private Labirinto labirinto;
	
	public LabirintoBuilder() {
		this.stanze = new HashMap<String,Stanza>();
		this.labirinto = new Labirinto();
		this.ultimaStanza = null;
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza stanza = this.stanze.get(nomeStanza);
		if (stanza == null) {
			stanza = new Stanza(nomeStanza);
			this.stanze.put(nomeStanza, stanza);
		}
			
		this.labirinto.setStanzaIniziale(stanza);
		this.ultimaStanza = stanza;
		return this;
	}
	
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
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		this.stanze.put(nomeStanza, stanza);
		this.ultimaStanza = stanza;
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nomeStanzaBloccata,
			String direzioneBloccata, String attrezzoSbloccante) {
		StanzaBloccata stanzaBloccata = new StanzaBloccata(nomeStanzaBloccata,
				direzioneBloccata, attrezzoSbloccante);
		this.stanze.put(nomeStanzaBloccata, stanzaBloccata);
		this.ultimaStanza = stanzaBloccata;
		return this;
	}
	
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
	
	public LabirintoBuilder addAdiacenza(String nomeStanza2, String direzione) {
		Stanza stanza2 = stanze.get(nomeStanza2);
		this.ultimaStanza.impostaStanzaAdiacente(direzione, stanza2);
		return this;
	}
	public Map<String,Stanza> getStanze() {
		return this.stanze;
	}
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Labirinto creLabirintoBase() {
		return this.addStanzaIniziale("Atrio")
		.addAttrezzo("osso",1)
		.addStanza("Aula N10")
		.addAttrezzo("lanterna", 3)
		.addStanza("Aula N11")
		.addStanza("Laboratorio Campus")
		.addStanzaVincente("Biblioteca")
		.addAdiacenza("Atrio", "Biblioteca", "nord")
		.addAdiacenza("Aula N11", "est")
		.addAdiacenza("Aula N10", "sud")
		.addAdiacenza("Laboratorio Campus", "ovest")
		.addAdiacenza("Aula N11", "Laboratorio Campus", "est")
		.addAdiacenza("Atrio", "ovest")
		.addAdiacenza("Aula N10", "Atrio", "nord")
		.addAdiacenza("Aula N11", "est")
		.addAdiacenza("Laboratorio Campus", "ovest")
		.addAdiacenza("Laboratorio Campus", "Atrio", "est")
		.addAdiacenza("Aula N11", "ovest")
		.addAdiacenza("Biblioteca", "Atrio", "sud")
		.getLabirinto();
		
//		/* crea gli attrezzi */
//    	Attrezzo lanterna = new Attrezzo("lanterna",3);
//		Attrezzo osso = new Attrezzo("osso",1);
//    	
//		/* crea stanze del labirinto */
//		Stanza atrio = new Stanza("Atrio");
//		Stanza aulaN11 = new Stanza("Aula N11");
//		Stanza aulaN10 = new Stanza("Aula N10");
//		Stanza laboratorio = new Stanza("Laboratorio Campus");
//		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
//		atrio.impostaStanzaAdiacente("nord", biblioteca);
//		atrio.impostaStanzaAdiacente("est", aulaN11);
//		atrio.impostaStanzaAdiacente("sud", aulaN10);
//		atrio.impostaStanzaAdiacente("ovest", laboratorio);
//		aulaN11.impostaStanzaAdiacente("est", laboratorio);
//		aulaN11.impostaStanzaAdiacente("ovest", atrio);
//		aulaN10.impostaStanzaAdiacente("nord", atrio);
//		aulaN10.impostaStanzaAdiacente("est", aulaN11);
//		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
//		laboratorio.impostaStanzaAdiacente("est", atrio);
//		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
//		biblioteca.impostaStanzaAdiacente("sud", atrio);
//
//      /* pone gli attrezzi nelle stanze */
//		aulaN10.addAttrezzo(lanterna);
//		atrio.addAttrezzo(osso);
//
//		// il gioco comincia nell'atrio
//      this.labirinto.setStanzaIniziale(atrio);  
//		this.labirinto.setStanzaVincente(biblioteca);
//		return this.labirinto;
    }

}
