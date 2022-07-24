package it.epicode.player;

public class Audio extends MultimediaElement implements IPlayable {

	private int volume;
	private int duration;

	// Definizione del costruttore della classe Audio
	public Audio(String titolo, int volume, int duration) {

		super(titolo);
		this.volume = volume;
		this.duration = duration;
	}

	// Override dei metodi dell'interfaccia IPlayable ( degli ogetti riporducibili)

	@Override
	public void increaseVolume() { // metodo per aumentare il volume
		volume++;
	}

	@Override
	public void decreaseVolume() { // metodo per diminuire il volume
		volume--;
	}

	// Override del metodo play() esclusivo per gli oggetti di tipo Audio
	@Override
	public void play() {

		String exclamation = "";

		// aggiunta di punti esclamativi pari al volume
		for (int i = 0; i < volume; i++) {
			exclamation += "!";
		}

		// stampa n. righe pari alla durata
		for (int i = 0; i < duration; i++) {
			System.out.println("(aud) Titolo: " + titolo + " ( Vol: " + exclamation + " )");

		}

		// stampa di fine ciclo con indicazione della durata
		System.out.println("L'audio è terminato! ( Durata: " + duration + " )");
	}
}
