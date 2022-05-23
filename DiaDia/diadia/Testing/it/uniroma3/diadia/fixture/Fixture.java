package it.uniroma3.diadia.fixture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class Fixture {
	
	public static IOSimulator creaSimulazionePartitaEGioca(List<String> istruzioni, Labirinto labirinto) {
		IOSimulator ioSimulator = new IOSimulator(istruzioni);
		new DiaDia(ioSimulator, labirinto).gioca();
		return ioSimulator;
	}
	
	public static IOSimulator creaSimulazionePartitaEGioca(String[] istruzioni, Labirinto labirinto) {
		return creaSimulazionePartitaEGioca(Arrays.asList(istruzioni), labirinto);
	}
	
	public static IOSimulator creaSimulazionePartitaEGioca(String... istruzioni) {
		return creaSimulazionePartitaEGioca(Arrays.asList(istruzioni), creaLabirintoBaseUnaStanza());
	}
	
	public static Labirinto creaLabirintoBaseUnaStanza() {
		return new LabirintoBuilder()
				.addStanzaIniziale("Stanza")
				.addStanzaVincente("Stanza")
				.getLabirinto();
	}
	
	public static Labirinto creaLabirintoBaseDueStanze() {
		return new LabirintoBuilder()
				.addStanzaIniziale("Stanza Iniziale")
				.addStanzaVincente("Stanza Vincente")
				.addAdiacenza("Stanza Iniziale", "Stanza Vincente", "Direzione")
				.getLabirinto();
	}
	
	public static Labirinto creaLabirintoCompleto() {
		return Labirinto.labirintoDiaDia();
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
