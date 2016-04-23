package app05a.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app05a.domain.Book;
import app05a.domain.Category;
import app05a.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value="/showAllBooks")
	public String showAllBooks(Model model) {
		Map<String, Book> booksMaps = bookService.listAllBooks();
//		List<Book> books = booksMaps.values().toArray();
		model.addAttribute("books", booksMaps.values());

		return "BookList";

	}
	
	@RequestMapping(value="/book_input")
	public String addBook(Model model) {
		
		model.addAttribute("categories", bookService.getAllCategories().values());
		model.addAttribute("book", new Book());
		
		return "BookAddForm";
	}
	
	@RequestMapping(value="/book_save", method=RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		Category targetCategory = bookService.getCategory(book.getCategory().getId());
		book.setCategory(targetCategory);
		
		bookService.addBook(book);
		return "redirect:/showAllBooks";
	}
	
	@RequestMapping(value="/book_edit/{id}")
	public String editBook(@PathVariable String id, Model model) {
		Book book = bookService.queryBook(id);
		model.addAttribute("book", book);
		model.addAttribute("categories", bookService.getAllCategories().values());
		return "BookEditForm";
	}
	
	@RequestMapping(value="/book_edit/book_update", method=RequestMethod.POST)
	public String updateBook(@ModelAttribute Book book) {
		Category targetCategory = bookService.getCategory(book.getCategory().getId());
		book.setCategory(targetCategory);
		bookService.updateBook(book);
		
		return "redirect:/showAllBooks";
	}
	
	@RequestMapping(value="/book_delete/{id}")
	public String deleteBook(@PathVariable String id) {
		bookService.removeBook(id);
		return "redirect:/showAllBooks";
	}
    
}