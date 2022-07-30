package it.epicode.catalogo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import it.epicode.services.DiskOperation;
import it.epicode.services.Search;
import it.epicode.services.Service;

public class ArchiveMain {

	// Catalogo popolato con il metodo della classe di servizio
	private static Map<String, Catalog> mainCatalog = new Service().populateCatalog();

	public static void main(String[] args) throws IOException {

		// Stampa di tutti gli elementi del catalogo
		System.out.println("CATALOGO INIZIALE COMPLETO:\n");
		mainCatalog.forEach((k, v) -> System.out.println(v));
		System.out.println("\n----------------------------\n");

		// Stampa del risultato della ricerca per anno
		String variableYear = "2020";
		System.out.println("RICERCA PER ANNO DI PUBBLICAZIONE : (" + variableYear + ")\n");
		Map<String, Catalog> filteredCatForYear = new Search(mainCatalog).searchForPublicationYear(variableYear);
		filteredCatForYear.forEach((k, v) -> System.out.println(v));
		System.out.println("\n----------------------------\n");

		// Stampa del risultato della ricerca per codice ISBN
		String variableISBNCode = "3234";
		System.out.println("RICERCA PER CODICE ISBN : (" + variableISBNCode + ")\n");
		Map<String, Catalog> filteredCatForISBNCode = new Search(mainCatalog).searchForISBNCode(variableISBNCode);
		filteredCatForISBNCode.forEach((k, v) -> System.out.println(v));
		System.out.println("\n----------------------------\n");

		// Stampa del risultato della ricerca per autore
		String authorToSearch = "Autore 1";
		System.out.println("RICERCA PER AUTORE : (" + authorToSearch + ")\n");
		Map<String, Catalog> filteredCatForAuthor = new Search(mainCatalog).searchForAuthor(authorToSearch);
		filteredCatForAuthor.forEach((k, v) -> System.out.println(v));
		System.out.println("\n----------------------------\n");

		// Salvataggio della stringa contenente tutte gli elementi del catalogo
		DiskOperation diskOp = new DiskOperation(mainCatalog);
		System.out.println("SALVATAGGIO FILE SUL DISCO\n");
		diskOp.saveOnDisk();
		System.out.println("\n----------------------------\n");

		// Lettura del file salvato sul disco
		// Una riga per ogni elemento del catalogo
		System.out.println("LETTURA DAL DISCO:\n");
		Map<String, Catalog> catalogFromDisk = diskOp.loadFromDisk();
		catalogFromDisk.forEach((k, v) -> System.out.println(v));

	}

}
