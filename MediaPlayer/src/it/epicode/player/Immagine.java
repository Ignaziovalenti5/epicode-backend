package it.epicode.player;

public class Immagine extends MultimediaElement implements IDisplayable {

	int luminosity;

	// Definizione costruttore della classe Immagine
	public Immagine(String titolo, int luminosity) {
		super(titolo);
		this.luminosity = luminosity;
	}

	// Override dei metodi dell'interfaccia IDisplayable ( degli ogetti non riporducibili)

	@Override
	public void increaseLuminosity() { // metodo per aumentare la luminosità
		luminosity++;
	}

	@Override
	public void decreaseLuminosity() { // metodo per diminuire la luminosità
		luminosity--;
	}

	// Override del metodo show relativo agli oggetti di tipo "non riporducibili"
	@Override
	public void show() {

		String asterisk = "";

		// aggiunta di asterischi pari alla luminosità
		for (int i = 0; i < luminosity; i++) {
			asterisk += "*";
		}

		// stampa dell'oggetto con indicazione della luminosità
		System.out.println("(img) Titolo: " + titolo + " ( Lum: " + asterisk + " )");

	}

}
