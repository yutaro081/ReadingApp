package model;

public class Book {

	private int id;
	private String title;
	private String author;
	private String status;

	//新規登録するとき用
	public Book(String title, String author, String status) {
		this.title = title;
		this.author = author;
		this.status = status;
	}

	//DBから取得するとき用
	public Book(int id, String title, String author, String status) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getStatus() {
		return status;
	}

}