package it.epicode.dao;

import java.util.List;

import it.epicode.loan.Loan;
import it.epicode.loan.User;

public interface LoanDAOInterface {

	// - Ricerca degli elementi attualmente in prestito dato un numero di tessera
	// utente
	Loan searchForUserCard(int userCard);

	// - Ricerca di tutti i prestiti scaduti e non ancora restituiti
	List<Loan> searchAllExpiredLoans();

	// Aggiunta al database del prestito e dell'utente
	public void addLoan(Loan loan);

	public void addUser(User user);

}
