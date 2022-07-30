package it.epicode.services;

import java.util.Map;

import it.epicode.catalogo.Catalog;

// Definizione dell'interfaccia per la ricerca
public interface SearchInterface {
	public Map<String, Catalog> searchForAuthor(String author) ;
	public Map<String, Catalog>searchForPublicationYear(String pubblicationYear);
	public Map<String, Catalog> searchForISBNCode(String ISBNCode);
}
