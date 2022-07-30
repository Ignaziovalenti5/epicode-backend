package it.epicode.catalogo;

// Definizione della sottoclasse per il libro, che deve estendere la classe madre
public class Book extends Catalog {

	private String author;
	private String genre;

	// Definizione del costruttore
	public Book(String iSBNcode, String title, String publicationYear, int numOfPage, String author, String genre) {
		super(iSBNcode, title, publicationYear, numOfPage);
		this.author = author;
		this.genre = genre;
	}

	// GETTERS AND SETTERS
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	// Override del metodo toString()
	@Override
	public String toString() {
		return iSBNCode + ";" + title + ";" + publicationYear + ";" + numOfPage + ";" + author + ";" + genre;
	}

}
