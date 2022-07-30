package it.epicode.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.catalogo.ArchiveMain;
import it.epicode.catalogo.Book;
import it.epicode.catalogo.Catalog;
import it.epicode.catalogo.Magazine;
import it.epicode.catalogo.Periodicity;

// Definizione della classe di servizio per le operazioni su disco, che implementa i metodi tramite l'interfaccia
public class DiskOperation implements DiskOperationInterface {

	private static final Logger Log = LoggerFactory.getLogger(ArchiveMain.class);

	private Map<String, Catalog> mainCatalog;

	// Definizione del costruttore per creare l'oggetto di servizio riguardante le
	// operazioni su disco
	public DiskOperation(Map<String, Catalog> mainCatalog) {

		this.mainCatalog = mainCatalog;
	}

	// Override dei metodi dell'interfaccia
	@Override
	public void saveOnDisk() throws IOException {

		try {
			String catalogToText = "";

			for (Catalog cat : mainCatalog.values()) {
				catalogToText += (cat.toString() + "\n");
			}

			File catalogFile = new File("./catalog.csv");
			FileUtils.writeStringToFile(catalogFile, catalogToText, StandardCharsets.ISO_8859_1);

			Log.info("Archivio caricato correttamente");

		} catch (IOException e) {
			Log.error("Il caricamento dell'archivio non è andato a buon fine!" + e);
		}

	}

	@Override
	public Map<String, Catalog> loadFromDisk() throws IOException {

		try {
			File file = new File("./catalog.csv");
			List<String> lines = FileUtils.readLines(file, StandardCharsets.ISO_8859_1);

			mainCatalog = lines.stream()
					.map(line -> line.split(";"))
					.map(el -> {

						if (el.length == 6) {
							return new Book(el[0], el[1], el[2], Integer.parseInt(el[3]), el[4], el[5]);
		
						} else {
							return new Magazine(el[0], el[1], el[2], Integer.parseInt(el[3]), Periodicity.valueOf(el[4]));
						}
		
					}).collect(Collectors.toMap(c -> c.getISBNCode(), c -> c));

			Log.info("La lettura dell'archivio è andata a buon fine.");

			return mainCatalog;

		} catch (IOException e) {
			Log.error("La lettura del file non è andata a buon fine!" + e);
		}

		return mainCatalog;
	}

}
