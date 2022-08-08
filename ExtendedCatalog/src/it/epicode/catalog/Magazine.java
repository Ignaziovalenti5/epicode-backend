package it.epicode.catalog;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

//Definizione della sottoclasse per la rivista, che deve estendere la classe madre
@Entity
public class Magazine extends Catalog {

	@Enumerated(EnumType.STRING)
	Periodicity periodicity;

	// Definizione del costruttore riguardante le riviste
	public Magazine(String iSBNCode, String title, String publicationYear, int numOfPage, Periodicity periodicity) {
		super(iSBNCode, title, publicationYear, numOfPage);
		this.periodicity = periodicity;
	}

	// Definizione del costruttore vuoto
	public Magazine() {

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
		return "Rivista [ periodicità : " + periodicity + ", codiceISBN : " + iSBNCode + ", titolo : " + title
				+ ", annoPublicazione : " + publicationYear + ", nPagine : " + numOfPage + " ]";
	}

}
