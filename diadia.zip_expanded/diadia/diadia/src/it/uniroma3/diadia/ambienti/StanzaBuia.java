package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private String attrezzoSpeciale;
	protected final static String BUIO = "qui c'e' buio pesto";
	
	public StanzaBuia(String nome, String attrezzoSpeciale) {
		super(nome);
		this.attrezzoSpeciale = attrezzoSpeciale;
	}

	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(this.attrezzoSpeciale)) return super.getDescrizione();
		else return BUIO;
	}
}
