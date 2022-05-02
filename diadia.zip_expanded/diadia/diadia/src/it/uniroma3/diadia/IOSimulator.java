package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IOSimulator implements IO {

	private List<String> istruzioni;
	private List<String> messaggi;
	private Iterator<String> iteratorIstruzioni;
	
	public IOSimulator() {
		this.messaggi = new ArrayList<String>();
	}
	
	public IOSimulator(List<String> istruzioni) {
		this.istruzioni = istruzioni;
		this.messaggi = new ArrayList<String>();
		this.iteratorIstruzioni = this.istruzioni.iterator();
	}

	@Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
		this.messaggi.add(msg);
	}

	@Override
	public String leggiRiga() {
		String riga = null;
		if(iteratorIstruzioni.hasNext()) {
			riga = iteratorIstruzioni.next();
			System.out.println("\n -:" + riga);
		}
		return riga;
	}
}
