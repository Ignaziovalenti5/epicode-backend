package it.epicode.dao;

import java.util.List;

import it.epicode.catalog.Book;
import it.epicode.catalog.Catalog;

public interface CatalogDAOInterface {
	
	
//	- Aggiunta di un elemento del catalogo
	void addCatalogElement(Catalog element);
	
//	- Rimozione di un elemento del catalogo dato un codice ISBN
	void removeCatalogElement(String isbnCode);
	
//	- Ricerca per ISBN
	Catalog searchForIsbnCode(String isbnCode);
	
//	- Ricerca per anno pubblicazione
	List<Catalog> searchForPubblicationYear(String year);

//	- Ricerca per autore
	List<Book> searchForAuthor(String author);

//	- Ricerca per titolo o parte di esso
	List<Catalog> searchForTitle(String title);

}
