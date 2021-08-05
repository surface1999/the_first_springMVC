package admin.DAO;
import java.util.List;

import admin.entity.Book;


public interface BookDAO {
	public List<Book> getListBooks();
	public Book getBook(int id);
	public void saveBook(Book book);
	public void deleteBook(int id);
	public List<Book> search(String key);
	
}
