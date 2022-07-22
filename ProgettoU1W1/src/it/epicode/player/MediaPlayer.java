package it.epicode.player;

// importazione scanner per selezione da console
import java.util.Scanner;

public class MediaPlayer {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// creazione contenitore dei 5 media visualizzabili
		MultimediaElement[] mediaContainer = new MultimediaElement[5];

		// metodo per popolare l'array di media
		populateMediaArray(mediaContainer);

		// metodo per far scegliere all'utente quale media riprodurre
		chooseMedia(mediaContainer);

	}

	public static void populateMediaArray(MultimediaElement[] arr) {

		// ciclo per creazione elementi multimediali
		for (int i = 0; i < arr.length; i++) {

			System.out.println("Creazione oggetto multimediale  ( " + (i + 1) + " di 5 )");
			System.out.println("Che tipo di file multimediale si desidera creare?");
			System.out.println("Digita:");
			System.out.println("(1: Audio) (2: Video) (3: Immagine)");

			// variabile scelta dall'utente
			int tipologia = Integer.parseInt(scanner.nextLine());

			if (tipologia == 1) {
				System.out.println("Inserisci il title della traccia audio");

				String title = scanner.nextLine();

				System.out.println("inserisci il volume");
				int volume = Integer.parseInt(scanner.nextLine());
				System.out.println("inserisci la durata");
				int duration = Integer.parseInt(scanner.nextLine());

				Audio x = new Audio(title, volume, duration);

				arr[i] = x;
			} else if (tipologia == 2) {

				System.out.println("Inserisci il titolo del video");
				String title = scanner.nextLine();
				System.out.println("inserisci la luminosità");
				int luminosity = Integer.parseInt(scanner.nextLine());
				System.out.println("inserisci la durata");
				int duration = Integer.parseInt(scanner.nextLine());
				System.out.println("inserisci il volume");
				int volume = Integer.parseInt(scanner.nextLine());
				Video x = new Video(title, luminosity, duration, volume);
				arr[i] = x;
			} else {
				System.out.println("Inserisci il titolo dell'immagine");
				String title = scanner.nextLine();
				System.out.println("inserisci la luminosità");
				int luminosity = Integer.parseInt(scanner.nextLine());
				Immagine x = new Immagine(title, luminosity);
				arr[i] = x;

			}

		}

	}

	public static void chooseMedia(MultimediaElement[] arr) {

		int elementoMedia = 0;

		// ciclo per scegliere il file da riprodurre
		do {
			System.out
					.println("Quale file vuoi riprodurre? digita un numero da 1 a 5 oppure 0 per uscire");
			elementoMedia = Integer.parseInt(scanner.nextLine());

			if (elementoMedia == 0) {
				System.out.println("riproduzione terminata");
			}

			// determina il tipo di oggetto scelto ed esegue il rispettivo metodo
			else if (arr[elementoMedia - 1] instanceof IDisplayable) {
				((IDisplayable) arr[elementoMedia - 1]).show();
			}

			else if (arr[elementoMedia - 1] instanceof IPlayable) {
				((IPlayable) arr[elementoMedia - 1]).play();
			}

		} while (elementoMedia != 0); // termina ciclo con scelta "0" da parte dell'utente
	}

}
