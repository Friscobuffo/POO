package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private String attrezzoLuce;
	protected final static String BUIO = "qui c'e' buio pesto...";
	
	public StanzaBuia(String nome, String attrezzoSpeciale) {
		super(nome);
		this.attrezzoLuce = attrezzoSpeciale;
	}

	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(this.attrezzoLuce)) return super.getDescrizione();
		else return BUIO;
	}
}
