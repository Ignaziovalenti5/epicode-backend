package it.epicode.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import it.epicode.catalogo.Catalog;

// Definizione dell'interfaccia per le operazioni di scrittura e lettura dell'archivio sul disco locale
public interface DiskOperationInterface {

	public void saveOnDisk() throws IOException;

	public Map<String, Catalog> loadFromDisk() throws IOException;

}
