package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends Comando{
	
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Inserire un comando valido.");
	}
}
