package it.epicode.services;

import java.util.Map;
import java.util.stream.Collectors;

import it.epicode.catalogo.Book;
import it.epicode.catalogo.Catalog;

// Definizione della classe per le operazioni di ricerca, che implementa i metodi tramite l'interfaccia
public class Search implements SearchInterface {

	private Map<String, Catalog> mainCatalog;

	// Definizione del costruttore per creare l'oggetto di servizio riguardante le ricerche
	public Search(Map<String, Catalog> mainCatalog) {

		this.mainCatalog = mainCatalog;
	}

	// Override dei metodi dell'interfaccia
	@Override
	public Map<String, Catalog> searchForAuthor(String author) {
		return mainCatalog.values().stream()
				.filter(e -> e instanceof Book && ((Book) e).getAuthor().equalsIgnoreCase(author))
				.collect(Collectors.toMap(c -> c.getISBNCode(), c -> c));
	}

	@Override
	public Map<String, Catalog> searchForPublicationYear(String pubblicationYear) {
		return mainCatalog.values().stream()
				.filter(e -> e.getPublicationYear().equalsIgnoreCase(pubblicationYear))
				.collect(Collectors.toMap(c -> c.getISBNCode(), c -> c));

	}

	@Override
	public Map<String, Catalog> searchForISBNCode(String ISBNCode) {
		return mainCatalog.values().stream()
				.filter(e -> e.getISBNCode().equalsIgnoreCase(ISBNCode))
				.collect(Collectors.toMap(c -> c.getISBNCode(), c -> c));

	}

}
