package ant.formica;

import static ant.costanti.CostantiSimulazione.PROBABILITA_CAMBIO_DIREZIONE;
import static ant.costanti.CostantiGUI.IMMAGINE_FORMICA_ROSSA;
import static ant.simulatore.GeneratoreCasuale.siVerificaEventoDiProbabilita;

import java.awt.Image;
import java.util.Set;

import ant.Ambiente;
import ant.Direzione;

public class Aggressiva extends Formica {

	static private int progId=0;

	public Aggressiva(Ambiente ambiente) {
		super(ambiente, progId++);
	}

	@Override
	public boolean decideDiCambiareDirezione() {
		Direzione direzione = this.getAmbiente().getDirezioneCiboVicino(this.getPosizione());
		if (direzione != null) return true;

		return ( siVerificaEventoDiProbabilita(PROBABILITA_CAMBIO_DIREZIONE) ) ;
	}

	@Override
	public Direzione cambioDirezione(Set<Direzione> possibili) {
		Direzione direzione = this.getAmbiente().getDirezioneCiboVicino(this.getPosizione());
		if (direzione != null) return direzione;
		return Direzione.scegliAcasoTra(possibili);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_FORMICA_ROSSA;
	}

}
