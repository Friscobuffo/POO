package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.eccezioni.FormatoFileNonValidoException;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Questa classe modella il labirinto della partita
 * 
 * @author Docente di Poo
 * @see Stanza
 * @see Attrezzo
 * @version base
 */
public class Labirinto {

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	public Labirinto() {
	}

	public Labirinto(String nomeFile) throws IOException, FormatoFileNonValidoException {
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public class LabirintoBuilder {

		private Map<String,Stanza> nome2stanza;
		private Stanza ultimaStanza;

		public LabirintoBuilder() {
			this.nome2stanza = new HashMap<>();
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

			Stanza stanza = this.nome2stanza.get(nomeStanza);
			if (stanza==null) {
				stanza = new Stanza(nomeStanza);
				this.nome2stanza.put(nomeStanza, stanza);
			}
			stanzaIniziale = stanza;
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
			Stanza stanza = this.nome2stanza.get(nomeStanza);
			if (stanza == null) {
				stanza = new Stanza(nomeStanza);
				this.nome2stanza.put(nomeStanza, stanza);
			}
			stanzaVincente = stanza;
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
			this.nome2stanza.put(nomeStanza, stanza);
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
				Direzione direzioneBloccata, String attrezzoSbloccante) {
			StanzaBloccata stanzaBloccata = 
					new StanzaBloccata(nomeStanzaBloccata, direzioneBloccata, attrezzoSbloccante);
			this.nome2stanza.put(nomeStanzaBloccata, stanzaBloccata);
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
			this.nome2stanza.put(nomeStanzaMagica, stanzaMagica);
			this.ultimaStanza = stanzaMagica;
			return this;
		}


		public LabirintoBuilder addStanzaBuia(String nomeStanzaBuia, String attrezzoLuce) {
			StanzaBuia stanzaBuia = new StanzaBuia(nomeStanzaBuia, attrezzoLuce);
			this.nome2stanza.put(nomeStanzaBuia, stanzaBuia);
			this.ultimaStanza = stanzaBuia;
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			this.ultimaStanza.addAttrezzo(attrezzo);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int pesoAttrezzo, String nomeStanza) {
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, pesoAttrezzo);
			Stanza stanza = this.nome2stanza.get(nomeStanza);
			stanza.addAttrezzo(attrezzo);
			return this;
		}
		public LabirintoBuilder addAdiacenza(String nomeStanza1, String nomeStanza2, Direzione direzione) {
			Stanza stanza1 = nome2stanza.get(nomeStanza1);
			Stanza stanza2 = nome2stanza.get(nomeStanza2);
			stanza1.impostaStanzaAdiacente(direzione, stanza2);
			stanza2.impostaStanzaAdiacente(direzione.opposta(), stanza1);

			this.ultimaStanza = this.nome2stanza.get(nomeStanza1);
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
			return this.nome2stanza;
		}

		public Labirinto getLabirinto() {
			return Labirinto.this;
		}
	}

//	public Labirinto labirintoDiaDia() {
//		return new LabirintoBuilder()
//				.addStanzaIniziale("Atrio")
//				.addMago("Merlino", new Attrezzo("bacchetta magica",1))
//				.addAttrezzo("osso",1)
//				.addStanza("Aula N10")
//				.addCane()
//				.addAttrezzo("lanterna", 3)
//				.addStanza("Aula N11")
//				.addStanza("Laboratorio Campus")
//				.addStanzaVincente("Biblioteca")
//				.addAdiacenza("Atrio", "Biblioteca", NORD)
//				.addAdiacenza("Atrio", "Aula N11", EST)
//				.addAdiacenza("Atrio", "Aula N10", SUD)
//				.addAdiacenza("Atrio", "Laboratorio Campus", OVEST)
//				.addAdiacenza("Aula N11", "Laboratorio Campus", EST)
//				.addAdiacenza("Aula N11", "Atrio", OVEST)
//				.addAdiacenza("Aula N10", "Atrio", NORD)
//				.addAdiacenza("Aula N10", "Aula N11", EST)
//				.addAdiacenza("Aula N10", "Laboratorio Campus", OVEST)
//				.addAdiacenza("Laboratorio Campus", "Atrio", EST)
//				.addAdiacenza("Laboratorio Campus", "Aula N11", OVEST)
//				.addAdiacenza("Biblioteca", "Atrio", SUD)
//				.getLabirinto();
//	}
	
	public class CaricatoreLabirinto {

		/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
		private static final String STANZE_MARKER = "Stanze: ";             

		/* prefisso di una singola riga contenente il nome della stanza iniziale */
		private static final String STANZA_INIZIALE_MARKER = "Inizio: ";    

		/* prefisso della riga contenente il nome stanza vincente */
		private static final String STANZA_VINCENTE_MARKER = "Vincente: ";  

		/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeAttrezzo> <peso> <nomeStanza> */
		private static final String ATTREZZI_MARKER = "Attrezzi: ";

