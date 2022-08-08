package it.epicode.catalog;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

//Definizione della classe astratta in comune con entrambi i tipi (Libri e Riviste)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Catalogo", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "searchForISBNCode", query = "SELECT a FROM Catalog a WHERE a.iSBNCode = :isbn")
@NamedQuery(name = "searchForPubblicationYear", query = "SELECT a FROM Catalog a WHERE a.publicationYear = :year")
@NamedQuery(name = "searchForTitleOrParts", query = "SELECT a FROM Catalog a WHERE a.title LIKE :title")
public abstract class Catalog {

	@Id
	@SequenceGenerator(name = "catalog_seq", sequenceName = "catalog_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalog_seq")
	protected int id;

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
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
