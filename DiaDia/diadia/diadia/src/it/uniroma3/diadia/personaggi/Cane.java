package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public class Cane extends AbstractPersonaggio {

	private static final String MESSAGGIO_MORSO = "Ah, il cane mi ha morso";
	private final static String PRESENTAZIONE_CANE = "woof woof";
	
	public Cane() {
		super(null, null);
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
}
