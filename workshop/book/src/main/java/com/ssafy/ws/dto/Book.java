package com.ssafy.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
//@Data
public class Book {
	private  String isbn;
	private  String title;
	private  String author;
	private  int price;
	private String desc;
	private String img;
//	
//	public Book() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Book(String isbn, String title, String author, int price, String desc, String img) {
//		super();
//		this.isbn = isbn;
//		this.title = title;
//		this.author = author;
//		this.price = price;
//		this.desc = desc;
//		this.img = img;
//	}
	
	@Builder
	public Book(String isbn, String title, String author, int price, String desc) {
		this(isbn, title, author, price, desc, null);
	}
	
//	public String getImg() {
//		return img;
//	}
//	public void setImg(String img) {
//		this.img = img;
//	}
//	public String getIsbn() {
//		return isbn;
//	}
//	public void setIsbn(String isbn) {
//		this.isbn = isbn;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getAuthor() {
//		return author;
//	}
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//	public int getPrice() {
//		return price;
//	}
//	public void setPrice(int price) {
//		this.price = price;
//	}
//	public String getDesc() {
//		return desc;
//	}
//	public void setDesc(String desc) {
//		this.desc = desc;
//	}
//	@Override
//	public String toString() {
//		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + ", desc=" + desc
//				+ "]";
//	}
	
}
