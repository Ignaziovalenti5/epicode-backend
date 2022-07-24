package it.epicode.player;

//Interfaccia per i media riproducibili
public interface IPlayable {

	// Metodi per aumentare o diminuire il volume
	public void increaseVolume();

	public void decreaseVolume();

	// Metodo per mostrare l'oggetto
	public void play();

}
