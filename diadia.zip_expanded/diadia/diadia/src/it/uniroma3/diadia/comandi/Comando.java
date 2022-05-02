package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public interface Comando {

	public void esegui (Partita partita);
	
	public void setParametro (String parametro);
	
	public void setIo(IO io);
	public IO getIo();
	public String getNome();
	public String getParametro();
}
