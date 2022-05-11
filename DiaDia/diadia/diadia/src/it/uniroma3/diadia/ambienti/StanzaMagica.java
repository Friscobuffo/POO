package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{

	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	private final static int SOGLIA_MAGICA_DEFAULT = 3;
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		sogliaMagica = soglia;
	}

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		return attrezzo;
	}
	
	@Override
	public Attrezzo addAttrezzo(Attrezzo attrezzo) {
		if (++contatoreAttrezziPosati > sogliaMagica) {
			attrezzo = modificaAttrezzo(attrezzo);
		}
		return super.addAttrezzo(attrezzo);
	}
}
