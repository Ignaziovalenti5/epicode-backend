package it.epicode.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.Program;
import it.epicode.loan.Loan;
import it.epicode.loan.User;
import it.epicode.utils.JpaUtil;

public class LoanDAO {
	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public void addLoan(Loan loan) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(loan);
			transaction.commit();
		} catch (Exception e) {
			log.error("Errore nell'aggiunta del prestito" + e);
		} finally {
			em.close();
		}
	}

	public void addUser(User user) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			transaction.commit();
		} catch (Exception e) {
			log.error("Errore nella rimozione del prestito" + e);
		} finally {
			em.close();
		}
	}
	
	public void returnCatalog(int loanId) {
		EntityManager em = emf.createEntityManager();

		try {
			Loan l = em.find(Loan.class, loanId);

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			l.setEffectiveReturnDate(LocalDate.now());			
			trans.commit();

		} catch (Exception e) {
			log.error("Errore", e);

		} finally {
			em.close();

		}
	}

	public List<Loan> searchLoansByCardNumber(int cardNumber) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("searchLoanByCardNumber", Loan.class);
			query.setParameter("card", cardNumber);
			List<Loan> lis = query.getResultList();
			return lis;
		} catch (Exception e) {
			log.error("Error nella ricerca." + e);
			return new ArrayList<Loan>();
		} finally {
			em.close();
		}
	}

	public List<Loan> searchExpiredLoans() {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("searchExpiredLoan", Loan.class);
			query.setParameter("date", LocalDate.now());
			List<Loan> lis = query.getResultList();
			return lis;
		} catch (Exception e) {
			log.error("Error nella ricerca." + e);
			return new ArrayList<Loan>();
		} finally {
			em.close();
		}
	}
}
