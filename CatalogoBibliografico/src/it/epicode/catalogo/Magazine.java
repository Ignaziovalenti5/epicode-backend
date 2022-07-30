package it.epicode.catalogo;

// Definizione della sottoclasse per la rivista, che deve estendere la classe madre
public class Magazine extends Catalog {

	Periodicity periodicity;

	// Definizione del costruttore riguardante le riviste
	public Magazine(String iSBNcode, String title, String publicationYear, int numOfPage, Periodicity periodicity) {
		super(iSBNcode, title, publicationYear, numOfPage);
		this.periodicity = periodicity;
	}

	// GETTERS AND SETTERS
	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	// Override del metodo toString()
	@Override
	public String toString() {
		return iSBNCode + ";" + title + ";" + publicationYear + ";" + numOfPage + ";" + periodicity;
	}

}
