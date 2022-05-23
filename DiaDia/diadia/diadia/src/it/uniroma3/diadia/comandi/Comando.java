package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class Comando{
	
	private IO io;
	private String parametro;
	
	public abstract void esegui(Partita partita);

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getNome() {
		return this.getClass().getName().substring(27); //rimuove it.uniroma3.diadia.comandi.
	}

	public String getParametro() {
		return this.parametro;
	}

	public void setIo(IO io) {
		this.io = io;
	}
	
	public IO getIo() {
		return this.io;
	}
}
