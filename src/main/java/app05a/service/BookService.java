package app05a.service;

import java.util.Map;

import app05a.domain.Book;
import app05a.domain.Category;

public interface BookService {
	
	Map<String, Category> getAllCategories();
	Category getCategory(String id);
	Map<String, Book> listAllBooks();
	String addBook(Book book);
	String removeBook(String bookId);
	String updateBook(Book book);
	Book queryBook(String bookId);
}
