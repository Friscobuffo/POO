package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 * @see IOConsole
 * @see Partita
 * @see ComandoOld       
 *          
 * @version base
 */

public class DiaDia {

	private IO io;
	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;

	public DiaDia(IO io, Labirinto labirinto) {
		this.io = io;
		this.partita = new Partita(labirinto);
	}

	public void gioca() {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.setIo(this.io);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			io.mostraMessaggio("Hai vinto!");
		if (!this.partita.getGiocatore().isVivo())
			io.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}   

	public static void main(String[] argc) {
		IO io = new IOConsole();		
		DiaDia gioco = new DiaDia(io, creaLabirinto());
		gioco.gioca();
	}
	
	public static Labirinto creaLabirinto() {
		return new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso",1)
				.addStanza("Aula N10")
				.addAttrezzo("lanterna", 3)
				.addStanza("Aula N11")
				.addStanza("Laboratorio Campus")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", Stanza.NORD)
				.addAdiacenza("Aula N11", Stanza.EST)
				.addAdiacenza("Aula N10", Stanza.SUD)
				.addAdiacenza("Laboratorio Campus", Stanza.OVEST)
				.addAdiacenza("Aula N11", "Laboratorio Campus", Stanza.EST)
				.addAdiacenza("Atrio", Stanza.OVEST)
				.addAdiacenza("Aula N10", "Atrio", Stanza.NORD)
				.addAdiacenza("Aula N11", Stanza.EST)
				.addAdiacenza("Laboratorio Campus", Stanza.OVEST)
				.addAdiacenza("Laboratorio Campus", "Atrio", Stanza.EST)
				.addAdiacenza("Aula N11", Stanza.OVEST)
				.addAdiacenza("Biblioteca", "Atrio", Stanza.SUD)
				.getLabirinto();
	}
}