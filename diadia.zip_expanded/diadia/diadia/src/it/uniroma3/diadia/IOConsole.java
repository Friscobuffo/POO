package it.uniroma3.diadia;
import java.util.Scanner;

/**
 * Centralizza l’accesso a System.out/System.in in un'unica classe
 * 
 * @author Docente di POO
 * 
 * @version base
 */
public class IOConsole implements IO{
	
	/**
	 * Stampa un messaggio a schermo senza andare a capo
	 * 
	 * @param msg stringa con il messaggio
	 */
	
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	/**
	 * Legge una stringa da tastiera
	 * 
	 * @return la stringa immessa
	 */
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}
