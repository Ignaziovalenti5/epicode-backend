package it.epicode.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.catalogo.ArchiveMain;
import it.epicode.catalogo.Catalog;

// Definizione della classe di servizio per le operazioni su disco, che implementa i metodi tramite l'interfaccia
public class DiskOperation implements DiskOperationInterface {

	private static final Logger Log = LoggerFactory.getLogger(ArchiveMain.class);

	private Map<String, Catalog> mainCatalog;

	// Definizione del costruttore per creare l'oggetto di servizio riguardante le operazioni su disco
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

			File catalogFile = new File("./catalog.txt");
			FileUtils.writeStringToFile(catalogFile, catalogToText, "UTF-8");

			Log.info("Archivio caricato correttamente");

		} catch (IOException e) {
			Log.error("Il caricamento dell'archivio non è andato a buon fine!" + e);
		}

	}

	@Override
	public List<String> loadFromDisk() throws IOException {
		List<String> listaRead = new ArrayList<String>();
		try {
			File file = new File("./catalog.txt");

			String readString = FileUtils.readFileToString(file, "UTF-8");
			String[] catalog = readString.split(";");

			for (String element : catalog) {
				System.out.println(element);
			}

			Log.info("La lettura dell'archivio è andata a buon fine.");
			return listaRead;

		} catch (IOException e) {
			Log.error("La lettura del file non è andata a buon fine!" + e);
		}
		return listaRead;
	}

}
