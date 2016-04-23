package app05a.domain;

import java.io.Serializable;

public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8250023367178013439L;
    
	private String id;
	private String name;
	private String author;
	private Category category;
	
	public Book() {
		
	}
	
	public Book(String id, String name, String author, Category category) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.category = category;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
    
}
