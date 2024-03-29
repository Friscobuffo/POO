package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	private Direzione direzioneBloccata;
	private String attrezzoSbloccaDirezione;
	
	public StanzaBloccata(String nome, Direzione direzioneBloccata, String attrezzoSbloccaDirezione) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccaDirezione = attrezzoSbloccaDirezione;
	}

	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if (!direzione.equals(direzioneBloccata) || this.hasAttrezzo(attrezzoSbloccaDirezione)) 
			return super.getStanzaAdiacente(direzione);
		return this;
	}
	
	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(attrezzoSbloccaDirezione))
			return super.getDescrizione();
		return (super.getDescrizione()+ "\nLa direzione '" +this.direzioneBloccata+ "' e' bloccata");
	}
}
