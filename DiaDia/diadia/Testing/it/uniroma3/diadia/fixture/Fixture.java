package it.uniroma3.diadia.fixture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import static it.uniroma3.diadia.ambienti.Direzione.*;

public class Fixture {
	public final static String NOME_STANZA = "Stanza";
	
	public static IOSimulator creaSimulazionePartitaEGioca(List<String> istruzioni, Labirinto labirinto) {
		IOSimulator ioSimulator = new IOSimulator(istruzioni);
		new DiaDia(ioSimulator, labirinto).gioca();
		return ioSimulator;
	}
	
	public static IOSimulator creaSimulazionePartitaEGioca(String... istruzioni) {
		return creaSimulazionePartitaEGioca(Arrays.asList(istruzioni), creaLabirintoBaseUnaStanza());
	}
	
	public static Labirinto creaStanzaQuattroStanzeAdiacentiEAggiungiAttrezzi() {
		return new Labirinto().new LabirintoBuilder()
				.addStanzaIniziale(NOME_STANZA).addStanza("Stanza 0 attrezzi")
				.addAdiacenza(NOME_STANZA, "Stanza 0 attrezzi", NORD)
				.addStanza("Stanza 1 attrezzo")
				.addAttrezzo("Attrezzo0", 0)
				.addAdiacenza(NOME_STANZA, "Stanza 1 attrezzo", EST)
				.addStanza("Stanza 2 attrezzi")
				.addAttrezzo("Attrezzo1", 0)
				.addAttrezzo("Attrezzo2", 0)
				.addAdiacenza(NOME_STANZA, "Stanza 2 attrezzi", SUD)
				.getLabirinto();
	}
	
	public static Labirinto creaLabirintoBaseUnaStanza() {
		Labirinto labirinto = new Labirinto();
		return labirinto. new LabirintoBuilder()
				.addStanzaIniziale("Stanza")
				.addStanzaVincente("Stanza")
				.getLabirinto();
	}
	
	public static Labirinto creaLabirintoBaseDueStanze() {
		Labirinto labirinto = new Labirinto();
		return labirinto. new LabirintoBuilder()
				.addStanzaIniziale("Stanza Iniziale")
				.addStanzaVincente("Stanza Vincente")
				.addAdiacenza("Stanza Iniziale", "Stanza Vincente", NORD)
				.getLabirinto();
	}
	
	public static Labirinto creaLabirintoCompleto() {
		return null;
		//return Labirinto.labirintoDiaDia();
	}
	
	public static List<String> istruzioniPartitaCompleta() {
		List<String> istruzioni = new ArrayList<String>();
		istruzioni.add("aiuto");
		istruzioni.add("comando inesistente");
		istruzioni.add("vai sud");
		istruzioni.add("prendi lanterna");
		istruzioni.add("vai nord");
		istruzioni.add("guarda");
		istruzioni.add("posa lanterna");
		istruzioni.add("prendi osso");
		istruzioni.add("fine");
		return istruzioni;
	}
}
