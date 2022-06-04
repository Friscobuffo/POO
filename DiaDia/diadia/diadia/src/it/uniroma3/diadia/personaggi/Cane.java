package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {

	private static final String MESSAGGIO_MORSO = "Ah, il cane mi ha morso";
	private final static String PRESENTAZIONE_CANE = "woof woof";
	public final static String OSSO = "osso";
	public final static String CHIAVE = "chiave";


	private Attrezzo attrezzo;

	public Cane() {
		super(null, null);
		this.attrezzo = new Attrezzo(CHIAVE, 1);
	}

	@Override
	public String agisci(Partita partita) {
		int cfu = partita.getGiocatore().getCfu() -1;
		partita.getGiocatore().setCfu(cfu);
		return MESSAGGIO_MORSO;
	}

	@Override
	public String saluta() {
		return PRESENTAZIONE_CANE;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (this.attrezzo.getNome().equals(OSSO)) {
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			return "Il cane sembra gia felice con il suo osso\n"
					+ "Lascia cadere l'attrezzo nella stanza";
		}
					
		if (attrezzo.getNome().equals(OSSO)) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = attrezzo;
			return "Il cane sembra felice e ha lasciato cadere un oggetto nella stanza...";
		}
		
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(--cfu);
		return "Il cane non sembra apprezzare l'attrezzo \n"
				+ "Ti ha morso ed hai perso un CFU. \n"
				+ "L'attrezzo e' caduto per terra nella stanza.";
	}
}