		/* prefisso della riga contenente le specifiche dei collegamenti tra stanza nel formato <nomeStanzaDa> <direzione> <nomeStanzaA> */
		private static final String USCITE_MARKER = "Uscite: ";

		/*
		 *  Esempio di un possibile file di specifica di un labirinto (vedi POO-26-eccezioni-file.pdf)

			Stanze: biblioteca, N10, N11
			Inizio: N10
			Vincente: N11
			Attrezzi: martello 10 biblioteca, pinza 2 N10
			Uscite: biblioteca nord N10, biblioteca sud N11

		 */
		private LineNumberReader reader;
		
		protected LabirintoBuilder builder;

		public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
			this.builder =  new LabirintoBuilder();
			this.reader = new LineNumberReader(new FileReader(nomeFile));
		}

		public void carica() throws FormatoFileNonValidoException {
			try {
				this.leggiECreaStanze();
				this.leggiInizialeEvincente();
				this.leggiECollocaAttrezzi();
				this.leggiEImpostaUscite();
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}

		}

		private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
			try {
				String riga = this.reader.readLine();
				check(riga.startsWith(marker),"era attesa una riga che cominciasse per "+marker);
				return riga.substring(marker.length());
			} catch (IOException e) {
				throw new FormatoFileNonValidoException(e.getMessage());
			}
		}

		private void leggiECreaStanze() throws FormatoFileNonValidoException  {
			String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
			for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
				builder.addStanza(nomeStanza);
			}
		}

		private List<String> separaStringheAlleVirgole(String string) {
			List<String> result = new LinkedList<>();
			Scanner scanner = new Scanner(string);
			scanner.useDelimiter(", ");
			while (scanner.hasNext()) {
				result.add(scanner.next());
			}
			scanner.close();
			return result;
		}

		private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
			String nomeStanzaIniziale = null;
			nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);
			check(this.isStanzaValida(nomeStanzaIniziale), nomeStanzaIniziale +" non definita");
			String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);
			check(this.isStanzaValida(nomeStanzaVincente), nomeStanzaVincente + " non definita");
			this.builder.addStanzaIniziale(nomeStanzaIniziale);
			this.builder.addStanzaVincente(nomeStanzaVincente);
		}

		private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
			String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);

			for(String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
				String nomeAttrezzo = null;
				String pesoAttrezzo = null;
				String nomeStanza = null; 
				try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un attrezzo."));
					nomeAttrezzo = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso dell'attrezzo "+nomeAttrezzo+"."));
					pesoAttrezzo = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare l'attrezzo "+nomeAttrezzo+"."));
					nomeStanza = scannerLinea.next();
				}
				
				posaAttrezzo(nomeAttrezzo, Integer.parseInt(pesoAttrezzo), nomeStanza);
			}
		}

		private void posaAttrezzo(String nomeAttrezzo, int pesoAttrezzo, String nomeStanza) throws FormatoFileNonValidoException {
			try {
				check(isStanzaValida(nomeStanza),"Attrezzo "+ nomeAttrezzo+" non collocabile: stanza " +nomeStanza+" inesistente");
				
				this.builder.addAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
			}
			catch (NumberFormatException e) {
				check(false, "Peso attrezzo "+nomeAttrezzo+" non valido");
			}
		}


		private boolean isStanzaValida(String nomeStanza) {
			return this.builder.nome2stanza.containsKey(nomeStanza);
		}

		private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
			String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);
			for(String adiacenza : this.separaStringheAlleVirgole(specificheUscite)) {
				try (Scanner scannerDiLinea = new Scanner(adiacenza)) {			
					while (scannerDiLinea.hasNext()) {
						check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("le uscite di una stanza."));
						String stanzaPartenza = scannerDiLinea.next();
						check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la direzione di una uscita della stanza "+stanzaPartenza));
						String dir = scannerDiLinea.next();
						check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la destinazione di una uscita della stanza "+stanzaPartenza+" nella direzione "+dir));
						String stanzaDestinazione = scannerDiLinea.next();
						impostaUscita(stanzaPartenza, dir, stanzaDestinazione);
					}
				}
			}
		}
		
		private String msgTerminazionePrecoce(String msg) {
			return "Terminazione precoce del file prima di leggere "+msg;
		}

		private void impostaUscita(String stanzaDa, String dir, String nomeA) throws FormatoFileNonValidoException {
			check(isStanzaValida(stanzaDa),"Stanza di partenza sconosciuta "+dir);
			check(isStanzaValida(nomeA),"Stanza di destinazione sconosciuta "+ dir);
			Direzione direzione = Direzione.valueOf(dir.toUpperCase());
			this.builder.addAdiacenza(stanzaDa, nomeA, direzione);
		}

		final private void check(boolean condizioneCheDeveEsseraVera, String messaggioErrore) throws FormatoFileNonValidoException {
			if (!condizioneCheDeveEsseraVera)
				throw new FormatoFileNonValidoException("Formato file non valido [" + this.reader.getLineNumber() + "] "+messaggioErrore);		
		}
	}
}