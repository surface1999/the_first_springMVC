package admin.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.DAO.BookDAO;
import admin.entity.Book;

@Service
@Transactional
public class BookService {
	@Autowired
	private BookDAO bookDAO;

	public List<Book> getListBooks() {
		return bookDAO.getListBooks();
	}

	public Book getBook(int id) {
		return bookDAO.getBook(id);
	}

	public void saveBook(Book book) {
		bookDAO.saveBook(book);
	}

	public void deleteBook(int id) {
		bookDAO.deleteBook(id);
	}
	
	public List<Book> search(String key) {
		return bookDAO.search(key);
	}
}
