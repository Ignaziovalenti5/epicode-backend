package it.epicode.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.Program;
import it.epicode.catalog.Book;
import it.epicode.catalog.Catalog;
import it.epicode.utils.JpaUtil;

public class CatalogDAO implements CatalogDAOInterface {

	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	@Override
	public void addCatalogElement(Catalog element) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(element);
			transaction.commit();
		} catch (Exception e) {
			log.error("Errore nell'aggiunta dell'elemento al catalogo. " + e);
		} finally {
			em.close();
		}
	}

	@Override
	public void removeCatalogElement(String isbnCode) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("searchForISBNCode", Catalog.class);
			query.setParameter("isbn", isbnCode);
			Catalog el = query.getSingleResult();
			int id = el.getId();
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(id);
			transaction.commit();

		} catch (Exception e) {
			log.error("Errore nella rimozione dell'elemento dal catalogo. " + e);
		} finally {
			em.close();
		}

	}

	@Override
	public Catalog searchForIsbnCode(String isbnCode) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("searchForISBNCode", Catalog.class);
			query.setParameter("isbn", isbnCode);
			Catalog el = query.getSingleResult();
			return el;
		} catch (Exception e) {
			log.error("Errore nella ricerca per codice ISBN. " + e);
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Catalog> searchForPubblicationYear(String year) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("searchForYear", Catalog.class);
			query.setParameter("year", year);
			List<Catalog> lis = query.getResultList();
			return lis;
		} catch (Exception e) {
			log.error("Errore nella ricerca per anno di pubblicazione. " + e);
			return new ArrayList<Catalog>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Book> searchForAuthor(String author) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("searchForAuthor", Book.class);
			query.setParameter("author", author);
			List<Book> lis = query.getResultList();
			return lis;
		} catch (Exception e) {
			log.error("Errore nella ricerca per autore. " + e);
			return new ArrayList<Book>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Catalog> searchForTitle(String title) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("searchForTitleOrParts", Catalog.class);
			query.setParameter("title", "%" + title + "%");
			List<Catalog> lis = query.getResultList();
			return lis;
		} catch (Exception e) {
			log.error("Errore nella ricerca per codice ISBN. " + e);
			return new ArrayList<Catalog>();
		} finally {
			em.close();
		}
	}

}
