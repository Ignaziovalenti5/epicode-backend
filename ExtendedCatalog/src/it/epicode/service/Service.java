package it.epicode.service;

import java.time.LocalDate;

import it.epicode.catalog.Book;
import it.epicode.catalog.Catalog;
import it.epicode.catalog.Magazine;
import it.epicode.catalog.Periodicity;
import it.epicode.dao.CatalogDAO;
import it.epicode.dao.LoanDAO;
import it.epicode.loan.Loan;
import it.epicode.loan.User;

//Definizione della classe di servizio
public class Service {

	CatalogDAO serviceCatalog = new CatalogDAO();
	LoanDAO serviceLoan = new LoanDAO();

	public Service() {
	}

	Catalog book1 = new Book("1234", "Libro 1", "2012", 963, "Autore 1", "Fantasy");
	Catalog book2 = new Book("1534", "Libro 2", "2018", 763, "Autore 2", "Adventure");
	Catalog book3 = new Book("4294", "Libro 3", "2020", 523, "Autore 3", "Dramatic");
	Catalog book4 = new Book("3234", "Libro 4", "2010", 876, "Autore 1", "Adventure");
	Catalog book5 = new Book("7034", "Libro 5", "2022", 126, "Autore 2", "Fantasy");
	Catalog magazine1 = new Magazine("1321", "Rivista 1", "2020", 23, Periodicity.MENSILE);
	Catalog magazine2 = new Magazine("2721", "Rivista 2", "2019", 43, Periodicity.SETTIMANALE);
	Catalog magazine3 = new Magazine("4381", "Rivista 3", "2012", 51, Periodicity.SEMESTRALE);
	Catalog magazine4 = new Magazine("9321", "Rivista 4", "2018", 22, Periodicity.MENSILE);
	Catalog magazine5 = new Magazine("4322", "Rivista 5", "2022", 63, Periodicity.SETTIMANALE);

	User user1 = new User("Name1", "Surname1", LocalDate.of(1960, 8, 5), 3266732);
	User user2 = new User("Name2", "Surname2", LocalDate.of(1960, 8, 5), 5464564);

	Loan loan1 = new Loan(user1, book1, LocalDate.now());
	Loan loan2 = new Loan(user2, book2, LocalDate.of(1998, 5, 21));
	Loan loan3 = new Loan(user1, book3, LocalDate.of(2011, 5, 21));

	public void populateCatalogDatabase() {
		serviceCatalog.addCatalogElement(book1);
		serviceCatalog.addCatalogElement(book2);
		serviceCatalog.addCatalogElement(book3);
		serviceCatalog.addCatalogElement(book4);
		serviceCatalog.addCatalogElement(book5);
		serviceCatalog.addCatalogElement(magazine1);
		serviceCatalog.addCatalogElement(magazine2);
		serviceCatalog.addCatalogElement(magazine3);
		serviceCatalog.addCatalogElement(magazine4);
		serviceCatalog.addCatalogElement(magazine5);
	}

	public void populateUsersDatabase() {
		serviceLoan.addUser(user1);
		serviceLoan.addUser(user2);
	}

	public void populateLoansDatabase() {
		serviceLoan.addLoan(loan1);
		serviceLoan.addLoan(loan2);
		serviceLoan.addLoan(loan3);
	}

}
