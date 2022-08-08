package it.epicode.loan;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.epicode.catalog.Catalog;

@Entity
@Table(name = "loans")
@NamedQuery(name = "searchLoanByCardNumber", query = "SELECT l FROM Loan l WHERE l.user.cardNumber = :card AND l.effectiveReturnDate IS NULL")
@NamedQuery(name = "searchExpiredLoan", query = "SELECT l FROM Loan l WHERE l.effectiveReturnDate = null AND l.expectedReturnDate < :date")
public class Loan {

	@Id
	@SequenceGenerator(name = "loan_seq", sequenceName = "loan_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
	private int id;

	@ManyToOne
	private User user;

	@OneToOne
	private Catalog loanedElement;

	private LocalDate startLoanDate;
	private LocalDate expectedReturnDate;
	private LocalDate effectiveReturnDate;

	public Loan(User user, Catalog loanedElement, LocalDate startLoanDate) {
		this.user = user;
		this.loanedElement = loanedElement;
		this.startLoanDate = startLoanDate;
		// Data di restituzione prevista settata a 30 giorni dalla data di inizio del
		// prestito
		this.expectedReturnDate = startLoanDate.plusDays(30);
	}

	public Loan() {
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Catalog getLoanedElement() {
		return loanedElement;
	}

	public LocalDate getStartLoanDate() {
		return startLoanDate;
	}

	public LocalDate getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public LocalDate getEffectiveReturnDate() {
		return effectiveReturnDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setLoanedElement(Catalog loanedElement) {
		this.loanedElement = loanedElement;
	}

	public void setStartLoanDate(LocalDate startLoanDate) {
		this.startLoanDate = startLoanDate;
	}

	public void setExpectedReturnDate(LocalDate expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public void setEffectiveReturnDate(LocalDate effectiveReturnDate) {
		this.effectiveReturnDate = effectiveReturnDate;
	}

	@Override
	public String toString() {
		return "Prestito [ id : " + id + ", utente : " + user + ", elementoPrestato : " + loanedElement
				+ ", dataInizioPrestito : " + startLoanDate + ", dataRestituzionePrevista : " + expectedReturnDate
				+ ", dataRestituzioneEffettiva : " + effectiveReturnDate + " ]";
	}

}
