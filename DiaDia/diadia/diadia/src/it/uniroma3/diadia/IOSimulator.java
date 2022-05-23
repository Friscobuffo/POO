package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IOSimulator implements IO {

	private List<String> istruzioni;
	private List<String> messaggiProdotti;
	private Iterator<String> iteratorIstruzioni;
	
	public IOSimulator() {
		this.messaggiProdotti = new ArrayList<>();
	}
	
	public IOSimulator(List<String> istruzioni) {
		this.istruzioni = istruzioni;
		this.messaggiProdotti = new ArrayList<>();
		this.iteratorIstruzioni = this.istruzioni.iterator();
	}

	@Override
	public void mostraMessaggio(String msg) {
		messaggiProdotti.add(msg);
	}

	@Override
	public String leggiRiga() {
		String riga = null;
		if(iteratorIstruzioni.hasNext()) {
			riga = iteratorIstruzioni.next();
		}
		return riga;
	}
	
	public List<String> getMessaggiProdotti() {
		return this.messaggiProdotti;
	}
}
