package it.epicode.services;

import java.io.IOException;
import java.util.List;

// Definizione dell'interfaccia per le operazioni di scrittura e lettura dell'archivio sul disco locale
public interface DiskOperationInterface {

	public void saveOnDisk() throws IOException;

	public List<String> loadFromDisk() throws IOException;

}
