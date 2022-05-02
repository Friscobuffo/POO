package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends BaseComando{
	
	private final static String NOME = "ComandoNonValido";
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Inserire un comando valido.");
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
}
