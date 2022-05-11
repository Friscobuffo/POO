package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	private String direzioneBloccata;
	private String attrezzoSbloccaDirezione;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccaDirezione) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccaDirezione = attrezzoSbloccaDirezione;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzione.equals(direzioneBloccata)) {
			if (this.hasAttrezzo(attrezzoSbloccaDirezione))
				return super.getStanzaAdiacente(direzione);
			else return this;
		}
		else return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(attrezzoSbloccaDirezione))
			return super.getDescrizione();
		else {
			return (super.getDescrizione() + "\nLa direzione '" + this.direzioneBloccata + "' e' bloccata");
		}
	}
}
