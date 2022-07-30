package it.epicode.catalogo;

// Definizione della classe astratta in comune con entrambi i tipi (Libri e Riviste)
public abstract class Catalog {

	protected String iSBNCode;
	protected String title;
	protected String publicationYear;
	protected int numOfPage;

	// Definizione del costruttore vuoto
	public Catalog() {

	}

	// Definizione del costruttore parametrizzato
	public Catalog(String iSBNcode, String title, String publicationYear, int numOfPage) {
		this.iSBNCode = iSBNcode;
		this.title = title;
		this.publicationYear = publicationYear;
		this.numOfPage = numOfPage;
	}

	// GETTERS AND SETTERS
	public String getISBNCode() {
		return iSBNCode;
	}

	public void setISBNCode(String iSBNcode) {
		this.iSBNCode = iSBNcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public int getNumOfPage() {
		return numOfPage;
	}

	public void setNumOfPage(int numOfPage) {
		this.numOfPage = numOfPage;
	}

}
