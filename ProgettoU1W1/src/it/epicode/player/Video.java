package it.epicode.player;

public class Video extends MultimediaElement implements IPlayable {
	private int volume;
	private int luminosity;
	private int duration;

	// Definizione costruttore della classe Video
	public Video(String titolo, int luminosity, int duration, int volume) {
		super(titolo);
		this.luminosity = luminosity;
		this.duration = duration;
		this.volume = volume;
	}

	public void increaseLuminosity() { // metodo per aumentare la luminosità
		luminosity++;
	}

	public void decreaseLuminosity() { // metodo per diminuire la luminosità
		luminosity--;
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

	// Override del metodo play() esclusivo per gli oggetti di tipo Video
	@Override
	public void play() {
		String asterisk = "";
		String exclamation = "";

		// aggiunta di asterischi pari alla luminosità
		for (int i = 0; i < luminosity; i++) {
			asterisk += "*";
		}

		// aggiunta di punti esclamativi pari al volume
		for (int i = 0; i < volume; i++) {
			exclamation += "!";
		}

		// stampa n. righe pari alla durata
		for (int i = 0; i < duration; i++) {
			System.out.println("(vid) Titolo: " + titolo + " ( Vol: " + exclamation + " - Lum: " + asterisk + " )");

		}

		// stampa di fine ciclo con indicazione della durata
		System.out.println("IL video è terminato! ( Durata: " + duration + " )");

	}

}