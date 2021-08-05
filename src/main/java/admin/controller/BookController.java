package admin.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import admin.entity.Book;
import admin.services.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	private Path path;
	@Autowired
	private BookService bookServices;

	@RequestMapping("/list")
	public String getList(Model model) {
		List<Book> list = bookServices.getListBooks();
		model.addAttribute("list", list);
		return "list-books";
	}

	@RequestMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "form-book";
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book, HttpServletRequest request) {
		bookServices.saveBook(book);
		MultipartFile bookImage = book.getBookImage();

		/*
		 * String rootDirectory =
		 * request.getSession().getServletContext().getRealPath("/"); Path path =
		 * Paths.get(rootDirectory +
		 * "\\WEB-INF\\resources\\images\\" + book.getId() + ".png");
		 * System.out.println(path.toString());
		 */
		path = Paths.get("D:\\web\\admin\\src\\main\\webapp\\WEB-INF\\resources\\images\\" + book.getId() + ".png");
		book.setAvatar("/resources/images/" + book.getId() + ".png");
		bookServices.saveBook(book);
		if (bookImage != null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed", e);
			}
		}
		return "redirect:list";
	}
	
	@RequestMapping("/updateBook")
	public String addBook(@RequestParam("id") int id, Model model) {
		Book book = bookServices.getBook(id);
		model.addAttribute("book", book);
		return "form-book";
	}

	@RequestMapping("/deleteBook")
	public String delete(@RequestParam("id") int id) {
		path = Paths.get("D:\\web\\admin\\src\\main\\webapp\\WEB-INF\\resources\\images\\" + id + ".png");
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		bookServices.deleteBook(id);
		return "redirect:list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("q") String q, Model model) {
		List<Book> rs = bookServices.search(q);
		model.addAttribute("list", rs);
		return "list-books";
	}

}
