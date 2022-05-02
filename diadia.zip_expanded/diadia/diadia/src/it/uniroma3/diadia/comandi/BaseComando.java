package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class BaseComando implements Comando{
	
	private IO io;
	private String parametro;
	
	@Override
	public void esegui(Partita partita) {}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public String getNome() {
		return null;
	}

	@Override
	public String getParametro() {
		return this.parametro;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	@Override
	public IO getIo() {
		return this.io;
	}
}
