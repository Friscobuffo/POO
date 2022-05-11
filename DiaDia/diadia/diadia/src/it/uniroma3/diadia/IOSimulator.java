package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IOSimulator implements IO {

	private List<String> istruzioni;
	private Map<String, List<String>> messaggiProdotti;
	private Iterator<String> iteratorIstruzioni;
	private String ultimaRigaLetta;
	
	public IOSimulator() {
		this.messaggiProdotti = new HashMap<>();
	}
	
	public IOSimulator(List<String> istruzioni) {
		this.istruzioni = istruzioni;
		this.messaggiProdotti = new HashMap<>();
		this.iteratorIstruzioni = this.istruzioni.iterator();
	}

	@Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
		if (ultimaRigaLetta==null)
			return;
		
		List<String> messaggi = this.messaggiProdotti.get(ultimaRigaLetta);
		if (messaggi==null) {
			messaggi = new ArrayList<>();
			this.messaggiProdotti.put(msg, messaggi);
		}
		messaggi.add(msg);
	}

	@Override
	public String leggiRiga() {
		String riga = null;
		if(iteratorIstruzioni.hasNext()) {
			riga = iteratorIstruzioni.next();
			System.out.println("\n -:" + riga);
		}
		this.ultimaRigaLetta = riga;
		return riga;
	}
}
