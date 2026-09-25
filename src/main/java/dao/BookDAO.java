package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDAO {

	public List<Book> findAll() {
		List<Book> books = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/~/readingapp";
		String sql = "SELECT id, title, author, status FROM books ORDER BY id";

		try {
			Class.forName("org.h2.Driver");

			try (Connection conn = DriverManager.getConnection(url, "sa", "");
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery()) {

				System.out.println("H2接続成功！");

				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String author = rs.getString("author");
					String status = rs.getString("status");

					Book book = new Book(id, title, author, status);
					books.add(book);
				}

				System.out.println("取得件数:" + books.size());
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	public boolean insert(Book book) {

		String url = "jdbc:h2:tcp://localhost/~/readingapp";
		String sql = "INSERT INTO books (title, author, status) VALUES (?, ?, ?)";

		try {
			Class.forName("org.h2.Driver");

			try (Connection conn = DriverManager.getConnection(url, "sa", "");
					PreparedStatement ps = conn.prepareStatement(sql)) {

				ps.setString(1, book.getTitle());
				ps.setString(2, book.getAuthor());
				ps.setString(3, book.getStatus());

				int count = ps.executeUpdate();

				return count == 1;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Book findById(int id) {

		String url = "jdbc:h2:tcp://localhost/~/readingapp";
		String sql = "SELECT id, title, author, status FROM books WHERE id = ?";

		try {
			Class.forName("org.h2.Driver");

			try (Connection conn = DriverManager.getConnection(url, "sa", "");
					PreparedStatement ps = conn.prepareStatement(sql)) {

				ps.setInt(1, id);

				try (ResultSet rs = ps.executeQuery()) {

					if (rs.next()) {
						String title = rs.getString("title");
						String author = rs.getString("author");
						String status = rs.getString("status");

						return new Book(id, title, author, status);
					}
				}

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean update(Book book) {

		String url = "jdbc:h2:tcp://localhost/~/readingapp";

		String sql = "UPDATE books SET title = ?, author = ?, status = ? WHERE id = ?";

		try {
			Class.forName("org.h2.Driver");

			try (Connection conn = DriverManager.getConnection(url, "sa", "");
					PreparedStatement ps = conn.prepareStatement(sql)) {

				ps.setString(1, book.getTitle());
				ps.setString(2, book.getAuthor());
				ps.setString(3, book.getStatus());
				ps.setInt(4, book.getId());

				int count = ps.executeUpdate();

				return count == 1;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {

		String url = "jdbc:h2:tcp://localhost/~/readingapp";
		String sql = "DELETE FROM books WHERE id = ?";

		try {
			Class.forName("org.h2.Driver");

			try (Connection conn = DriverManager.getConnection(url, "sa", "");
					PreparedStatement ps = conn.prepareStatement(sql)) {

				ps.setInt(1, id);

				int count = ps.executeUpdate();

				return count == 1;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}