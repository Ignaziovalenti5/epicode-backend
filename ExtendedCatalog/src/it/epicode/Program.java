package it.epicode;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.catalog.Book;
import it.epicode.catalog.Catalog;
import it.epicode.dao.CatalogDAO;
import it.epicode.dao.LoanDAO;
import it.epicode.loan.Loan;
import it.epicode.service.Service;

public class Program {
	public static void main(String[] args) {

		final Logger log = LoggerFactory.getLogger(Program.class);

		Service service = new Service();

		CatalogDAO serviceCatalog = new CatalogDAO();
		LoanDAO serviceLoan = new LoanDAO();

		service.populateCatalogDatabase();
		service.populateUsersDatabase();
		service.populateLoansDatabase();

		serviceCatalog.removeCatalogElement("1534");

		Catalog searchElement1 = serviceCatalog.searchForIsbnCode("1234");
		log.info("RICERCA PER ISBN: " + searchElement1);

		List<Catalog> searchElements2 = serviceCatalog.searchForPubblicationYear("2012");
		for (Catalog e : searchElements2) {
			log.info("RICERCA PER ANNO: " + e);
		}

		List<Book> searchElements3 = serviceCatalog.searchForAuthor("Autore 1");
		for (Catalog e : searchElements3) {
			log.info("RICERCA PER AUTORE: " + e);
		}

		List<Catalog> searchElements4 = serviceCatalog.searchForTitle("Libro");
		for (Catalog e : searchElements4) {
			log.info("RICERCA PER TITOLO: " + e);
		}

		serviceLoan.returnCatalog(3);

		List<Loan> searchLoans1 = serviceLoan.searchLoansByCardNumber(3266732);
		for (Loan l : searchLoans1) {
			log.info("RICERCA PRESTITI PER N° TESSERA: " + l);
		}

		List<Loan> searchLoans2 = serviceLoan.searchExpiredLoans();
		for (Loan l : searchLoans2) {
			log.info("RICERCA PRESTITI SCADUTI: " + l);
		}

	}
}
