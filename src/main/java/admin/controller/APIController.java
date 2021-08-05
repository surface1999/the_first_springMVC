package admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import admin.entity.Book;
import admin.services.BookService;

@RestController
public class APIController {
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getAll() {
		List<Book> list = bookService.getListBooks();
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> search(@RequestParam("q") String q) {
		List<Book> list = bookService.search(q);
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/getbook", method = RequestMethod.GET)
	public ResponseEntity<Book> getBookById(@RequestParam("id") int id) {
		Book book = bookService.getBook(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<String> update(@RequestBody Book item) {
		Book book = bookService.getBook(item.getId());
		if(book == null) {
			return new ResponseEntity<String>("Not found book!", HttpStatus.NO_CONTENT);
		}
		bookService.saveBook(book);
		return new ResponseEntity<String>("Updated!", HttpStatus.OK);
	}
}
