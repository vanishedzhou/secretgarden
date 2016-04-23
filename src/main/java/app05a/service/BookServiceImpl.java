package app05a.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import app05a.domain.Book;
import app05a.domain.Category;

@Service
public class BookServiceImpl implements BookService {
	private Map<String, Book> allBooks = new HashMap<String, Book>();
	private Map<String, Category> allCategories = new HashMap<String, Category>();
	
	public Map<String, Book> getAllBooks() {
		return allBooks;
	}

	@Override
	public Map<String, Category> getAllCategories() {
		return allCategories;
	}

	public BookServiceImpl() {
		Category category1 = new Category ("00001", "categ1");
		Category category2 = new Category ("00002", "categ2");
		Category category3 = new Category ("00003", "categ3");
		
		allCategories.put(category1.getId(), category1);
		allCategories.put(category2.getId(), category2);
		allCategories.put(category3.getId(), category3);

		Book b1 = new Book("001", "name1", "author1", category1);
		Book b2 = new Book("002", "name2", "author2", category2);
		Book b3 = new Book("003", "name3", "author3", category3);
		
		allBooks.put(b1.getId(), b1);
		allBooks.put(b2.getId(), b2);
		allBooks.put(b3.getId(), b3);
	}

	@Override
	public Map<String, Book> listAllBooks() {
		return allBooks;
	}

	@Override
	public String addBook(Book book) {
		allBooks.put(book.getId(), book);
		return book.getId();
	}

	@Override
	public String removeBook(String bookId) {
		allBooks.remove(bookId);
		return bookId;
	}

	@Override
	public String updateBook(Book book) {
		allBooks.put(book.getId(), book);
		
		return book.getId();
	}

	@Override
	public Book queryBook(String bookId) {
		
		return allBooks.get(bookId);
	}

	@Override
	public Category getCategory(String id) {
		return allCategories.get(id);
	}

}
