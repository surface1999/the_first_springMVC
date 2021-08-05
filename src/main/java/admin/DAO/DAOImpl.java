package admin.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import admin.entity.Book;

@Repository
@Transactional
public class DAOImpl implements BookDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Book> getListBooks() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book");
		List<Book> list = query.getResultList();
		session.flush();
		return list;
	}

	public Book getBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.get(Book.class, id);
		session.flush();
		return book;
	}

	public void saveBook(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(book);
		session.flush();

	}

	public void deleteBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = getBook(id);
		session.delete(book);
		session.flush();

	}

	@Override
	public List<Book> search(String key) {
		List<Book> list = getListBooks();
		List<Book> rs = list.stream()
				.filter(item -> item.getName().indexOf(key) != -1)
				.collect(Collectors.toList());
		return rs;
	}
}
